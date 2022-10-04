using UnityEngine;
using UnityEngine.UI;
using System.Collections;
using System.Collections.Generic;
using System;
using Ink.Runtime;

// Well, we should have the game only start IF the server is running... SO 
// Let's have it where the server needs to connect first before anything else 
// happens... Or we could have it where the game asks if the server has 
// started.

// This is a super bare bones example of how to play and display a ink story in Unity.
public class BasicInkExample : MonoBehaviour {
    public static event Action<Story> OnCreateStory;
	private static Boolean threadConsistency = true;

	public GameObject server;
	private Client client;
	private string serverData = "";
	private Boolean shouldEnd = false;
	private Boolean serverConnected = false;
	// Using IEnumerator waiter to wait for Server response... Which is rather
	// silly if you ask me. 
	// TODO: Fix this, that way we can just turn off this function whenever
	// we want to remove ABL.
	IEnumerator waiter(Choice choice) {
		yield return new WaitForSecondsRealtime(1);
		if (this.serverData != "") {	
			Debug.Log("this is firing");
			story.ChoosePathString("event_end");
			serverData = "";
		} else {
			story.ChooseChoiceIndex (choice.index);
		}
		RefreshView();
	}
	IEnumerator TryServer() {
		yield return new WaitForSecondsRealtime(1);
		// This should ping the server and see if it is connected.
		Debug.Log(client.connected);
	}
	// TODO: This seems silly? Why are we doing this?
	public void HandleShouldEndData(string msg) {
		if (msg == "0") {
			shouldEnd = false;
		} else {
			shouldEnd = true;
		}
	}
	public void HandleSceneData(string msg) {
		Debug.Log(msg);
		this.serverData = msg;
	}
	public void HandleVarData(string var, string msg) {
		story.variablesState[var] = msg;
	}
    void Awake () {
		while (!serverConnected) {
			//TODO have the game try the server. If its fails, then it should 
			// NOT let the player continue. Then we can focus on having ABL on
			// and off.
			TryServer();
			serverConnected = true;
		}
		// Remove the default message
		RemoveChildren();
		StartStory();
	}
	// Creates a new Story object with the compiled story which we can then play!
	void StartStory () {
		story = new Story (inkJSONAsset.text);
        if(OnCreateStory != null) { OnCreateStory(story); }
		RefreshView();
	}
	
	// This is the main function called every time the story changes. It does a few things:
	// Destroys all the old content and choices.
	// Continues over all the lines of text, then displays all the choices. If there are no choices, the story is finished!
	void RefreshView () {
		// check to see if we are in epilogue...
		// Remove all the UI on screen
		RemoveChildren ();
		// TODO: The most busted line of code in here. Honestly, this should
		// be destroyed with a vindictive zeal only conjured up by the most
		// dogmatic of individuals. 
		// Basically makings sure the first string is fired within each story
		// state so we can evaluate the state string.
		story.Continue();
		string state  = (string) story.variablesState["state"];
		Debug.Log(state);
		// Read all the content until we can't continue any more
		while (story.canContinue) {
			// Continue gets the next line of the story
			string text = story.Continue();
			// This removes any white space from the text.
			text = text.Trim();
			// Display the text on screen!
			CreateContentView(text);
		}

		// Display all the choices, if there are any!
		if(story.currentChoices.Count > 0) {
			for (int i = 0; i < story.currentChoices.Count; i++) {
				Choice choice = story.currentChoices [i];
				Button button = CreateChoiceView(choice.text.Trim ());
				// Tell the button what to do when we press it
				button.onClick.AddListener (delegate {
					OnClickChoiceButton (choice);
				});
			}
		}
		// If we've read all the content and there's no choices, the story is finished!
		else {
			server.GetComponent<Client>().SendServerMessage("ShouldEnd");
			Button choice = CreateChoiceView("End of story.\nRestart?");
			choice.onClick.AddListener(delegate{
				StartStory();
			});
		}
		AddABLToggleButton();
	}

	void AddABLToggleButton() {
		Button choice = Instantiate (buttonPrefab, new Vector3(0,0,0), Quaternion.identity);		
		choice.transform.SetParent (canvas.transform, false);
		// Gets the text from the button prefab
		Text choiceText = choice.GetComponentInChildren<Text> ();
		
		if (threadConsistency) {
			choiceText.text = "Turn off MICE Consistency. (Turn off ABL decision making.)";
		} else {
			choiceText.text = "Turn on MICE Consistency. (Turn on ABL decision making.)";
		}
		// Make the button expand to fit the text
		HorizontalLayoutGroup layoutGroup = choice.GetComponent <HorizontalLayoutGroup> ();
		layoutGroup.childForceExpandHeight = false;
		choice.onClick.AddListener (delegate {OnClickConsitencyButton (choice);});
		choice.GetComponent<RectTransform>().anchoredPosition = new Vector2(0, 0);
		Debug.Log(choice.GetComponent<RectTransform>().anchoredPosition);
	}

	void OnClickConsitencyButton(Button choice) {
		threadConsistency = !threadConsistency;
		Debug.Log(threadConsistency);
		GameObject.Destroy (choice.gameObject);
		AddABLToggleButton();
	} 
	// When we click the choice button, tell the story to choose that choice!
	void OnClickChoiceButton (Choice choice) {
		string state = (string) story.variablesState["state"];
		Debug.Log("Sending message...");
		server.GetComponent<Client>().SendServerMessage(state);
		StartCoroutine(waiter(choice));
		// TODO: Figure out a way to only have one RefreshView function...
		// That way we don't have to worry about multiple places this function
		// fires.
		// RefreshView();
	}

	// Creates a textbox showing the the line of text
	void CreateContentView (string text) {
		Text storyText = Instantiate (textPrefab) as Text;
		storyText.text = text;
		storyText.transform.SetParent (canvas.transform, false);
	}

	// Creates a button showing the choice text
	Button CreateChoiceView (string text) {
		// Creates the button from a prefab
		Button choice = Instantiate (buttonPrefab) as Button;
		choice.transform.SetParent (canvas.transform, false);
		
		// Gets the text from the button prefab
		Text choiceText = choice.GetComponentInChildren<Text> ();
		choiceText.text = text;

		// Make the button expand to fit the text
		HorizontalLayoutGroup layoutGroup = choice.GetComponent <HorizontalLayoutGroup> ();
		layoutGroup.childForceExpandHeight = false;

		return choice;
	}


	// Destroys all the children of this gameobject (all the UI)
	void RemoveChildren () {
		int childCount = canvas.transform.childCount;
		for (int i = childCount - 1; i >= 0; --i) {
			GameObject.Destroy (canvas.transform.GetChild (i).gameObject);
		}
	}

	[SerializeField]
	private TextAsset inkJSONAsset = null;
	public Story story;

	[SerializeField]
	private Canvas canvas = null;

	// UI Prefabs
	[SerializeField]
	private Text textPrefab = null;
	[SerializeField]
	private Button buttonPrefab = null;
}

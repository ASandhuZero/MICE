package server;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import abl.generated.AuthorAgent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//TODO: Figure out some kind of datastructure for the WME tags.
public class StoryRunner {
	
	private static StoryRunner runner;
	private TCPServer server;
	private Location starting_village = new Location("starting_village");
	private Location player_location = starting_village;
	private AuthorAgent agent;
	private String playerChoice = "event";
	
    public static void main(String[] args) throws IOException {
    	
    	//TODO: We need to figure out how to open up ABL and add in our own
    	// 		call backs.
    	Gson gson = new GsonBuilder().setPrettyPrinting().create();

    	Map<String, StoryNode> nodes = new HashMap<String, StoryNode>();

    	try {
    		nodes = gson.fromJson(
    					new FileReader("../../story.json"), Map.class);
    		
    		System.out.println(gson.toJson(nodes));
    		System.out.println(nodes.get("node1"));
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    		System.out.println("Issue with converting json to java.");
    	}
	
    	Scanner scan = new Scanner(System.in);
    	
    	runner = new StoryRunner();
    	// The server handles any kind of Unity and Javascript calls.
    	//TODO: Get Unity and Java talking to each other, so you can have 
    	// event listeners on the player choice function.
    	runner.setAgent(new AuthorAgent());
    	new Thread(() -> runner.getAgent().startBehaving()).start();
    	
    	runner.server = new TCPServer();
    	new Thread(() -> runner.server.startServer(runner, gson, 5000)).start();
    	
    	//TODO: Create an event listener that fires sendOutgoingMessage whenever
    	// 		something specific happens.
    	scan.close();
    	
    }
    //TODO: figure out how to input story nodes...
    //TODO: Figure out how to map behaviors to WMEs.
    // Can a behavior save a WME in itself?
    public static String PrintPlayerOptions() {
    	String options = "";
    	String locationString = "Which location to go to?";
    	options += locationString;
    	return options;
    }
    public static StoryRunner getInstance() {	
    	return runner;
    }
    public String getPlayerChoice() {
    	return playerChoice;
    }
    public void setChoice(String state) {
    	this.playerChoice = state;
    	System.out.println(this.playerChoice);
    }
    public AuthorAgent getAgent() {
    	return agent;
    }
    public void setAgent(AuthorAgent agent) {
    	this.agent = agent;
    }
    public String getLocationName() {
    	return player_location.getLocation();
    }
    public TCPServer getServer() {
    	return this.server;
    }
}

class Location {
	public String location;
	public Location(String locationName) {
		this.location = locationName;
	}
	public String getLocation() {
		return location;
	}
}
class StoryNode {
	public String text;
	public String[] next;
}

class Story 
{
	public String start;
	public String middle;
	public String end;
	public String[] resolutions;
	public String type;
	public String location;
}
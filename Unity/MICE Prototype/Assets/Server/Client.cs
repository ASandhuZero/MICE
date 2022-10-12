using UnityEngine;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Net.Sockets;
using System.Text;
using System.Threading;

//Just some testing code from this gist
// https://gist.github.com/danielbierwirth/0636650b005834204cb19ef5ae6ccedb
// Should be replaced with a more robust message system.

public class Client : MonoBehaviour {  	
	public Boolean connection;
	public Boolean connected = false;
	public GameObject SceneController;
	#region private members 	
	private BasicInkExample inkscript;
	private TcpClient socketConnection; 	
	private Thread clientReceiveThread;
    private int _PORT = 5000;
	private Boolean heartbeat = true; // UHH?? TODO: Is this right?
	#endregion  	

	// Use this for initialization 	
	void Start () {
		// Check to see if it connects
		ConnectToTcpServer();
		// connected doesn't exist... so you might want to figure this lol.
		String status = connected ? "Server has connected" : "Server has failed connection";
		// ... If the server isn't running, then we should first run the dang 
		//	server.
		Debug.Log(status);
		// inkscript = SceneController.GetComponent<BasicInkExample>();
	}  	
	/// <summary> 	
	/// Setup socket connection. 	
	/// </summary> 	
	private void ConnectToTcpServer () {
		try {
			clientReceiveThread = new Thread(new ThreadStart(ListenForData));
			clientReceiveThread.IsBackground = true;
			Debug.Log(clientReceiveThread);
			//TODO: Switch out to a different server set up... Or find the best way to do this lol.	
		}
		catch (Exception e) {
			Debug.Log("On client connect exception " + e);
		}
	}
	/// <summary> 	
	/// Runs in background clientReceiveThread; Listens for incoming data. 	
	/// </summary>     
	private void ListenForData() { 		
		try { 			
			socketConnection = new TcpClient("localhost", _PORT);  			
			Byte[] bytes = new Byte[1024];
			// TODO: this should not be while true... That seems silly.
			// CHECK TO SEE IF HEARTBEAT WORKS.
			while (heartbeat) { 				
				// Get a stream object for reading 				
				using (NetworkStream stream = socketConnection.GetStream()) { 					
					int length;
					// Read incoming stream into byte array.
					while ((length = stream.Read(bytes, 0, bytes.Length)) != 0) {
						var incomingData = new byte[length];
						Array.Copy(bytes, 0, incomingData, 0, length);
						// Convert byte array to string message.
						string serverMessage = Encoding.ASCII.GetString(incomingData);
						serverMessage = serverMessage.Trim();
						if (serverMessage[0] == '0') {
							Debug.Log("WE ARE FIRING OFF THE SCENE");
							inkscript.HandleSceneData	(serverMessage.Substring(1));
						} else if (serverMessage[0] == '1') {
							inkscript.HandleShouldEndData(serverMessage.Substring(1));
						} else {
							inkscript.HandleVarData("text", serverMessage.Substring(1));
						}
						Debug.Log("server message received as: " + serverMessage);
						if (!connected) { connected = true; }
					} 				
				} 			
			}         
		}         
		catch (SocketException socketException) {             
			Debug.Log("Socket exception: " + socketException);         
		}     
	}  	



    public void SendServerMessage(string msg) {
        if (socketConnection == null) {             
            Debug.Log("Socket connect is null.");
			return;
		}
		try { 
			// Get a stream object for writing.
			NetworkStream stream = socketConnection.GetStream(); 			
			if (stream.CanWrite) {  
				string clientMessage = msg;
                clientMessage += "\n";
				// Convert string message to byte array.                 
				byte[] clientMessageAsByteArray = Encoding.ASCII.GetBytes(clientMessage); 				
				// Write byte array to socketConnection stream.                 
				stream.Write(clientMessageAsByteArray, 0, clientMessageAsByteArray.Length);                 
				Debug.Log("Client sent message - should be received by server");             
			}         
		} 		
		catch (SocketException socketException) {             
			Debug.Log("Socket exception: " + socketException);         
		}     
	}     
}
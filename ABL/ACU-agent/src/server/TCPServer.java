package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map; //TODO: Remove this when we understand GSON.
import java.util.HashMap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import abl.wmes.*;

//TODO: Make this the main file. It doesn't make sense that StoryRunner takes
//		care of this.
public class TCPServer {
	Socket clientSocket;
	// Start the server...
	// Wait for connection...
	// Once connection has been made, send a heart beat to the client...
	//		1. The heart beat's purpose is to let the client know that the 
	//		server is still operational.
	// Then start up ABL.
	
	public static void main(String[] args) throws IOException {
		// TODO: This should probably be its own function, honestly.
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		StoryNodes nodes;
		nodes = JsonGenerator("../../story.json");
//    	Map<String, StoryNode> nodes = new HashMap<String, StoryNode>();
//    	try (FileReader fr = new FileReader("../../story.json")){
//    		nodes = gson.fromJson(fr, Map.class);
//    		
//       		System.out.println(gson.toJson(nodes));
//    		System.out.println(nodes.get("node1"));
//    	} catch (FileNotFoundException e) {
//    		e.printStackTrace();
//    		System.out.println("Issue with converting json to java.");
//    	}

	}
	
	public static StoryNodes JsonGenerator(String file) throws IOException {
		StoryNodes storyNodes = new StoryNodes();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
    	try (FileReader fr = new FileReader(file)){
    		storyNodes = gson.fromJson(fr, StoryNodes.class);
    		
       		System.out.println(gson.toJson(storyNodes));
//    		System.out.println(nodes.get("node1"));
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    		System.out.println("Issue with converting json to java.");
    	}
		
		return storyNodes;
	}
	
	
	public void startServer(StoryRunner runner, Gson gson, int port) {
		boolean shouldContinueSending = true;
		while (shouldContinueSending) {
			try (ServerSocket serverSocket = new ServerSocket(port)) {
				System.out.println("Server is listening on port " + port);
				
				this.clientSocket = serverSocket.accept();
				InputStream input = this.clientSocket.getInputStream();
				System.out.println("New client connected");
				// TODO: Put this into a try/except block, with in being a 
				// resource.
				BufferedReader in = new BufferedReader(
						new InputStreamReader(input));
				
				String message = "";
				while ((message = in.readLine()) != null) {
					System.out.println(message);
					if (message.equals("END")) {shouldContinueSending = false;}
					else {SendToABL(runner, message);}
				}
				System.out.format("Message: %s has been read." +
									" Now waiting...", message);
			} catch (IOException ex) {
				System.out.println("Server exception: " + ex.getMessage());
				ex.printStackTrace();
			}
		}		
    }
	private void SendToABL(StoryRunner runner, String msg) {
		TagWME wme = new TagWME(msg);
		System.out.println(wme);
		runner.getAgent().addWME(wme);
	}
    public void sendOutgoingMessage(String msg) {
    	System.out.println("Sending outgoing message...");
    	OutputStream output = null;
		try {
			output = this.clientSocket.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error sending message: output stream");
		}
        PrintWriter writer = new PrintWriter(output, true);
        writer.println(msg);
    }
    public Socket getClientSocket() {
    	return this.clientSocket;
    }
}

class StoryNodes {
	public Map<String, StoryNode> nodes = new HashMap<String, StoryNode>();

}

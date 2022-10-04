package Runner;

import java.io.*;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;
import abl.wmes.*;

public class Server {
	Socket clientSocket;
	// Start the server...
	// Wait for connection...
	// Once connection has been made, send a heart beat to the client...
	//		1. The heart beat's purpose is to let the client know that the 
	//		server is still operational. 
	public void startServer(StoryRunner runner, Gson gson, int port) {
		boolean shouldContinueSending = true;
		while (shouldContinueSending) {
			//runner.getAgent().deleteAllWMEClass("TagWME"); //TODO PLEASE REMOVE
			try (ServerSocket serverSocket = new ServerSocket(port)) {
				System.out.println("Server is listening on port " + port);
				
				this.clientSocket = serverSocket.accept();
				InputStream input = this.clientSocket.getInputStream();
				System.out.println("New client connected");
				
				BufferedReader in = new BufferedReader(new InputStreamReader(input));
				
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

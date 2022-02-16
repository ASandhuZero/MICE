package Server;

import java.lang.reflect.Field;


import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import abl.generated.MICEAgent;
import game.GameEngine;
/**
 * This program demonstrates a simple TCP/IP socket server.
 *
 * @author www.codejava.net
 * ADD more docs if need be?
 */


public class TCPServer {
	private long data = -1;
	
	
	private static TCPServer server;
	
	public void startAgent() {
		MICEAgent agent = new MICEAgent();
		agent.startBehaving();
	}
	
	// TODO: We are transforming multiple times, probably too much.
    public static void main(String[] args) {
    	server = new TCPServer();
    	server.startAgent();

    }
}
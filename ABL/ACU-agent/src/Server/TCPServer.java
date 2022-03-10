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
/**
 * This program demonstrates a simple TCP/IP socket server.
 *
 * @author www.codejava.net
 * ADD more docs if need be?
 */
/**
 * Okay, so I guess today we are going to be doing something a little bit different.
 * So, how can we break down the overall story structure the way that Josh wants me to do?
 * 
 * Well, we know for sure that a part of the story is going to be something about the setting.
 * However, we need to know when the setting actually becomes a Milieu story. 
 * So, that means that Milieu stories aren't actually associated with characters, but instead when
 * they get sent to some place. Like a prison or something like that?
 * 
 * So think about how loZ does this with the use of the Dark World, right?
 */
// We want to have a story guided by MICE. 
// Let's first start by opening up a character story!
// We need story data first.
// We have a beginning, middle, and end. So let's use these to be the driving action in terms of 
// making new MICE connections. Don't forget that you can do a fractal story telling thing. Where 
// each start can be interlaced properly. You just have to close out the stories correctly. 
// Locations matter. Notice how you have the cake realm and the ovenless realm. Are stories
// locked into these realms? Do you need to resolve them first?
// Does going into the middle bit increase story intensity?

public class TCPServer {
	
	private static TCPServer server;
	
	private static Story milieu = new Story();
	private static Story inquiry = new Story();
	private static Story character = new Story();
	private static Story event = new Story();
	
	public void startAgent() {
		MICEAgent agent = new MICEAgent();
		agent.startBehaving();
	}
	
    public static void main(String[] args) {
    	milieu.start = "Jackson, one day, finds himself within the wizard's court. He eats a well-made cake, watching the apprentice wizards perform their magics. One of the stray magicked spells hits Jackson, and the spell teleports him to a mirror world with no ovens.";
        milieu.middle = "Aghast, Jackson searches far and wide, trying to escape from such a mad world. ";
        milieu.end = "Yet, he can't find an oven anywhere. So, Jackson, refusing to give up, tries to make his own oven. But he fails and accepts his new, ovenless existence.";
        
        inquiry.start = "Still in the mirrored realm, Jackson discovers someone took a piece of his cake.";
        inquiry.middle = "Confused, Jackson asks the guards if they know who ate his cake.";
        inquiry.end = "Telling him, the guards explain how the king's son took a bite. Glad to know, Jackson bakes a cake for the king's son using the power of the burning glass. And thus, Jackson, still in a realm of mirrors, finally can have his cake and eat it, too.";
    	
    	character.start = "Jackson works within a generic kingdom bakery as a baker of high renown. However, the king gates cakes, which breaks Jackson's heart. As a cake lover and a baker, Jackson wants to convince the world to love cakes. ";
        character.middle = "So, the fool of a mad man goes to the king with a cake of extraordinary make. The king hates it.";
        character.end = "Jackson weeps for this failure. Yet, in his tear-filled hysteria, Jackson learns to accept that others might not like cake, but that doesn't mean he has to stop baking cakes.";
        
        event.start = "One day, a glass falls upon the mirrored realm. It has an inner heat that burns up cities and towns.";
        event.middle = "Shocked, Jackson tries and runs away but notices how it cooks his cake batter.";
        event.end = "Jackson discovers he can focus the Burning Glass's power on baking cakes. The burning glass loses some heat, and Jackson saves the mirrored realm through cake baking.";
    
    	System.out.println(milieu.start);
    	server = new TCPServer();
    	server.startAgent();
    	
    }
}
class Story {
	public String start;
	public String middle;
	public String end;
	public String type;
	public String location;
}
package abl.actions;


import java.awt.Point;

import server.StoryRunner;
/**
 * Sets the trajectory of the chaser. 
 * 
 * @author Ben Weber 3-7-11
 */
public class SendDataAction extends BaseAction {

	/**
	 * Sets the trajectory of the player to move down.
	 * args[0] - bot id
	 */
	public void execute(Object[] args) {
		StoryRunner.getInstance().getServer().sendOutgoingMessage((String) args[0]);
		System.out.println(args[0]);
		System.out.println("Message is being sent through ABL");
		StoryRunner.getInstance().getAgent().deleteAllWMEClass("TagWME");//TODO: THIS SHOULD NOT BE HERE.
		// It is removing all the tags because I don't want the action to constantly fire.
	}
}

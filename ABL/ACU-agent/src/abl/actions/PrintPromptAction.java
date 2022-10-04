package abl.actions;


import java.awt.Point;
import Runner.StoryRunner;
/**
 * Sets the trajectory of the chaser. 
 * 
 * @author Ben Weber 3-7-11
 */
public class PrintPromptAction extends BaseAction {

	/**
	 * Sets the trajectory of the player to move down.
	 * args[0] - bot id
	 */
	public void execute(Object[] args) {
		System.out.printf("%s. This is a test action.\n", args[0]);
//		StoryRunner.getInstance().setStoryProgress(args[0]);
	}
}

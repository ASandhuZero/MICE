package abl.wmes;

import wm.WME;
/**
 * Stores information about the story state and what should happen next. 
 * 
 * In ABL: WME = Working memory element. WMEs are used to provide the agent with game state .
 * 
 * Note: ABL code can access WME properties using standard Java Bean naming conventions 
 * Example: locationX in ABL invoked getLocationX() 
 * 
 * @author Ben Weber 3-7-11
 */
public class ChoiceWME extends WME {

	/** Location of the player */
	private String choice;
	
	/**
	 * Instantiates a working memory element for tracking the player character.
	 */
	public ChoiceWME(String choice) {
		this.choice = choice;
	}
	public String getName() {
		return this.choice;
	}
}

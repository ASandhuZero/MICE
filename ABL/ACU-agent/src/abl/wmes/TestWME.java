package abl.wmes;

import wm.WME;
/**
 * Stores information about the player character.
 * 
 * In ABL: WME = Working memory element. WMEs are used to provide the agent with game state .
 * 
 * Note: ABL code can access WME properties using standard Java Bean naming conventions 
 * Example: locationX in ABL invoked getLocationX() 
 * 
 * @author Ben Weber 3-7-11
 */
public class TestWME extends WME {

	/** Location of the player */
	private String test;
	
	/**
	 * Instantiates a working memory element for tracking the player character.
	 */
	public TestWME(String test) {
		this.test = test;
	}
	public String getTest() {
		return this.test;
	}
}

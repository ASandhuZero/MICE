package abl.sensors;

import Runner.StoryRunner;
import abl.runtime.BehavingEntity;
import abl.wmes.ChoiceWME;
/**
 * Adds a PlayerWME object to working memory when sense in invoked.
 * 
 * @author Ben Weber 3-7-11
 */
public class ChoiceSensor extends SerialSensor {

	/**
	 * Adds a Player WME to working memory of the agent and deletes previous player WMEs in memory.
	 */
	protected void sense() {
		ChoiceWME choiceWME = new ChoiceWME(StoryRunner.getInstance()
				.getPlayerChoice());
//		
		BehavingEntity.getBehavingEntity().deleteAllWMEClass("ChoiceWME");
//		
		BehavingEntity.getBehavingEntity().addWME(choiceWME);
	}
}
	
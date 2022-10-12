package abl.sensors;

import abl.runtime.BehavingEntity;
import abl.wmes.TestWME;
import server.StoryRunner;
/**
 * Adds a PlayerWME object to working memory when sense in invoked.
 * 
 * @author Ben Weber 3-7-11
 */
public class TestSensor extends SerialSensor {

	/**
	 * Adds a Player WME to working memory of the agent and deletes previous player WMEs in memory.
	 */
	protected void sense() {
		TestWME storyWME = new TestWME(StoryRunner.getInstance()
				.getPlayerChoice());
		
		BehavingEntity.getBehavingEntity().deleteAllWMEClass("TestWME");
		
		BehavingEntity.getBehavingEntity().addWME(storyWME);
	}
}
	
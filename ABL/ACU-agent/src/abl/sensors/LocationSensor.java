package abl.sensors;

import Runner.StoryRunner;
import abl.runtime.BehavingEntity;
import abl.wmes.LocationWME;
/**
 * Adds a PlayerWME object to working memory when sense in invoked.
 * 
 * @author Ben Weber 3-7-11
 */
public class LocationSensor extends SerialSensor {

	/**
	 * Adds a Player WME to working memory of the agent and deletes previous player WMEs in memory.
	 */
	protected void sense() {
		LocationWME locationWME = new LocationWME(StoryRunner.getInstance()
				.getLocationName());
		
//		StoryStateWME storyWME = new StoryStateWME(StoryRunner.getInstance()
//				.getStoryState());
//		
		BehavingEntity.getBehavingEntity().deleteAllWMEClass("LocationWME");
		
		BehavingEntity.getBehavingEntity().addWME(locationWME);
	}
}
	
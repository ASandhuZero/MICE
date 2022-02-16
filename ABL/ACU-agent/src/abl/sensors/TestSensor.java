package abl.sensors;

import Server.TCPServer; 
import abl.runtime.BehavingEntity;
import abl.wmes.TestWME;
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
		BehavingEntity.getBehavingEntity().deleteAllWMEClass("TestWME");
		BehavingEntity.getBehavingEntity().addWME(
				new TestWME(TCPServer.getInstance().getTestWME()));
	}
}

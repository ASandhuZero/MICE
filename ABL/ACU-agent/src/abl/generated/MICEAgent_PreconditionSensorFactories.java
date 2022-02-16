package abl.generated;

import abl.runtime.*;
import wm.WME;
import wm.WorkingMemorySet;
import wm.WMEIndex;
import wm.TrackedWorkingMemory;
import java.util.*;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import abl.learning.*;
import abl.wmes.*;
import abl.actions.*;
import abl.sensors.*;
public class MICEAgent_PreconditionSensorFactories {
   static public SensorActivation[] preconditionSensorFactory0(int __$behaviorID) {
      switch (__$behaviorID) {
         case 2: {
               SensorActivation[] __$activationArray = {
                  new SensorActivation(new TestSensor(), null)
               };

               return __$activationArray;

         }
      default:
         throw new AblRuntimeError("Unexpected behaviorID " + __$behaviorID);
      }
   }
}
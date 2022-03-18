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
public class MICEAgent_Analysis {
   static public List<String> analysis0(int __$behaviorID) {
      switch (__$behaviorID) {
         case 0: {
            // MICERoot_1
            List<String> _$analysisStepIDs = new ArrayList<String>();
            _$analysisStepIDs.add("startEventThread()"); // stepID 0
            _$analysisStepIDs.add("MICERoot()"); // stepID 1
            _$analysisStepIDs.add("endEventThread()"); // stepID 2
            return _$analysisStepIDs;
         }
         case 1: {
            // startEventThread_1
            List<String> _$analysisStepIDs = new ArrayList<String>();
            return _$analysisStepIDs;
         }
         case 2: {
            // endEventThread_1
            List<String> _$analysisStepIDs = new ArrayList<String>();
            return _$analysisStepIDs;
         }
         case 3: {
            // milieu_1
            List<String> _$analysisStepIDs = new ArrayList<String>();
            return _$analysisStepIDs;
         }
         case 4: {
            // inquiry_1
            List<String> _$analysisStepIDs = new ArrayList<String>();
            return _$analysisStepIDs;
         }
         case 5: {
            // character_1
            List<String> _$analysisStepIDs = new ArrayList<String>();
            return _$analysisStepIDs;
         }
         case 6: {
            // event_1
            List<String> _$analysisStepIDs = new ArrayList<String>();
            return _$analysisStepIDs;
         }
         case 7: {
            // Wait_1
            List<String> _$analysisStepIDs = new ArrayList<String>();
            return _$analysisStepIDs;
         }
         case 8: {
            // testBehavior_1
            List<String> _$analysisStepIDs = new ArrayList<String>();
            _$analysisStepIDs.add("Wait(int)"); // stepID 12
            _$analysisStepIDs.add("testBehavior()"); // stepID 13
            return _$analysisStepIDs;
         }
         case 9: {
            // MICEAgent_RootCollectionBehavior
            List<String> _$analysisStepIDs = new ArrayList<String>();
            _$analysisStepIDs.add("event()"); // stepID 15
            _$analysisStepIDs.add("MICERoot()"); // stepID 16
            return _$analysisStepIDs;
         }
         case 10: {
            // __$defaultMemoryExecuteBehavior_1
            List<String> _$analysisStepIDs = new ArrayList<String>();
            return _$analysisStepIDs;
         }
      default:
         throw new AblRuntimeError("Unexpected behaviorID " + __$behaviorID);
      }
   }
}

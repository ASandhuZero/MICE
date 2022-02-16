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
public class MICEAgent_StepFactories {
   static public Step stepFactory0(int __$stepID, Behavior __$behaviorParent, final Object[] __$behaviorFrame) {
      final Method __$stepFactory = MICEAgent.__$stepFactory0_rfield;
      switch (__$stepID) {
         case -3: {
            // default wait step
            return new WaitStepDebug(-3, __$stepFactory, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null);
         }
         case -2: {
            // default fail step
            return new FailStepDebug(-2, __$stepFactory, __$behaviorParent, false, false, false, (short)-32768, (short)0, false, null, null);
         }
         case -1: {
            // default succeed step
            return new SucceedStepDebug(-1, __$stepFactory, __$behaviorParent, false, false, (short)-32768, (short)0, false, null, null);
         }
         case 0: {
            // event_1Step1
            return new MentalStepDebug(0, __$stepFactory, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, MICEAgent.__$mentalExecute0_rfield, null, null, null, (byte)2, "event_1Step1");
         }
         case 1: {
            // Wait_1Step1
            return new MentalStepDebug(1, __$stepFactory, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, MICEAgent.__$mentalExecute0_rfield, null, null, null, (byte)2, "Wait_1Step1");
         }
         case 2: {
            // Wait_1Step2
            return new WaitStepDebug(2, __$stepFactory, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, MICEAgent.__$successTest0_rfield, null, null);
         }
         case 3: {
            // testBehavior_1Step1
            return new PrimitiveStepDebug(3, __$stepFactory, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, MICEAgent.__$argumentExecute0_rfield, null, null, null, new TestAction(), null, "testAction");
         }
         case 4: {
            // testBehavior_1Step2
            return new GoalStepDebug(4, __$stepFactory, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, MICEAgent.__$argumentExecute0_rfield, null, null, null, "Wait(int)", null, (short)0);
         }
         case 5: {
            // testBehavior_1Step3
            return new GoalStepDebug(5, __$stepFactory, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "testBehavior()", null, (short)0);
         }
         case 6: {
            // MICEAgent_RootCollectionBehaviorStep1
            return new MentalStepDebug(6, __$stepFactory, __$behaviorParent, false, false, false, false, false, false, (short)3, (short)0, false, null, MICEAgent.__$mentalExecute0_rfield, null, null, null, (byte)2, "MICEAgent_RootCollectionBehaviorStep1");
         }
         case 7: {
            // MICEAgent_RootCollectionBehaviorStep2
            return new GoalStepDebug(7, __$stepFactory, __$behaviorParent, false, false, false, false, false, false, (short)2, (short)0, false, null, null, null, null, null, "event()", null, (short)0);
         }
      default:
         throw new AblRuntimeError("Unexpected stepID " + __$stepID);
      }
   }
}

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
            // MICERoot_1Step1
            return new GoalStepDebug(0, __$stepFactory, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "startEventThread()", null, (short)0);
         }
         case 1: {
            // MICERoot_1Step2
            return new GoalStepDebug(1, __$stepFactory, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "MICERoot()", null, (short)0);
         }
         case 2: {
            // MICERoot_1Step3
            return new GoalStepDebug(2, __$stepFactory, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "endEventThread()", null, (short)0);
         }
         case 3: {
            // startEventThread_1Step1
            return new MentalStepDebug(3, __$stepFactory, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, MICEAgent.__$mentalExecute0_rfield, null, null, null, (byte)2, "startEventThread_1Step1");
         }
         case 4: {
            // endEventThread_1Step1
            return new MentalStepDebug(4, __$stepFactory, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, MICEAgent.__$mentalExecute0_rfield, null, null, null, (byte)2, "endEventThread_1Step1");
         }
         case 5: {
            // milieu_1Step1
            return new MentalStepDebug(5, __$stepFactory, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, MICEAgent.__$mentalExecute0_rfield, null, null, null, (byte)2, "milieu_1Step1");
         }
         case 6: {
            // inquiry_1Step1
            return new MentalStepDebug(6, __$stepFactory, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, MICEAgent.__$mentalExecute0_rfield, null, null, null, (byte)2, "inquiry_1Step1");
         }
         case 7: {
            // character_1Step1
            return new MentalStepDebug(7, __$stepFactory, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, MICEAgent.__$mentalExecute0_rfield, null, null, null, (byte)2, "character_1Step1");
         }
         case 8: {
            // event_1Step1
            return new MentalStepDebug(8, __$stepFactory, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, MICEAgent.__$mentalExecute0_rfield, null, null, null, (byte)2, "event_1Step1");
         }
         case 9: {
            // Wait_1Step1
            return new MentalStepDebug(9, __$stepFactory, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, MICEAgent.__$mentalExecute0_rfield, null, null, null, (byte)2, "Wait_1Step1");
         }
         case 10: {
            // Wait_1Step2
            return new WaitStepDebug(10, __$stepFactory, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, null, MICEAgent.__$successTest0_rfield, null, null);
         }
         case 11: {
            // testBehavior_1Step1
            return new PrimitiveStepDebug(11, __$stepFactory, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, MICEAgent.__$argumentExecute0_rfield, null, null, null, new TestAction(), null, "testAction");
         }
         case 12: {
            // testBehavior_1Step2
            return new GoalStepDebug(12, __$stepFactory, __$behaviorParent, false, false, false, false, false, false, (short)-32768, (short)0, false, null, MICEAgent.__$argumentExecute0_rfield, null, null, null, "Wait(int)", null, (short)0);
         }
         case 13: {
            // testBehavior_1Step3
            return new GoalStepDebug(13, __$stepFactory, __$behaviorParent, true, false, false, false, false, false, (short)-32768, (short)0, false, null, null, null, null, null, "testBehavior()", null, (short)0);
         }
         case 14: {
            // MICEAgent_RootCollectionBehaviorStep1
            return new MentalStepDebug(14, __$stepFactory, __$behaviorParent, false, false, false, false, false, false, (short)3, (short)0, false, null, MICEAgent.__$mentalExecute0_rfield, null, null, null, (byte)2, "MICEAgent_RootCollectionBehaviorStep1");
         }
         case 15: {
            // MICEAgent_RootCollectionBehaviorStep2
            return new GoalStepDebug(15, __$stepFactory, __$behaviorParent, false, false, false, false, false, false, (short)2, (short)0, false, null, null, null, null, null, "event()", null, (short)0);
         }
         case 16: {
            // MICEAgent_RootCollectionBehaviorStep3
            return new GoalStepDebug(16, __$stepFactory, __$behaviorParent, false, false, false, false, false, false, (short)2, (short)0, false, null, null, null, null, null, "MICERoot()", null, (short)0);
         }
      default:
         throw new AblRuntimeError("Unexpected stepID " + __$stepID);
      }
   }
}

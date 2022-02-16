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
public class MICEAgent_BehaviorFactories {
   static public Behavior behaviorFactory0(int __$behaviorID, Object[] __$args, Map __$boundVars, GoalStep __$parentGoal, String __$signature, BehavingEntity __$thisEntity, __BehaviorDesc __$behaviorDesc) {
      switch (__$behaviorID) {
         case 0: {
            // event_1
               final Object[] __$behaviorFrame = new Object[1];
               __$behaviorFrame[0] = new __ValueTypes.LongVar();

            final __StepDesc[] __$steps = {new __StepDesc(0, MICEAgent.__$stepFactory0_rfield)};
            return new SequentialBehaviorDebug(__$parentGoal, null, null, null, null, false, __$signature, (short)0, 0, __$behaviorFrame, __$steps, __$behaviorDesc);
         }
         case 1: {
            // Wait_1
               final Object[] __$behaviorFrame = new Object[2];
               __$behaviorFrame[0] = new __ValueTypes.IntVar((Integer)__$args[0]);
               __$behaviorFrame[1] = new __ValueTypes.LongVar();

            final __StepDesc[] __$steps = {new __StepDesc(1, MICEAgent.__$stepFactory0_rfield), new __StepDesc(2, MICEAgent.__$stepFactory0_rfield)};
            return new SequentialBehaviorDebug(__$parentGoal, null, null, null, null, false, __$signature, (short)0, 1, __$behaviorFrame, __$steps, __$behaviorDesc);
         }
         case 2: {
            // testBehavior_1
               final Object[] __$behaviorFrame = new Object[1];
               __$behaviorFrame[0] = new __ValueTypes.LongVar((Long)__$boundVars.get("test"));

            final __StepDesc[] __$steps = {new __StepDesc(3, MICEAgent.__$stepFactory0_rfield), new __StepDesc(4, MICEAgent.__$stepFactory0_rfield), new __StepDesc(5, MICEAgent.__$stepFactory0_rfield)};
            return new SequentialBehaviorDebug(__$parentGoal, null, null, null, null, false, __$signature, (short)0, 2, __$behaviorFrame, __$steps, __$behaviorDesc);
         }
         case 3: {
            // MICEAgent_RootCollectionBehavior

            final __StepDesc[] __$steps = {new __StepDesc(6, MICEAgent.__$stepFactory0_rfield), new __StepDesc(7, MICEAgent.__$stepFactory0_rfield)};
            return new CollectionBehaviorDebug(__$parentGoal, null, null, null, null, false, __$signature, (short)0, 3, null, __$steps, 2, __$behaviorDesc);
         }
         case 4: {
            // __$defaultMemoryExecuteBehavior_1
               final Object[] __$behaviorFrame = __$args;

            final __StepDesc[] __$steps = null;
            return new MemoryExecuteBehaviorDebug(__$parentGoal, null, null, null, null, false, __$signature, (short)0, 4, __$behaviorFrame, __$steps, 0, __$behaviorDesc);
         }
      default:
         throw new AblRuntimeError("Unexpected behaviorID " + __$behaviorID);
      }
   }
}

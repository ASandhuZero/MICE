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
public class MICEAgent_MentalStepExecute {
   static public void mentalExecute0(int __$stepID, final Object[] __$behaviorFrame, final BehavingEntity __$thisEntity, MentalStep __$thisStep) {
      switch (__$stepID) {
         case 3: {
            // startEventThread_1Step1
            System.out.println("STARTING EVENT.");
            break;
         }
         case 4: {
            // endEventThread_1Step1
            System.out.println("ENDING EVENT.");
            break;
         }
         case 5: {
            // milieu_1Step1
            System.out.println("Beginning Milieu.");
            break;
         }
         case 6: {
            // inquiry_1Step1
            System.out.println("Beginning Inquiry.");
            break;
         }
         case 7: {
            // character_1Step1
            System.out.println("Beginning Character.");
            break;
         }
         case 8: {
            // event_1Step1
            System.out.println("Beginning Event.");
            break;
         }
         case 9: {
            // Wait_1Step1
            ((__ValueTypes.LongVar)__$behaviorFrame[1]).l = System.currentTimeMillis() + ((__ValueTypes.IntVar)__$behaviorFrame[0]).i;
            break;
         }
         case 14: {
            // MICEAgent_RootCollectionBehaviorStep1
            System.out.println("Starting bot Agent");
            break;
         }
      default:
         throw new AblRuntimeError("Unexpected stepID " + __$stepID);
      }
   }
}

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
public class MICEAgent_Preconditions {
   static public boolean precondition0(int __$behaviorID, Object[] __$args, Map __$variableTable, final BehavingEntity __$thisEntity) {
      switch (__$behaviorID) {
         case 2: {
            // testBehavior_1
            long test;
               List wmeList0;
               ListIterator wmeIter0;
               wmeList0 = BehavingEntity.getBehavingEntity().lookupWME("TestWME");
               wmeIter0 = wmeList0.listIterator();
               while(wmeIter0.hasNext()) {
                  TestWME wme__0 = (TestWME)wmeIter0.next();
                  if (
                     BehavingEntity.constantTrue(test = wme__0.getTest())
                  )

                  {
                     __$variableTable.put("test", new Long(test));
                     return true;
                  }

               }


            return false;
         }
      default:
         throw new AblRuntimeError("Unexpected behaviorID " + __$behaviorID);
      }
   }
}

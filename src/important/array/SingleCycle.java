package important.array;

import java.util.LinkedList;
import java.util.Queue;

public class SingleCycle {

    public static boolean hasSingleCycle(int[] array) {
        // Write your code here.
        int numOfElementVisited =0;
        int currentIndex = 0;

        while(numOfElementVisited < array.length){
          if(numOfElementVisited > 0 && currentIndex == 0) return false;
          numOfElementVisited++;
          int jump = array[currentIndex];

          int index = (currentIndex+jump) % array.length;

          currentIndex = (index >= 0) ? index : index + array.length;

        }

        return currentIndex == 0;
      }
}

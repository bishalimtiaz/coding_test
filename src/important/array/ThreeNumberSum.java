package important.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/**
 Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum. The function should find all triplets in the array that sum up to the target sum and return a two-dimensional array of all these triplets. The numbers in each triplet should be ordered in ascending order, and the triplets themselves should be ordered in ascending order with respect to the numbers they hold.
 If no three numbers sum up to the target sum, the function should return an empty array.

 Sample Input
 array = [12, 3, 1, 2, -6, 5, -8, 6]
 targetSum = 0

 Sample Output
 [[-8, 2, 6], [-8, 3, 5], [-6, 1, 511

 **/


/**
 Two Pointer Approach
 Time: O(n2)
 Space: O(n)

 **/
public class ThreeNumberSum {
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {

        List<Integer[]> res = new ArrayList<>();

            Arrays.sort(array);

            for(int i =0;i<array.length-2;i++){
              int left = i+1;
              int right = array.length-1;

              while(left<right){

                int sum = array[i]+array[left]+array[right];

                if( sum == targetSum){
                  res.add(new Integer[]{array[i],array[left],array[right]});
                  break;
                } else if(sum<targetSum) left++;
                else right--;
              }
            }
            return res;

    }

    public static void main(String[] args) {
        threeNumberSum(new int[]{12,3,1,2,-6,5,-8,6},0);
    }

}

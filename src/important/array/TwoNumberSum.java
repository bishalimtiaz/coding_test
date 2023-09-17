package important.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum. If any two numbers in the input array sum up to the target sum, the function should return them in an array, in any order. If no two numbers sum up to the target sum, the function should return an empty
 array.
 Note that the target sum has to be obtained by summing two different integers in the array; you can't add a single integer to itself in order to obtain the target sum.
 You can assume that there will be at most one pair of numbers summing up to the target sum.

 Sample Input
 array = [3, 5, -4, 8, 11, 1, -1, 6]
 targetSum = 10

 Sample Output
 [-1, 11] // the numbers could be in reverse order

 * **/

public class TwoNumberSum {

    /**
     Two Pointer Approach
     Time = O(nlogn)
     Space = O(1)
     **/
    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.

        Arrays.sort(array);

        int left = 0;
        int right = array.length-1;

        while(left<right){
          if(array[left] + array[right] == targetSum) return new int[]{array[right], array[left]};
          else if(array[left] + array[right] < targetSum) left++;
          else right--;
        }
        return new int[]{};
      }


      /**
       Hashing Technique
       Time = O(n)
       Space = O(n)

       store the num in set and if (targetSum - num ) is in the set that is the result

       **/
//    public static int[] twoNumberSum(int[] array, int targetSum) {
//        // Write your code here.
//
//        Set<Integer> set = new HashSet<>();
//
//        for(int num : array){
//          int res = targetSum - num;
//          if(set.contains(res)){
//            return new int[]{num,res};
//          } else{
//            set.add(num);
//          }
//        }
//        return new int[]{};
//      }

    /**
     Two For loop
     Time = O(n2)
     Space = O(1)
     **/

//    public static int[] twoNumberSum(int[] array, int targetSum) {
//        // Write your code here.
//        // int[2] =
//        for(int i = 0;i<array.length-1;i++){
//          for(int j = i+1;j<array.length;j++){
//            if(array[i]+array[j] == targetSum) return new int[]{array[j],array[i]};
//          }
//        }
//
//        return new int[]{};
//      }

}

package important.array;



/**
 Write a function that takes in a non-empty array of integers that are sorted
 in ascending order and returns a new array of the same length with the squares of the original integers also sorted in ascending order.

 Sample Input
 array = [1, 2, 3, 5, 6, 8, 9]


 Sample Output
 [1, 4, 9, 25, 36, 64, 81]

 **/

public class SortedSquaredArray {

    /**
     Two Pointer Approach
     Time: O(n)
     Space: O(n)
     **/


    public int[] sortedSquaredArray(int[] array) {
        // Write your code here.
        int n = array.length;
        int[] res = new int[n];

        int left = 0;
        int right = n-1;

        while(left<=right){
          if(Math.abs(array[left]) < Math.abs(array[right])){
            res[--n] = array[right] * array[right];
            right--;
          }else{
            res[--n] = array[left] * array[left];
            left++;
          }
        }
        return res;
      }
}

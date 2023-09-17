package important.array;

import java.util.HashSet;
import java.util.Set;


/**
 * You're given a list of integers nums .
 * Write a function that returns a boolean representing whether there exists a zero-sum subarray of nums
 * A zero-sum subarray is any subarray where all of the values add up to zero. A subarray is any contiguous section of the array. For the purposes of this problem, a subarray can be as small as one element and as long as the original array.
 * <p>
 * Sample Input
 * nums = [-5, -5, 2, 3, -2]
 * <p>
 * Sample Output
 * True // The subarray [-5, 2, 3] has a sum of 0
 */
public class ZeroSumSubArray {

    /**
     * if subArray [0,x] = S and [0,y] = S
     * then [x+1,y] must be zero
     * Time: O(n)
     * Space: O(n)
     **/
    public boolean zeroSumSubarray(int[] nums) {
        // Write your code here.

        Set<Integer> set = new HashSet<>();
        int sum = 0;
        set.add(sum);

        for (int num : nums) {
            sum += num;

            if (set.contains(sum)) return true;
            else set.add(sum);

        }

        return false;
    }
}

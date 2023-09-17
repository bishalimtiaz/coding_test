package important.array;

import java.util.Arrays;

public class LongestSubArrayWithSum {

    public static int[] longestSubarrayWithSum(int[] array, int targetSum) {

        // Write your code here.


        int[] res = {};

        if (array.length == 0) return res;
        int left = 0, right = 0;

        int curSum = 0;

        while (right < array.length) {
            curSum += array[right];

            while (left < right && curSum > targetSum) {
                curSum -= array[left];
                left++;
            }

            if (curSum == targetSum) {

                if (res.length == 0) {
                    res = new int[]{left, right};
                } else if (res[1] - res[0] < right - left) {
                    res[0] = left;
                    res[1] = right;
                }
            }

            right++;
        }
        return res;
    }


    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 3, 3, 1, 2, 1};

        int target = 10;

        System.out.println(Arrays.toString(longestSubarrayWithSum(arr, target)));

    }
}

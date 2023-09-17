package important.array;

import java.util.Arrays;

public class MissingNumber {

    public int missingNumber(int[] nums) {

        int res = nums.length;

        for (int i = 0; i < nums.length; i++) {
            res = res ^ i ^ nums[i];
        }

        return res;

    }


    public int[] missingNumbers(int[] nums) {
        int[] res = new int[]{0, 0};
        int xor = 0;

        // XOR all numbers from 1 to nums.length + 2
        for (int i = 1; i <= nums.length + 2; i++) {
            xor = xor ^ i;
        }

        // XOR all elements in the nums array
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }

        int setBit = xor & -xor;

        for (int i = 1; i <= nums.length + 2; i++) {

            if ((i & setBit) == 0) {
                res[0] ^= i;
            } else {
                res[1] ^= i;
            }
        }

        for (int num : nums) {

            if ((num & setBit) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }

        Arrays.sort(res);

        return res;
    }
}

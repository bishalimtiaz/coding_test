package important.array;


/**
 Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

 There is only one repeated number in nums, return this repeated number.

 You must solve the problem without modifying the array nums and uses only constant extra space.



 Example 1:

 Input: nums = [1,3,4,2,2]
 Output: 2
 Example 2:

 Input: nums = [3,1,3,4,2]
 Output: 3
 */

public class FindDuplicate {
    public int findDuplicate(int[] nums) {

            int hare = nums[0];
            int tortoise = nums[0];

            do{
                tortoise = nums[tortoise];
                hare = nums[nums[hare]];
            } while(tortoise!=hare);

            tortoise = nums[0]; //tortoise dies

            while(tortoise!=hare){
                tortoise = nums[tortoise];
                hare = nums[hare];
            }

            return hare;
        }
}

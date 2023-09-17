package important.array;

public class MaximumSubArraySum {

    public static int maximumSubArraySum(int[] arr){
        int currentSum = 0;
        int maxSum = 0;

        for (int num : arr){
            currentSum += num;

            if(currentSum > maxSum){
                maxSum = currentSum;
            }
            if (currentSum < 0){
                currentSum = 0;
            }
        }

        return maxSum;
    }
}

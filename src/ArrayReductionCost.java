import java.util.PriorityQueue;

/**
 * Anna has an array of n integers called num. She can reduce the array by
 * 1 element by performing a move. Each move consists of the following
 * three steps:

 * Pick two different elements num[i] and num[j], i ≠ j.
 * Remove the two selected elements from the array.
 * Add the sum of the two selected elements to the end of the array.
 * Each move has a cost associated with it, and this cost is equal to the
 * sum of the two elements removed from the array during the move.
 * Anna wishes to calculate the minimum total cost of reducing her array
 * to one element.

 * For example, consider the array num = [4,6,8]. Anna removes 4 and 6 in
 * her first move at a cost of 4 + 6 = 10, and the resultant array is num =
 * [8,10]. She then removes 8 and 10 in her second move at a cost of 8 +
 * 10 = 18, and the resultant array is num = [18]. The total cost of
 * reducing this array to one element using this sequence of moves is 10 + 18 = 28. This is just one set of possible moves. For instance, she could have started with 4 and 8.

 * Function Description
 * Complete the function reductionCost in the editor below. The function
 * must return the minimum total cost of reducing the input array to one
 * element.
 * reductionCost has the following parameter(s):
 * num[num[0],...num[n-1]]: an array of integers
 * Constraints
 * 2 ≤ n ≤ 10
 * 0 ≤ num[i] ≤ 10

 * Input Format for Custom Testing
 * Input from stdin will be processed as follows and passed to the
 * function.
 * The first line contains an integer n, the size of the array num.
 * The next n lines each contain an element num[i].
 * Sample Case 0
 * Sample Input 0
 * 3
 * 1
 * 2
 * 3
 */

public class ArrayReductionCost {


    /**
     * Brute Force Approach
     * Time: O(2^N*N)
     * Space: O(n)
     */
//    public static int reductionCost(int[] num) {
//        int n = num.length;
//        int minCost = Integer.MAX_VALUE;
//
//        if (n == 1) {
//            return 0;
//        }
//
//
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = i + 1; j < n; j++) {
//                int cost = num[i] + num[j];
//                int[] updatedArray = removeAndMergeElements(num, i, j);
//                int totalCost = cost + reductionCost(updatedArray);
//                // Update the minimum cost
//                minCost = Math.min(minCost, totalCost);
//            }
//        }
//
//
//        return minCost;
//    }
//
//    //     Helper method to remove and merge elements in the array
//    private static int[] removeAndMergeElements(int[] arr, int i, int j) {
//        int[] updatedArray = new int[arr.length - 1];
//        int index = 0;
//
//        for (int k = 0; k < arr.length; k++) {
//            if (k != i && k != j) {
//                updatedArray[index] = arr[k];
//                index++;
//            }
//        }
//
//        int sum = arr[i] + arr[j];
//        updatedArray[index] = sum;
//
//        return updatedArray;
//    }


    /**
     * Greedy
     * Time:  O(n log n)
     * Space: O(N)
     **/

//    public static int reductionCost(int[] num) {
//
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//
//        for(int n : num){
//            minHeap.add(n);
//        }
//
//        while(minHeap.size()>1){
//            int cost = minHeap.poll() + minHeap.poll();
//            minHeap.add(cost);
//        }
//        return  minHeap.poll();
//    }

    /**
     * DP
     * Time: O(n^3)
     */
    public static int reductionCost(int[] num) {
        int n = num.length;
        int[][] dp = new int[n][n];

        // Initialize the diagonal elements of the DP table as 0
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        // Perform bottom-up DP to calculate the minimum cost
        //considering subsequences of length 2 or more i.e, len =2.
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                // Iterate over all possible splits and calculate the cost
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + sum(num, i, j);
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][n - 1];
    }

    // Helper method to calculate the sum of elements in the array from index i to j
    private static int sum(int[] arr, int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += arr[k];
        }
        return sum;
    }


    public static void main(String[] args) {

        int[] num = new int[]{1, 2, 3};
        System.out.println(reductionCost(num));

    }
}

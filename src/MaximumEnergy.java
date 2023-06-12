/**
 * Given a 4 x 4 matrix mat, the initial energy is 100.
 * The task is to reach the last row of the matrix with the maximum possible energy left.
 * The matrix can be traversed in the following way:
 * 1. Start with any cell in the first row.
 * 2. In each move, traverse from cell (i, j) of the ith row and jth column to any existing cell out of (i + 1, j-1), (1 + 1, j) or (i + 1, j+ 1).
 * 3. Finish the traversal in the last row.

 * After stepping on a cell (i, j), energy decreases by mat[i][j] units. Find the maximum possible energy left at the end of the traversal.

 * Note: The final energy can be negative.

 * Example:

 * mat[][] = [[10, 20, 30, 40],
 * [60, 50, 20, 80],
 * [10, 10, 10, 10],
 * [60, 50, 60, 50]]

 * Possible Paths:

 * 0 - based indexing is used.

 * - (0,0) - (1,1) -(2,2) - (3,3)
 * - (0, 1) - (1, 2) - (2, 2) - (3, 2)

 * For the first path, energy left = 100 - 10 - 50 - 10
 * 50 = -20
 * For the second path, energy left = 100 - 20 - 20 -10
 * 50 = 0

 * It can be proven that 0 is the maximum energy possible at the end of the traversal so return 0.

 * Function Description:

 * Complete the function maxEnergy in the editor below.
 * maxEnergy has the following parameter:
 * int mat|4][4]; a matrix of integers

 * Returns
 * int: the maximum possible energy at the end of the traversal

 * Constraints:
 * • 0 <= mat[i][j] < 100
 */


public class MaximumEnergy {

    public static int maxEnergy(int[][] mat) {
        int[][] dp = new int[4][4];

        // Initialize the first row of dp
        for (int j = 0; j < 4; j++) {
            dp[0][j] = mat[0][j];
        }

        // Iterate from the second row to the last row
        for (int i = 1; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // Calculate the maximum energy left at the current cell
                int minEnergy = dp[i - 1][j]; // (i-1, j)
                if (j != 0) {
                    minEnergy = Math.min(minEnergy, dp[i - 1][j - 1]); // (i-1, j-1)
                }
                if (j < 3) {
                    minEnergy = Math.min(minEnergy, dp[i - 1][j + 1]); // (i-1, j+1)
                }
                dp[i][j] = minEnergy + mat[i][j];
            }
        }

        // Find the maximum energy left in the last row
        int minEnergy = dp[3][0];
        for (int j = 1; j < 4; j++) {
            minEnergy = Math.min(minEnergy, dp[3][j]);
        }

        return 100 - minEnergy;
    }


    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {10, 20, 30, 40},
                {60, 50, 20, 80},
                {10, 10, 10, 10},
                {60, 50, 60, 50}

        };

        System.out.println(maxEnergy(arr));
    }
}

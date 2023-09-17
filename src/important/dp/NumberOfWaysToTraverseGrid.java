package important.dp;


// can go either right or down
public class NumberOfWaysToTraverseGrid {

    public int numberOfWaysToTraverseGraph(int width, int height) {
        // Write your code here.


        int[][] dp = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }


        return dp[height - 1][width - 1];
    }
}

package important.dp;

public class MinimumEditDistance {


    public static int minimumDistance(String s1, String s2) {

        int row = s1.length()+1;
        int col = s2.length()+1;
        int[][] dp = new int[row][col];

        for (int i = 1; i < row; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = i;
        }


        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {

                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }


        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {

        String s1 = "abc";
        String s2 = "yabd";

        System.out.println(minimumDistance(s1, s2));

    }
}

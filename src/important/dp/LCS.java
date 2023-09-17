package important.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LCS {

    public static int longestCommonSubsequence(String text1, String text2) {

        int row = text1.length() + 1;
        int column = text2.length() + 1;

        int[][] lcs = new int[row][column];

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }

        return lcs[row - 1][column - 1];
    }

    public static List<Character> longestCommonSubsequence2(
            String str1, String str2
    ) {
        // Write your code here.
        //List<Character>[][] res = new ArrayList<Character>();

        int row = str1.length() + 1;
        int column = str2.length() + 1;

        String[][] lcs = new String[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 || j ==0) lcs[i][j] = "";
            }
            }

            for (int i = 1; i < row; i++) {
                for (int j = 1; j < column; j++) {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                        lcs[i][j] = lcs[i - 1][j - 1] + str1.charAt(i - 1);
                        // res.add(str1.charAt(i - 1));
                    } else {
                        lcs[i][j] = lcs[i - 1][j].length() > lcs[i][j - 1].length() ? lcs[i - 1][j] : lcs[i][j - 1];
                    }
                }
            }


        List<Character> res = new ArrayList<>();

            for (char c :  lcs[row - 1][column - 1].toCharArray()){
                res.add(c);
            }

            return  res;
        }

        public static void main (String[]args){

            String s1 = "abcde";
            String s2 = "ace";
            System.out.println(longestCommonSubsequence2(s1, s2));

        }
    }

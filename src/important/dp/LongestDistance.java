package important.dp;

import java.util.LinkedList;
import java.util.Queue;

public class LongestDistance {


    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};

    public static int findMaxDistance(char[][] matrix) {
        int maxDistance = -1;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] source = new int[2];

        loop1:
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 's') {
                    source[0] = i;
                    source[1] = j;
                    break loop1;
                }
            }
        }

        maxDistance = Math.max(maxDistance, dfs(matrix, source[0], source[1], 0));

        return maxDistance;
    }

    private static int dfs(char[][] matrix, int x, int y, int distance) {
        if (matrix[x][y] == 'd') {
            return distance;
        }

        int maxDistance = -1;
        matrix[x][y] = '0';

        for (int d = 0; d < 4; d++) {
            int newX = x + dx[d];
            int newY = y + dy[d];

            if (newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length && matrix[newX][newY] != '0') {
                maxDistance = Math.max(maxDistance, dfs(matrix, newX, newY, distance + 1));
            }
        }

        matrix[x][y] = '*'; // Restore the cell for other paths
        return maxDistance;
    }


    public static void main(String[] args) {
        char[][] mat = new char[][]{
                {'0', '*', '0', 's'},
                {'*', '0', '*', '*'},
                {'0', '*', '*', '*'},
                {'d', '*', '*', '*'}
        };

        int result = findMaxDistance(mat);
        if (result != -1) {
            System.out.println("The maximum distance is " + result + ".");
        } else {
            System.out.println("No valid path exists.");
        }
    }
}

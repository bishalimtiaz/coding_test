package important.dp;

import java.util.Arrays;

public class RatInAMaze {


    public static boolean isSafe(int[][] maze, int x, int y) {
        int len = maze.length;
        return x >= 0 && x < len && y >= 0 && y < len && maze[x][y] == 1;
    }

    public static boolean solveMaze(int[][] maze, int[][] sol, int x, int y) {

        int len = maze.length;

        if (x == len - 1 && y == len - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }

        if (isSafe(maze, x, y)) {
            if (sol[x][y] == 1) return false;

            sol[x][y] =1;

            if (solveMaze(maze, sol, x + 1, y)) return true;
            if (solveMaze(maze, sol, x, y + 1)) return true;

            sol[x][y] = 0;
            return false;

        }

        return false;


    }

    public static void mazePath(int[][] maze) {

        int len = maze.length;

        int[][] sol = new int[len][len];

        solveMaze(maze,sol,0,0);

        System.out.println(Arrays.deepToString(sol));


    }

    public static void main(String[] args) {

        int[][] maze = new int[][]{
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1},
        };


        mazePath(maze);
    }
}

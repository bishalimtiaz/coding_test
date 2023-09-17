package important.dp;

import java.util.LinkedList;
import java.util.Queue;

class Cell {

    int row;
    int col;
    int distance;

    Cell(int x, int y, int d) {
        this.row = x;
        this.col = y;
        this.distance = d;
    }

}

public class ShortestDistanceBetweenTwoCells {
    static int shortestDistance(char[][] matrix) {
        Cell source = new Cell(0, 0, 0);
        int matrixRows = matrix.length;
        int matrixCols = matrix[0].length;

        boolean[][] visited = new boolean[matrixRows][matrixCols];

        firstLoop:
        for (int i = 0; i < matrixRows; i++) {
            for (int j = 0; j < matrixCols; j++) {
                if (matrix[i][j] == 's') {
                    source.row = i;
                    source.col = j;
                    break firstLoop;
                }
            }
        }

        Queue<Cell> queue = new LinkedList<>();
        queue.add(source);
        visited[source.row][source.col] = true;

        while (!queue.isEmpty()) {
            Cell currentCell = queue.remove();

            if (matrix[currentCell.row][currentCell.col] == 'd') {
                return currentCell.distance;
            }

            //move down

            if (currentCell.row + 1 < matrixRows && !visited[currentCell.row +1][currentCell.col]) {
                queue.add(new Cell(currentCell.row + 1, currentCell.col, currentCell.distance + 1));
                visited[currentCell.row + 1][currentCell.col] = true;
            }

            //move up
            if (currentCell.row - 1 >= 0 && !visited[currentCell.row -1 ][currentCell.col]) {
                queue.add(new Cell(currentCell.row - 1, currentCell.col, currentCell.distance + 1));
                visited[currentCell.row + 1][currentCell.col] = true;
            }

            //move right
            if (currentCell.col + 1 < matrixCols && !visited[currentCell.row][currentCell.col + 1]) {
                queue.add(new Cell(currentCell.row, currentCell.col + 1, currentCell.distance + 1));
                visited[currentCell.row][currentCell.col + 1] = true;
            }


            //move left
            if (currentCell.col - 1 >= 0 && !visited[currentCell.row][currentCell.col - 1]) {
                queue.add(new Cell(currentCell.row, currentCell.col - 1, currentCell.distance + 1));
                visited[currentCell.row][currentCell.col - 1] = true;

            }


        }
        return -1;
    }

    public static void main(String[] args) {
        char[][] mat = new char[][]{
                {'0', '*', '0', 's'},
                {'*', '0', '*', '*'},
                {'0', '*', '*', '*'},
                {'d', '*', '*', '*'}
        };

        System.out.println( shortestDistance(mat));;
    }

}

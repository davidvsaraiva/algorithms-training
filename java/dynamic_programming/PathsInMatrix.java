package dynamic_programming;


/**
 * Given a matrix where a cell has the value of 1 if it's a wall and 0 if not, find the number of ways to go from the
 * top-left cell to the bottom-right cell, knowing that it's not possible to pass from a wall and we can only go to the
 * right or to the bottom
 *
 * Example:
 * matrix = [
 * [0, 0, 1, 0, 1],
 * [0, 0, 0, 0, 1],
 * [0, 0, 1, 0, 0],
 * [1, 0, 0, 0, 0]
 * ]
 *
 * output: 7
 *
 * See <a href="https://www.udemy.com/course/dynamic-programming-x/learn/quiz/5350326#overview">
 * Udemy – Paths in matrix
 */
public class PathsInMatrix {

    public static void main(String[]args){
        int [][] matrix = {
                {0, 0, 1, 0, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0}};
        System.out.println(pathsInMatrix(matrix));
    }

    static int pathsInMatrix(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return 0;
        }
        int cols = matrix[0].length;
        if (cols == 0){
            return 0;
        }

        if (matrix[0][0] == 1 || matrix[rows -1][cols -1] == 1){
            return 0;
        }

        int [][] result =  new int[rows][cols];
        result[0][0] = 1;

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == 1){
                    result[i][j] = 0;
                    continue;
                }
                if (i == 0 && j == 0){
                    continue;
                }
                int fromUp = (i > 0) ? result[i-1][j] : 0;
                int fromLeft = (j > 0) ? result[i][j-1] : 0;
                result[i][j] = fromUp + fromLeft;
            }
        }
        printMatrix(result);

        return result[matrix.length-1][matrix[0].length-1];
    }


    private static void printMatrix(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

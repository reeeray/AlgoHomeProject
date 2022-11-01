package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 31.10.2022
 **/
public class ToeplitzMatrix_766 {

    public static void main(String[] args) {
        final int[][] input = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};

        assert isToeplitzMatrix(input) == true;
    }


    private static boolean isToeplitzMatrix(final int[][] matrix) {
        for(int col = 0; col<matrix[0].length; col++) {
            if(isDiagonalNotValid(matrix, 0, col))
                return false;
        }

        for(int row=1; row<matrix.length; row++) {
            if(isDiagonalNotValid(matrix, row, 0))
                return false;
        }
        return true;
    }

    private static boolean isDiagonalNotValid(final int[][] matrix, int row, int col) {
        final int rows = matrix.length;
        final int cols = matrix[0].length;
        final int ref = matrix[row][col];

        while(row < rows && col < cols) {
            if(matrix[row][col] != ref)
                return true;
        }
        return false;
    }
}

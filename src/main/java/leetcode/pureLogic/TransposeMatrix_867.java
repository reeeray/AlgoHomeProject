package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 10.12.2023
 **/
public class TransposeMatrix_867 {

    public static void main(String[] args) {

    }

    public int[][] transpose(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        for (int r = 0; r < row; ++r)
            for (int c = 0; c < col; ++c) {
                final int copy = matrix[col][row];
                matrix[col][row] = matrix[row][col];
                matrix[row][col] = copy;
            }
        return matrix;
    }

    public int[][] transposeBF(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        final int[][] ans = new int[col][row];
        for (int c = 0; c < col; c++)
            for (int r = 0; r < row; r++) {
                ans[c][r] = matrix[r][c];
            }
        return ans;
    }
}

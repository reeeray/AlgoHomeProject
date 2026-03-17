package leetcode.grids;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 17.03.2026
 **/
public class LargestSubmatrixWithRearrangements_1727 {

    public static void main(String[] args) {

    }

    //Time O(mnlogm) and Space O(mn)
    public static int largestSubmatrix(final int[][] matrix) {
        final int rows = matrix.length;
        final int cols = matrix[0].length;
        int res = 0;
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(matrix[row][col] != 0 && row > 0) {
                    matrix[row][col] += matrix[row - 1][col];
                }
            }
            final int[] currRow = matrix[row].clone();
            Arrays.sort(currRow);
            for(int i = 0; i < cols; i++) {
                res = Math.max(res, currRow[i]*(cols - i));
            }
        }
        return res;
    }
}

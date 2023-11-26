package leetcode.pureLogic;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.11.2023
 **/
public class LargestSubmatrixWithRearragements_1727 {

    public static void main(String[] args) {

    }

    public int largestSubmatrix(final int[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        int ans = 0;
        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if(matrix[row][col] != 0 && row > 0) {
                    matrix[row][col] += matrix[row - 1][col];
                }
            }

            final int[] currRow = matrix[row].clone();
            Arrays.sort(currRow);
            for(int i=0; i<n; i++) {
                ans = Math.max(ans, currRow[i]*(n - i));
            }
        }
        return ans;
    }

}

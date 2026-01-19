package leetcode.grids;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 19.01.2026
 **/
public class MaxSideLengthOfASquareWithSumLessThanOrEqualToThreshold_1292 {

    public static void main(String[] args) {

    }

    //prefix and iteration Time (mn + min(mn)) and Space O(mn)
    public static int maxSideLength(final int[][] mat, final int threshold) {
        final int rows = mat.length;
        final int cols = mat[0].length;
        final int[][] dp = new int[rows + 1][cols + 1];
        for(int row = 1; row <= rows; row++) {
            for(int col = 1; col <= cols; col++) {
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1] - dp[row - 1][col -1] + mat[row - 1][col - 1];
            }
        }

        final int maxSide = Math.min(rows, cols);
        int res = 0;
        for(int row = 1; row <= rows; row++) {
            for(int col = 1; col <= cols; col++) {
                for(int side = res + 1; side <= maxSide; side++) {
                    if(row + side - 1 <= rows && col + side - 1 <= cols && rectSum(dp, row, col, side) <= threshold) {
                        res = side;
                    } else {
                        break;
                    }
                }
            }
        }
        return res;
    }

    private static int rectSum(final int[][] dp, final int row, final int col, final int side) {
        return dp[row + side - 1][col + side - 1] - dp[row + side - 1][col - 1] - dp[row - 1][col + side - 1] + dp[row - 1][col - 1];
    }
}

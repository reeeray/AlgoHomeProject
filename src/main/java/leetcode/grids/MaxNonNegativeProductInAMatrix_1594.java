package leetcode.grids;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 23.03.2026
 **/
public class MaxNonNegativeProductInAMatrix_1594 {

    public static void main(String[] args) {

    }

    //Time O(mn) and Space O(mn)
    public static int maxProductPath(final int[][] grid) {
        final int MOD = (int)1e9 + 7;
        final int rows = grid.length;
        final int cols = grid[0].length;
        final long[][] maxPositive = new long[rows][cols];
        final long[][] maxNegative = new long[rows][cols];
        maxPositive[0][0] = maxNegative[0][0] = grid[0][0];
        for(int row = 1; row < rows; row++) {
            maxPositive[row][0] = maxNegative[row][0] = maxPositive[row - 1][0] * grid[row][0];
        }

        for(int col = 1; col < cols; col++) {
            maxPositive[0][col] = maxNegative[0][col] = maxPositive[0][col - 1] * grid[0][col];
        }

        for(int row = 1; row < rows; row++) {
            for(int col = 1; col < cols; col++) {
                if(grid[row][col] > 0) {
                    maxPositive[row][col] = Math.max(maxPositive[row - 1][col], maxPositive[row][col - 1]) * grid[row][col];
                    maxNegative[row][col] = Math.min(maxNegative[row - 1][col], maxNegative[row][col - 1]) * grid[row][col];
                } else {
                    maxPositive[row][col] = Math.min(maxNegative[row - 1][col], maxNegative[row][col - 1]) * grid[row][col];
                    maxNegative[row][col] = Math.max(maxPositive[row - 1][col], maxPositive[row][col - 1]) * grid[row][col];
                }
            }
        }

        if(maxPositive[rows - 1][cols - 1] < 0) return -1;
        return (int)(maxPositive[rows - 1][cols - 1] % MOD);
    }
}

package leetcode.dp;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 29.10.2024
 **/
public class MaxNumberOfMovesInAgrid_2684 {

    public static void main(String[] args) {
        final int[][] input = new int[][]{{3,2,4},{2,1,9},{1,1,7}};
        maxMoves(input);
    }

    //didn't cover all of the use cases
    public static int maxMoves(final int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        for(int i=m-1; i > 0; i--) {
            for(int j=0; j<n; j++) {
                if(j > 0 && grid[j - 1][i - 1] < grid[j][i]) {
                    grid[j][i] = 1 + (i < m - 1 ? grid[j][i + 1] : 0);
                    continue;
                }
                if(grid[j][i - 1] < grid[j][i]) {
                    grid[j][i] = 1 + (i < m - 1 ? grid[j][i + 1] : 0);
                    continue;
                }
                if(j < n - 1 && grid[j + 1][i - 1] < grid[j][i]) {
                    grid[j][i] = 1 + (i < m - 1 ? grid[j][i + 1] : 0);
                    continue;
                }
                grid[j][i] = 0;
            }
        }
        int ans = 0;
        for(int i=0; i<n; i++) {
            ans = Math.max(ans, grid[i][1]);
        }
        return ans;
    }

    //Space O(m) and Time O(nm)
    public int maxMovesOptimized(int[][] grid) {
        int M = grid.length, N = grid[0].length;

        // Create a dp array to store moves, with each cell having a size of 2.
        int[][] dp = new int[M][2];

        // Initialize the first column cells as reachable.
        for (int i = 0; i < M; i++) {
            dp[i][0] = 1;
        }

        int maxMoves = 0;

        // Iterate over each column starting from the second one.
        for (int j = 1; j < N; j++) {
            for (int i = 0; i < M; i++) {
                // Check if moving from the same row
                // of the previous column is possible.
                if (grid[i][j] > grid[i][j - 1] && dp[i][0] > 0) {
                    dp[i][1] = Math.max(dp[i][1], dp[i][0] + 1);
                }
                // Check if moving from the upper diagonal is possible.
                if (
                        i - 1 >= 0 &&
                                grid[i][j] > grid[i - 1][j - 1] &&
                                dp[i - 1][0] > 0
                ) {
                    dp[i][1] = Math.max(dp[i][1], dp[i - 1][0] + 1);
                }
                // Check if moving from the lower diagonal is possible.
                if (
                        i + 1 < M &&
                                grid[i][j] > grid[i + 1][j - 1] &&
                                dp[i + 1][0] > 0
                ) {
                    dp[i][1] = Math.max(dp[i][1], dp[i + 1][0] + 1);
                }

                // Update the maximum moves so far.
                maxMoves = Math.max(maxMoves, dp[i][1] - 1);
            }

            // Shift dp values for the next iteration.
            for (int k = 0; k < M; k++) {
                dp[k][0] = dp[k][1];
                dp[k][1] = 0;
            }
        }

        return maxMoves;
    }
}

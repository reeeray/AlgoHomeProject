package leetcode.dfs;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 30.04.2026
 **/
public class MaxPathScoreInAGrid_3742 {

    public static void main(String[] args) {

    }

    static int res = 0;

    //Dynamic Programming Time O(mnk) and Space O(nmk)
    public int maxPathScoreOpt(final int[][] grid, final int k) {
        final int m = grid.length;
        final int n = grid[0].length;

        final int[][][] dp = new int[m][n][k + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }

        dp[0][0][0] = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int c = 0; c <= k; c++) {
                    if (dp[i][j][c] == Integer.MIN_VALUE) continue;

                    if (i + 1 < m) {
                        final int val = grid[i + 1][j];
                        final int cost = (val == 0 ? 0 : 1);
                        if (c + cost <= k) {
                            dp[i + 1][j][c + cost] = Math.max(
                                    dp[i + 1][j][c + cost],
                                    dp[i][j][c] + val
                            );
                        }
                    }

                    if (j + 1 < n) {
                        final int val = grid[i][j + 1];
                        final int cost = (val == 0 ? 0 : 1);
                        if (c + cost <= k) {
                            dp[i][j + 1][c + cost] = Math.max(
                                    dp[i][j + 1][c + cost],
                                    dp[i][j][c] + val
                            );
                        }
                    }
                }
            }
        }

        int res = Integer.MIN_VALUE;
        for (int c = 0; c <= k; c++) {
            res = Math.max(res, dp[m - 1][n - 1][c]);
        }

        return res < 0 ? -1 : res;
    }

    //TLE
    public static int maxPathScore(final int[][] grid, final int k) {
        res = -1;
        dfs(grid, 0, 0, k, 0);
        return res;
    }

    private static void dfs(final int[][] grid, final int row, final int col, final int cost, final int score) {
        final int afterPayment = grid[row][col] == 0 ? cost : cost - 1;
        final int newScore = score + grid[row][col];
        if(row + 1 == grid.length && col + 1 == grid[0].length) {
            if(afterPayment >= 0) res = Math.max(res, newScore);
            return;
        }
        if(row < grid.length - 1) {
            dfs(grid, row + 1, col, afterPayment, newScore);
        }
        if(col < grid[0].length - 1) {
            dfs(grid, row, col + 1, afterPayment, newScore);
        }
    }
}

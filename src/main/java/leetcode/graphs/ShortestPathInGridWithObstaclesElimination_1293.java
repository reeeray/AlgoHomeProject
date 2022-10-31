package leetcode.graphs;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 30.10.2022
 **/
public class ShortestPathInGridWithObstaclesElimination_1293 {

    public static void main(String[] args) {
        final int[][] input = {{0, 0, 0}, {1, 1, 0}, {0, 0, 0}, {0, 1, 1}, {0, 0, 0}};

        assert shortestPath(input, 1) == 6;
    }

    /**
     * Depth first search.
     *
     * @param grid
     * @param k
     * @return
     */
    private static int shortestPath(int[][] grid, int k) {
        int[][][] dp = new int[grid.length][grid[0].length][k + 1];
        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        final int minWays = dfs(grid, grid.length - 1, grid[0].length - 1, k, dp, visited);
        return minWays == Integer.MAX_VALUE ? -1 : minWays;
    }

    private static int dfs(int[][] grid, int row, int col, int k, int[][][] dp, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col]) {
            return Integer.MAX_VALUE;
        }
        if (row == 0 && col == 0) {
            return 0;
        }
        if (dp[row][col][k] != Integer.MAX_VALUE) {
            return dp[row][col][k];
        }

        if (k >= row + col) {
            return dp[row][col][k] = row + col;
        }
        if (grid[row][col] == 1 && --k < 0) {
            return Integer.MAX_VALUE;
        }

        visited[row][col] = true;
        int minWays = Integer.MAX_VALUE;
        minWays = Math.min(dfs(grid, row - 1, col, k, dp, visited), minWays);
        minWays = Math.min(dfs(grid, row + 1, col, k, dp, visited), minWays);
        minWays = Math.min(dfs(grid, row, col - 1, k, dp, visited), minWays);
        minWays = Math.min(dfs(grid, row, col + 1, k, dp, visited), minWays);

        visited[row][col] = false;
        dp[row][col][k] = minWays == Integer.MAX_VALUE ? Integer.MAX_VALUE : minWays + 1;
        return dp[row][col][k];
    }
}

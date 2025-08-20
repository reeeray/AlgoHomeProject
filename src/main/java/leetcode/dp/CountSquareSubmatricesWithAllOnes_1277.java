package leetcode.dp;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 20.08.2025
 **/
public class CountSquareSubmatricesWithAllOnes_1277 {

    public static void main(String[] args) {

    }

    //Bottom Up Dynamic Programming Time O(row*col) and Space O(row*cols)
    public static int countSquares(final int[][] matrix) {
        final int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int res = 0;
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                if(matrix[row][col] == 1) {
                    dp[row + 1][col + 1] = Math.min(dp[row][col],
                            Math.min(dp[row + 1][col], dp[row][col + 1])) + 1;
                    res += dp[row + 1][col + 1];
                }
            }
        }
        return res;
    }

    // Top Down approach
    public int countSquarestOPdOWN(int[][] grid) {
        int ans = 0;
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                Arrays.fill(dp[i], -1);
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans += solve(i, j, grid, dp);
            }
        }

        return ans;
    }

    public int solve(int i, int j, int[][] grid, int[][] dp) {
        // If the cell lies outside the grid, return 0.
        if (i >= grid.length || j >= grid[0].length) {
            return 0;
        }
        if (grid[i][j] == 0) {
            return 0;
        }

        // If we have already visited this cell, return the memoized value.
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Find the answer for the cell to the right of the current cell.
        int right = solve(i, j + 1, grid, dp);
        // Find the answer for the cell to the diagonal of the current cell.
        int diagonal = solve(i + 1, j + 1, grid, dp);
        // Find the answer for the cell below the current cell.
        int below = solve(i + 1, j, grid, dp);

        return dp[i][j] = 1 + Math.min(right, Math.min(diagonal, below));
    }
}

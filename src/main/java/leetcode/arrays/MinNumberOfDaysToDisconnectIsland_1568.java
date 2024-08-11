package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 11.08.2024
 **/
public class MinNumberOfDaysToDisconnectIsland_1568 {

    // Directions for adjacent cells: right, left, down, up
    private static final int[][] DIRECTIONS = {
            { 0, 1 },
            { 0, -1 },
            { 1, 0 },
            { -1, 0 },
    };

    public static void main(String[] args) {

    }

    //Space O(rows*cols) and Time O((rows*cols)^2)
    public static int minDays(final int[][] grid) {
        final int rows = grid.length;
        final int cols = grid[0].length;

        // Count initial islands
        final int initialIslandCount = countIslands(grid);

        // Already disconnected or no land
        if (initialIslandCount != 1) {
            return 0;
        }

        // Try removing each land cell
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0) continue; // Skip water

                // Temporarily change to water
                grid[row][col] = 0;
                int newIslandCount = countIslands(grid);

                // Check if disconnected
                if (newIslandCount != 1) return 1;

                // Revert change
                grid[row][col] = 1;
            }
        }

        return 2;
    }

    private static int countIslands(final int[][] grid) {
        final int rows = grid.length;
        final int cols = grid[0].length;
        final boolean[][] visited = new boolean[rows][cols];
        int islandCount = 0;

        // Iterate through all cells
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // Found new island
                if (!visited[row][col] && grid[row][col] == 1) {
                    exploreIsland(grid, row, col, visited);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    // Helper method to explore all cells of an island
    private static void exploreIsland(final int[][] grid, final int row, final int col, final boolean[][] visited) {
        visited[row][col] = true;
        final int rows = grid.length;
        final int cols = grid[0].length;

        // Check all adjacent cells
        for (final int[] direction : DIRECTIONS) {
            final int nextRow = row + direction[0];
            final int nextCol = col + direction[1];
            // Explore if valid land cell
            if (nextRow >= 0 && nextCol >= 0 && nextRow < rows && nextCol < cols && grid[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                exploreIsland(grid, nextRow, nextCol, visited);
            }
        }
    }

}

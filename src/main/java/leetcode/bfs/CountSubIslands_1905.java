package leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 28.08.2024
 **/
public class CountSubIslands_1905 {

    public static void main(String[] args) {

    }

    // Directions in which we can traverse inside the grids.
    private final int[][] directions = {
            { 0, 1 },
            { 1, 0 },
            { 0, -1 },
            { -1, 0 },
    };


    // Traverse all cells of island starting at position (x, y) in 'grid2',
    // and check this island is a sub-island in 'grid1'.
    private boolean isSubIsland(final int x, final int y, final int[][] grid1, final int[][] grid2, final boolean[][] visited) {
        final int totalRows = grid2.length;
        final int totalCols = grid2[0].length;

        boolean isSubIsland = true;

        final Queue<int[]> pendingCells = new LinkedList<>();
        // Push the starting cell in the queue and mark it as visited.
        pendingCells.offer(new int[] { x, y });
        visited[x][y] = true;

        // Traverse on all cells using the breadth-first search method.
        while (!pendingCells.isEmpty()) {
            final int[] curr = pendingCells.poll();

            // If the current position cell is not a land cell in 'grid1',
            // then the current island can't be a sub-island.
            if (grid1[curr[0]][curr[1]] != 1) {
                isSubIsland = false;
            }

            for (final int[] direction : directions) {
                int nextX = curr[0] + direction[0];
                int nextY = curr[1] + direction[1];
                // If the next cell is inside 'grid2', is never visited and
                // is a land cell, then we traverse to the next cell.
                if (nextX >= 0 && nextY >= 0 && nextX < totalRows && nextY < totalCols &&
                        !visited[nextX][nextY] && grid2[nextX][nextY] == 1) {
                    // Push the next cell in the queue and mark it as visited.
                    pendingCells.offer(new int[] { nextX, nextY });
                    visited[nextX][nextY] = true;
                }
            }
        }

        return isSubIsland;
    }

    //Time O(mn) and Space O(mn)
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        final int totalRows = grid2.length;
        final int totalCols = grid2[0].length;

        final boolean[][] visited = new boolean[totalRows][totalCols];
        int subIslandCounts = 0;

        // Iterate on each cell in 'grid2'
        for (int x = 0; x < totalRows; ++x) {
            for (int y = 0; y < totalCols; ++y) {
                // If cell at the position (x, y) in the 'grid2' is not visited,
                // is a land cell in 'grid2', and the island
                // starting from this cell is a sub-island in 'grid1', then we
                // increment the count of sub-islands.
                if (!visited[x][y] && grid2[x][y] == 1 && isSubIsland(x, y, grid1, grid2, visited)) {
                    subIslandCounts += 1;
                }
            }
        }
        // Return total count of sub-islands.
        return subIslandCounts;
    }

    private int m, n;
    //Time O(mn) and Space is O(1)
    public int countSubIslandsDFS(int[][] grid1, int[][] grid2) {
        m = grid1.length;
        n = grid1[0].length;
        int count = 0;

        // Iterate over the grid to find sub-islands
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Start a DFS only if the current cell is part of grid2 and grid1
                if (grid2[i][j] == 1 && dfs(grid1, grid2, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid2[i][j] == 0) {
            return true;
        }

        // Mark the current cell in grid2 as visited
        grid2[i][j] = 0;

        // If the corresponding cell in grid1 is 0, it's not part of a valid sub-island
        boolean isSubIsland = (grid1[i][j] == 1);

        // Recursively visit all 4 directions
        isSubIsland &= dfs(grid1, grid2, i + 1, j);
        isSubIsland &= dfs(grid1, grid2, i - 1, j);
        isSubIsland &= dfs(grid1, grid2, i, j + 1);
        isSubIsland &= dfs(grid1, grid2, i, j - 1);

        return isSubIsland;
    }
}

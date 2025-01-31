package leetcode.dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 31.01.2025
 **/
public class MakingALargeIsland_827 {

    public static void main(String[] args) {

    }

    //Time O(3*(n*n)) and Space O(n*n)
    public static int largestIsland(final int[][] grid) {
        final Map<Integer, Integer> islandSizes = new HashMap<>();
        int islandId = 2;

        // Step 1: Mark all islands and calculate their sizes
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    islandSizes.put(islandId, exploreIsland(grid, islandId, row, col));
                    islandId++;
                }
            }
        }

        // If there are no islands, return 1
        if (islandSizes.isEmpty()) {
            return 1;
        }
        // If the entire grid is one island, return its size or size + 1
        if (islandSizes.size() == 1) {
            return (islandSizes.get(0) == grid.length * grid[0].length)
                    ? islandSizes.get(0) : islandSizes.get(islandId) + 1;
        }

        int maxIslandSize = 1;

        // Step 2: Try converting every 0 to 1 and calculate the resulting island size
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 0) {
                    int currentIslandSize = 1;
                    final Set<Integer> neighboringIslands = new HashSet<>();
                    // Check down
                    if (col + 1 < grid.length && grid[row + 1][col] > 1) {
                        neighboringIslands.add(grid[row + 1][col]);
                    }

                    // Check up
                    if (row - 1 >= 0 && grid[row - 1][col] > 1) {
                        neighboringIslands.add(grid[row - 1][col]);
                    }

                    // Check right
                    if (col + 1 < grid[0].length && grid[row][col + 1] > 1) {
                        neighboringIslands.add(grid[row][col + 1]);
                    }

                    // Check left
                    if (col - 1 >= 0 && grid[row][col - 1] > 1) {
                        neighboringIslands.add(grid[row][col - 1]);
                    }

                    // Sum the sizes of all unique neighboring islands
                    for (int id : neighboringIslands) {
                        currentIslandSize += islandSizes.get(id);
                    }

                    maxIslandSize = Math.max(maxIslandSize, currentIslandSize);
                }
            }
        }

        return maxIslandSize;
    }

    private static int exploreIsland(final int[][] grid, final int islandId, final int currentRow, final int currentColumn) {
        if (currentRow < 0 || currentRow >= grid.length || currentColumn < 0 || currentColumn >= grid[0].length || grid[currentRow][currentColumn] != 1)
            return 0;

        grid[currentRow][currentColumn] = islandId;
        return (1 + exploreIsland(grid, islandId, currentRow + 1, currentColumn) + exploreIsland(grid, islandId, currentRow - 1, currentColumn) +
                        exploreIsland(grid, islandId, currentRow, currentColumn + 1) + exploreIsland(grid, islandId, currentRow, currentColumn - 1));
    }
}

package leetcode.bfs;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 03.10.2025
 **/
public class TrappingRainWaterII_407 {

    public static void main(String[] args) {

    }

    public int trapRainWater(int[][] heightMap) {
        // Direction arrays
        final int[] dRow = { 0, 0, -1, 1 };
        final int[] dCol = { -1, 1, 0, 0 };

        final int numOfRows = heightMap.length;
        final int numOfCols = heightMap[0].length;

        final boolean[][] visited = new boolean[numOfRows][numOfCols];

        // Priority queue (min-heap) to process boundary cells in increasing height order
        final PriorityQueue<int[]> boundary = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Add the first and last column cells to the boundary and mark them as visited
        for (int i = 0; i < numOfRows; i++) {
            boundary.offer(new int[] {heightMap[i][0], i, 0});
            boundary.offer(new int[] {heightMap[i][numOfCols - 1], i, numOfCols - 1});
            // Mark left and right boundary cells as visited
            visited[i][0] = visited[i][numOfCols - 1] = true;
        }

        // Add the first and last row cells to the boundary and mark them as visited
        for (int i = 0; i < numOfCols; i++) {
            boundary.offer(new int[] {heightMap[0][i], 0, i});
            boundary.offer(new int[] {heightMap[numOfRows - 1][i], numOfRows - 1, i});
            // Mark top and bottom boundary cells as visited
            visited[0][i] = visited[numOfRows - 1][i] = true;
        }

        // Initialize the total water volume to 0
        int totalWaterVolume = 0;

        // Process cells in the boundary (min-heap will always pop the smallest height)
        while (!boundary.isEmpty()) {
            // Pop the cell with the smallest height from the boundary
            final int[] currentCell = boundary.poll();

            int currentRow = currentCell[1];
            int currentCol = currentCell[2];
            int minBoundaryHeight = currentCell[0];

            // Explore all 4 neighboring cells
            for (int direction = 0; direction < 4; direction++) {
                // Calculate the row and column of the neighbor
                int neighborRow = currentRow + dRow[direction];
                int neighborCol = currentCol + dCol[direction];

                // Check if the neighbor is within the grid bounds and not yet visited
                if ((neighborRow >= 0 && neighborCol >= 0 && neighborRow < numOfRows && neighborCol < numOfCols) &&
                                !visited[neighborRow][neighborCol]) {
                    // Get the height of the neighbor cell
                    int neighborHeight = heightMap[neighborRow][neighborCol];

                    // If the neighbor's height is less than the current boundary height, water can be trapped
                    if (neighborHeight < minBoundaryHeight) {
                        // Add the trapped water volume
                        totalWaterVolume += minBoundaryHeight - neighborHeight;
                    }

                    // Push the neighbor into the boundary with updated height (to prevent water leakage)
                    boundary.offer(
                            new int[]{
                                    Math.max(neighborHeight, minBoundaryHeight),
                                    neighborRow,
                                    neighborCol
                            }
                    );
                    visited[neighborRow][neighborCol] = true;
                }
            }
        }

        // Return the total amount of trapped water
        return totalWaterVolume;
    }


    // Class to store the height and coordinates of a cell in the grid
    private static class Cell implements Comparable<Cell> {
        int height;
        int row;
        int col;

        public Cell(final int height, final int row, final int col) {
            this.height = height;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(final Cell other) {
            return Integer.compare(this.height, other.height);
        }
    }
}

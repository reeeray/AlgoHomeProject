package leetcode.bfs;

import java.util.PriorityQueue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 19.01.2025
 **/
public class TrappingRainWater2_407 {

    public static void main(String[] args) {

    }

    //Time O(n*m*log(nm)) and Space O(n*m)
    public int trapRainWater(int[][] heightMap) {
        // Direction arrays
        final int[][] directions = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        final int rows = heightMap.length;
        final int cols = heightMap[0].length;
        final boolean[][] visited = new boolean[rows][cols];
        // Priority queue (min-heap) to process boundary cells in increasing height order
        final PriorityQueue<Cell> boundary = new PriorityQueue<>();

        // Add the first and last column cells to the boundary and mark them as visited
        for (int i = 0; i < rows; i++) {
            boundary.offer(new Cell(heightMap[i][0], i, 0));
            boundary.offer(new Cell(heightMap[i][cols - 1], i, cols - 1));
            // Mark left and right boundary cells as visited
            visited[i][0] = visited[i][cols - 1] = true;
        }

        // Add the first and last row cells to the boundary and mark them as visited
        for (int i = 0; i < cols; i++) {
            boundary.offer(new Cell(heightMap[0][i], 0, i));
            boundary.offer(new Cell(heightMap[rows - 1][i], rows - 1, i));
            // Mark top and bottom boundary cells as visited
            visited[0][i] = visited[rows - 1][i] = true;
        }

        // Initialize the total water volume to 0
        int totalWaterVolume = 0;

        // Process cells in the boundary (min-heap will always pop the smallest height)
        while (!boundary.isEmpty()) {
            // Pop the cell with the smallest height from the boundary
            final Cell currentCell = boundary.poll();

            // Explore all 4 neighboring cells
            for (int direction = 0; direction < 4; direction++) {
                // Calculate the row and column of the neighbor
                int neighborRow = currentCell.row + directions[direction][0];
                int neighborCol = currentCell.col + directions[direction][1];

                // Check if the neighbor is within the grid bounds and not yet visited
                if (neighborRow >= 0 && neighborCol >= 0 && neighborRow < rows && neighborCol < cols && !visited[neighborRow][neighborCol]) {
                    // Get the height of the neighbor cell
                    final int neighborHeight = heightMap[neighborRow][neighborCol];

                    // If the neighbor's height is less than the current boundary height, water can be trapped
                    if (neighborHeight < currentCell.height) {
                        // Add the trapped water volume
                        totalWaterVolume += currentCell.height - neighborHeight;
                    }

                    // Push the neighbor into the boundary with updated height (to prevent water leakage)
                    boundary.offer(new Cell(Math.max(neighborHeight, currentCell.height), neighborRow, neighborCol));
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

        // Constructor to initialize a cell
        public Cell(final int height, final int row, final int col) {
            this.height = height;
            this.row = row;
            this.col = col;
        }

        // Overload the compareTo method to make the priority queue a min-heap based on height
        @Override
        public int compareTo(final Cell other) {
            // Min-heap comparison
            return Integer.compare(this.height, other.height);
        }
    }
}

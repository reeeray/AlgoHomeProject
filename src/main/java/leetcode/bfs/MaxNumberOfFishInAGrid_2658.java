package leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 28.01.2025
 **/
public class MaxNumberOfFishInAGrid_2658 {

    public static void main(String[] args) {
        final int[][] input = new int[][] {{6, 1, 10}};
        findMaxFish(input);
    }

    //Time O(mn) and Space O(mn)
    public static int findMaxFish(final int[][] grid) {
        final int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int maxFish = 0;
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if(grid[row][col] != 0) {
                    maxFish = Math.max(maxFish, bfs(grid, row, col, directions));
                }
            }
        }
        return maxFish;
    }

    private static int bfs(final int[][] grid, final int row, final int col, final int[][] directions) {
        int max = 0;
        final Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {row, col});
        while (!queue.isEmpty()) {
            final int size = queue.size();
            for(int i=0; i<size; i++) {
                final int[] cell = queue.poll();
                max += grid[cell[0]][cell[1]];
                grid[cell[0]][cell[1]] = 0;
                for(final int[] dir : directions) {
                    final int newRow = cell[0] + dir[0];
                    final int newCol = cell[1] + dir[1];
                    if(newRow > -1 && newCol > - 1 && newRow < grid.length && newCol < grid[0].length && grid[newRow][newCol] != 0) {
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }
        return max;
    }
}

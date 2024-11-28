package leetcode.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 28.11.2024
 **/
public class MinObstacleRemovalToReachCorner_2290 {

    public static void main(String[] args) {

    }

    //Space O(nm) and Time O(nm)
    public static int minObstacles(final int[][] grid) {
        final int[][] directions = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        // Distance matrix to store the minimum obstacles removed to reach each cell
        final int[][] dp = new int[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        final Deque<int[]> deque = new ArrayDeque<>();
        // {obstacles, row, col}
        deque.add(new int[] {0, 0, 0});
        while (!deque.isEmpty()) {
            final int[] curr = deque.poll();
            for(final int[] dir : directions) {
                final int nextRow = curr[1] + dir[0], nextCol = curr[2] + dir[1];
                if(nextRow > -1 && nextRow < grid.length && nextCol > - 1 && nextCol < grid[0].length && dp[nextRow][nextCol] == Integer.MAX_VALUE) {
                    if(grid[nextRow][nextCol] == 1) {
                        dp[nextRow][nextCol] = curr[0] + 1;
                        deque.addLast(new int[] {dp[nextRow][nextCol], nextRow, nextCol});
                    } else {
                        dp[nextRow][nextCol] = curr[0];
                        deque.addFirst(new int[] {curr[0], nextRow, nextCol});
                    }
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}

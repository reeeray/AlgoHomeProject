package leetcode.bfs;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 18.01.2025
 **/
public class MinCostToMakeAtLeastOneValidPathInAGrid_1368 {

    private static int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {

    }

    //Space O(n * m) where n is number or rows in grid and m is number of cols in grid, Time O(n * m)
    public static int minCost(final int[][] grid) {
        final int[][] minCost = new int[grid.length][grid[0].length];
        for(final int[] arr : minCost) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        //0 moves step to front, changed move to the end
        final Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{0, 0});
        minCost[0][0] = 0;
        while(!deque.isEmpty()) {
            final int[] curr = deque.pollFirst();
            for(int i=0; i<directions.length; i++) {
                final int newRow = curr[0] + directions[i][0];
                final int newCol = curr[1] + directions[i][1];
                final int newCost = grid[curr[0]][curr[1]] == i + 1 ? 0 : 1;

                if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                        && minCost[curr[0]][curr[1]] + newCost < minCost[newRow][newCol]) {
                    minCost[newRow][newCol] = minCost[curr[0]][curr[1]] + newCost;
                    if(newCost == 0) {
                        deque.offerFirst(new int[] {newRow, newCol});
                    } else {
                        deque.offerLast(new int[] {newRow, newCol});
                    }
                }
            }
        }
        return minCost[grid.length - 1][grid[0].length - 1];
    }

    //It's a combination DFS and BFS, sp the complexity is the same, Time O(n*m) and Space O(n*m)
    public static int minCostDFS(final int[][] grid) {
        final int numRows = grid.length, numCols = grid[0].length;
        int cost = 0;

        // Track minimum cost to reach each cell
        final int[][] minCost = new int[numRows][numCols];
        for (int row = 0; row < numRows; row++) {
            Arrays.fill(minCost[row], Integer.MAX_VALUE);
        }

        // Queue for BFS part - stores cells that need cost increment
        final Queue<int[]> queue = new LinkedList<>();

        // Start DFS from origin with cost 0
        dfs(grid, 0, 0, minCost, cost, queue);

        // BFS part - process cells level by level with increasing cost
        while (!queue.isEmpty()) {
            cost++;
            int levelSize = queue.size();

            while (levelSize-- > 0) {
                final int[] curr = queue.poll();
                final int row = curr[0], col = curr[1];

                // Try all 4 directions for next level
                for (int dir = 0; dir < 4; dir++) {
                    dfs(
                            grid,
                            row + directions[dir][0],
                            col + directions[dir][1],
                            minCost,
                            cost,
                            queue
                    );
                }
            }
        }

        return minCost[numRows - 1][numCols - 1];
    }

    // DFS to explore all reachable cells with current cost
    private static void dfs(final int[][] grid, final int row, final int col, final int[][] minCost, final int cost, final Queue<int[]> queue) {
        if (!isUnvisited(minCost, row, col)) return;

        minCost[row][col] = cost;
        queue.offer(new int[] { row, col });

        // Follow the arrow direction without cost increase
        int nextDir = grid[row][col] - 1;
        dfs(grid,row + directions[nextDir][0], col + directions[nextDir][1], minCost, cost, queue);
    }

    // Check if cell is within bounds and unvisited
    private static boolean isUnvisited(final int[][] minCost, final int row, final int col) {
        return (row >= 0 && col >= 0 && row < minCost.length && col < minCost[0].length &&
                        minCost[row][col] == Integer.MAX_VALUE
        );
    }


}

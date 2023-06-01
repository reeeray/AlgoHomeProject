package leetcode.arrays;

import java.util.LinkedList;
import java.util.Queue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 01.06.2023
 **/
public class ShortestPathInBinaryMatrix_1091 {

    private static int shortest;

    public static void main(String[] args) {
        final int[][] input = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(shortestPathBinaryMatrixBFS(input));
    }

    public static int shortestPathBinaryMatrixBFS(final int[][] grid) {
        final int n= grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1;
        }

        final int[] dx = {-1, 0, 1};
        final int[] dy = {-1, 0, 1};
        final Queue<int[]> bfs = new LinkedList<>();
        bfs.offer(new int[] {0, 0, 1});
        grid[0][0] = 1;

        while (!bfs.isEmpty()) {
            final int[] currPos = bfs.poll();
            if(currPos[0] == n - 1 && currPos[1] == n - 1) {
                return currPos[2];
            }

            for(int i=0; i<dx.length; i++) {
                for(int j=0; j<dy.length; j++) {
                    final int nsx = currPos[0] + dx[i];
                    final int nsy = currPos[1] + dy[j];

                    if(nsx >=0 && nsx < n && nsy >=0 && nsy < n && grid[nsx][nsy] == 0) {
                        bfs.offer(new int[] {nsx, nsy, currPos[2] + 1});
                        grid[nsx][nsy] = 1;
                    }
                }
            }
        }

        return -1;
    }

    public static int shortestPathBinaryMatrixViaDFS(final int[][] grid) {
        if(grid[0][0] == 1|| grid[grid.length-1][grid.length-1] == 1) {
            return -1;
        }
        shortest = Integer.MAX_VALUE;
        dfs(grid, 0, 0, 1);
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }

    //TLE at some use cases
    private static void dfs(final int[][] grid, final int row, final int col, final int count) {
        if(row >= grid.length || row < 0 || col >= grid.length || col < 0 || grid[row][col] == 1) {
            return;
        }

        if(row == grid.length - 1 && col == grid.length - 1) {
            shortest = Math.min(shortest, count);
            grid[row][col] = 0;
        }
        grid[row][col] = 1;
        dfs(grid, row+1, col+1, count + 1);
        dfs(grid, row + 1, col, count + 1);
        dfs(grid, row, col + 1, count + 1);
        dfs(grid, row-1, col+1, count + 1);
        dfs(grid, row+1, col-1, count + 1);
        dfs(grid, row-1, col-1, count + 1);
        dfs(grid, row, col - 1, count + 1);
        dfs(grid, row - 1, col, count + 1);
        grid[row][col] = 0;
    }
}

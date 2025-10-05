package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 05.10.2025
 **/
public class PacificAtlanticWaterFlow_417 {

    public static void main(String[] args) {

    }

    private static final int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    //Time O(mn) and Space O(mn)
    public static List<List<Integer>> pacificAtlantic(final int[][] heights) {
        final int rows = heights.length;
        final int cols = heights[0].length;
        final boolean[][] pacific = new boolean[rows][cols];
        final boolean[][] atlantic = new boolean[rows][cols];
        for(int i = 0; i < rows; i++) dfs(i, 0, heights, pacific);
        for(int j = 0; j < cols; j++) dfs(0, j, heights, pacific);
        for(int i = 0; i < rows; i++) dfs(i, cols - 1, heights, atlantic);
        for(int j = 0; j < cols; j++) dfs(rows - 1, j, heights, atlantic);

        final List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }
        return res;
    }

    private static void dfs(final int row, final int col, final int[][] heights, final boolean[][] visited) {
        if(visited[row][col]) return;
        visited[row][col] = true;
        for(final int[] dir : dirs) {
            final int newRow = row + dir[0];
            final int newCol = col + dir[1];
            if(newRow < 0 || newRow >= visited.length || newCol < 0 || newCol >= visited[0].length) continue;
            if(heights[newRow][newCol] < heights[row][col]) continue;
            dfs(newRow, newCol, heights, visited);
        }
    }
}

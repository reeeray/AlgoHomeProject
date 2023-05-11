package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 06.04.2023
 **/
public class NumberOfClosedIslands_1254 {

    public static void main(String[] args) {
        final int[][] map = {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
        assert 2 == closedIsland(map);
    }

    public static int closedIsland(final int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;

        //fill with water all connected to borders land
        for(int i=0; i<m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n-1);
        }
        for(int j=0; j<n; j++) {
            dfs(grid, 0, j);
            dfs(grid, m-1, j);
        }

        //count all islands which left and fill it with water after counting
        int result = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 0) {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    private static void dfs(final int[][] grid, final int row, final int col) {
        if(row < 0 || row > grid.length-1 || col < 0 || col > grid[0].length-1 || grid[row][col] == 1) return;
        grid[row][col] = 1;
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }
}

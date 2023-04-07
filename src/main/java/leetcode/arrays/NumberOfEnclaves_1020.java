package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 07.04.2023
 **/
public class NumberOfEnclaves_1020 {

    public static void main(String[] args) {
        final int[][] input = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        assert 3 == numEnclaves(input);
    }

    public static int numEnclaves(final int[][] grid) {
        final int row = grid.length;
        final int col = grid[0].length;

        //fill up border connected land
        for(int i=0; i<row; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, col-1);
        }
        for(int j=0; j<col; j++) {
            dfs(grid, 0, j);
            dfs(grid, row-1, j);
        }

        //calculate islands
        int result = 0;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(grid[i][j] == 1) {
                    result += dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    private static int dfs(final int[][] map, final int row, final int col) {
        if(row < 0 || row > map.length-1 || col < 0 || col > map[0].length - 1 || map[row][col] == 0) return 0;
        int res = 0;
        map[row][col] = 0;
        res += dfs(map, row + 1, col);
        res += dfs(map, row - 1, col);
        res += dfs(map, row, col - 1);
        res += dfs(map, row, col + 1);

        return res + 1;
    }
}

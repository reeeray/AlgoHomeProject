package leetcode.graphs;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 30.06.2023
 **/
public class LastDayWhereYouCanStillCross_1970 {

    public static void main(String[] args) {

    }

    private final static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


    /**
     * This is via DFS. Time complexity O(m*n*Log(m*n)) and Space O(m*n)
     * Possible Solutions : via BFS and 2 ways via DSU(disjoint union find)
     * @param row
     * @param col
     * @param cells
     * @return
     */
    public static int latestDayToCross(final int row, final int col, final int[][] cells) {
        int goodWeather = 1, badWeather = row*col;
        while(goodWeather < badWeather) {
//            final int rubicon = (goodWeather + badWeather) / 2; TLE
            final int rubicon = badWeather - (badWeather - goodWeather) / 2;
            if(canCross(row, col, cells, rubicon)) {
                goodWeather = rubicon;
            } else {
                badWeather = rubicon - 1;
            }
        }
        return goodWeather;
    }

    private static boolean canCross(final int row, final int col, final int[][] cells, final int currDay) {
        final int[][] grid = new int[row][col];
        for(int i=0; i<currDay; i++) {
            grid[cells[i][0]][cells[i][1]] = 1;
        }

        for(int i=0; i<col; i++) {
            if(grid[0][i] == 0 && dfs(grid, 0, i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean dfs(final int[][] grid, final int row, final int col) {
        final int m =grid.length, n = grid[0].length;
        if(col < 0 || col >= n || row < 0 || row >= m || grid[row][col] != 0) {
            return false;
        }
        if(row == m - 1) {
            return true;
        }
        grid[row][col] = -1;
        for(int[] d : directions) {
            final int r = row + d[0], c = col + d[1];
            if(dfs(grid, r, c)) {
                return true;
            }

        }
        return false;
    }
}

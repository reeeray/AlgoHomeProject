package leetcode.grids;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 18.03.2026
 **/
public class CountSubmatricesWithTopLeftElementAndSumLessThanK_3070 {

    public static void main(String[] args) {
        countSubmatrices(new int[][] {{7,2,9},{1,5,0},{2,6,6}}, 20);
    }

    //DP Time (rowcol) Space O(1)
    public static int countSubmatrices(final int[][] grid, final int k) {
        int res = 0;
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                final int cellVal = (row > 0 ? grid[row - 1][col] : 0) + (col > 0 ? grid[row][col - 1] : 0) - (row > 0 && col > 0 ? grid[row - 1][col - 1] : 0) + grid[row][col];
                if(cellVal <= k) {
                    res++;
                    grid[row][col] = cellVal;
                } else {
                    grid[row][col] = k + 1;
                    break;
                }
            }
        }
        return res;
    }

    //Time O(rowcol) and Space O(row)
    public int countSubmatricesMemNonOpt(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[] cols = new int[m];
        int res = 0;

        for (int i = 0; i < n; i++) {
            int rows = 0;
            for (int j = 0; j < m; j++) {
                cols[j] += grid[i][j];
                rows += cols[j];
                if (rows <= k) {
                    res++;
                }
            }
        }

        return res;
    }
}

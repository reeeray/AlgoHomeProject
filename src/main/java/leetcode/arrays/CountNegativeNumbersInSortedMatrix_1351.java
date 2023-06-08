package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 08.06.2023
 **/
public class CountNegativeNumbersInSortedMatrix_1351 {

    public static void main(String[] args) {

    }

    public static int countNegatives(final int[][] grid) {
        final int row = grid.length;
        final int col = grid[0].length;
        int res = 0;
        for(int i=0; i<row; i++) {
            for(int j=col-1; j>=0; j--) {
                if(grid[i][j] >= 0) {
                    break;
                }
                res++;
            }
        }
        return res;
    }
}

package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 14.12.2023
 **/
public class DifferenceBetweenOnesAndZerosInRowAndCol_2482 {

    public static void main(String[] args) {

    }

    //Time complexity O(m*n) and Space complexity O(m + n)
    public int[][] onesMinusZeros(final int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        final int[][] ans = new int[m][n];
        final int[] deltaInRows = new int[n];
        final int[] deltaInCols = new int[m];

        for(int i=0; i < m; i++) {
            for(int j=0; j < n; j++) {
                if(grid[i][j] == 1) {
                    deltaInCols[j] += 1;
                    deltaInRows[i] +=1;
                } else {
                    deltaInCols[j] -= 1;
                    deltaInRows[i] -=1;
                }
            }
        }

        for(int i=0; i < m; i++) {
            for(int j=0; j < n; j++) {
                ans[i][j] = deltaInRows[i] + deltaInCols[j];
            }
        }
        return ans;
    }
}

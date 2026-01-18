package leetcode.grids;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 18.01.2026
 **/
public class LargestMagicSquare_1895 {

    public static void main(String[] args) {

    }

    public static int largestMagicSquare(final int[][] grid) {
        final int rows = grid.length;
        final int cols = grid[0].length;
        int side = Math.min(rows, cols);
        while (side > 0) {
            for(int row = 0; row + side <= rows; row++) {
                for(int col = 0; col + side <= cols; col++) {
                    if(isMagic(grid, row, col, side)) return side;
                }
            }
            side--;
        }
        return 0;
    }

    private static boolean isMagic(final int[][] grid, final int row, final int col, final int side) {
        int sum = 0;
        for(int r = row; r < row + side; r++) {
            int currSum = 0;
            for(int c = col; c < col + side; c++) {
                currSum += grid[r][c];
            }
            if(r == row) sum = currSum;
            else if (sum != currSum) return false;
        }

        for(int c = col; c < col + side; c++) {
            int currSum = 0;
            for(int r = row; r < row + side; r++) {
                currSum += grid[r][c];
            }
            if (sum != currSum) return false;
        }

        int currSum = 0;
        for(int k = 0; k < side; k++) {
            currSum += grid[row + k][col + k];
        }
        if(sum != currSum) return false;
        currSum = 0;
        for(int k = 0; k < side; k++) {
            currSum += grid[row + k][col + side - 1 - k];
        }
        return sum == currSum;
    }
}

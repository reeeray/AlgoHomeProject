package leetcode.grids;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 25.03.2026
 **/
public class EqualSumGridPartitionI_3546 {

    public static void main(String[] args) {

    }

    //can be some optimizations but in general space O(1) and Time O(3nm)
    public static boolean canPartitionGrid(final int[][] grid) {
        final int rows = grid.length;
        final int cols = grid[0].length;
        long sum = 0;

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                sum += grid[row][col];
            }
        }
        long currSum = 0;
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                currSum += grid[row][col];
            }
            if((sum - currSum) == currSum) return true;
        }
        currSum = 0;
        for(int col = 0; col < cols; col++) {
            for(int row = 0; row < rows; row++) {
                currSum += grid[row][col];
            }
            if((sum - currSum) == currSum) return true;
        }
        return false;
    }
}

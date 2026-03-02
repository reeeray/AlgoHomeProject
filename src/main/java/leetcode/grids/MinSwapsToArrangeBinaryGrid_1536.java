package leetcode.grids;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 02.03.2026
 **/
public class MinSwapsToArrangeBinaryGrid_1536 {

    public static void main(String[] args) {

    }

    //Greedy : simulation with proper data representation. Time O(n^2) and Space O(n)
    public static int minSwaps(final int[][] grid) {
        final int[] dp = new int[grid.length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = grid[i].length - 1; j > -1; j--) {
                if(grid[i][j] == 1) {
                    dp[i] = j;
                    break;
                }
            }
        }
        int res = 0;
        for(int i = 0; i < dp.length; i++) {
            int swapIndex = -1;
            for(int j = i; j < dp.length; j++) {
                if(dp[j] <= i) {
                    res += j - i;
                    swapIndex = j;
                    break;
                }
            }
            if(swapIndex > -1) {
                for(int j = swapIndex; j > i; j--) {
                    final int tmp = dp[j];
                    dp[j] = dp[j - 1];
                    dp[j - 1] = tmp;
                }
            } else {
                return -1;
            }
        }
        return res;
    }
}

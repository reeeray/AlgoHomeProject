package leetcode.dp;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 08.01.2026
 **/
public class MaxDotProductOfTwoSubsequences_1458 {

    public static void main(String[] args) {

    }

    public static int maxDotProduct(final int[] nums1, final int[] nums2) {
        final int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for(int i = 0; i < nums1.length; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        for(int row = 1; row < nums1.length; row++) {
            for(int col = 1; col < nums2.length; col++) {
                final int currPossible = dp[row - 1][col - 1] + nums1[row - 1] * nums2[col - 1];
                dp[row][col] = Math.max(currPossible, Math.max(dp[row - 1][col], dp[row][col - 1]));
            }
        }
        return dp[nums1.length][nums2.length];
    }
}

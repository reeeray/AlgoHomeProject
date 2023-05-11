package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 11.05.2023
 **/
public class UncrossedLines_1035 {

    public static void main(String[] args) {

    }


    private static int maxUncrossedLines(final int[] nums1, final int[] nums2) {
        final int n1 = nums1.length;
        final int n2 = nums2.length;
        final int[][] dp = new int[n1+1][n2+1];
        for(int i=0; i<n1; i++) {
            for(int j=0; j<n2; j++) {
                if(i==0 || j==0) {
                    dp[i][j] = 0;
                } else if(nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2];
    }
}

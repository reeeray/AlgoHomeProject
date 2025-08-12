package leetcode.dp;

import leetcode.structures.Pair;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 12.08.2025
 **/
public class WaysToExpressAnIntegerAsSumOfPowers_2787 {

    public static void main(String[] args) {

    }

    //Time O(n^2) and Space O(n^2)
    public static int numberOfWays(final int n, final int x) {
        final int MOD = (int)1e9 + 7;
        final int[][] dp = new int[n + 1][n + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= n; i++) {
            final int val = (int)Math.pow(i, x);
            for(int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if(j >= val) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - val]) % MOD;
                }
            }
        }
        return (int)dp[n][n];
    }

    //Time O(nsqrt(n)) and Space O(n)
    public static int numberOfWaysOptimized(final int n, final int x) {
        final int MOD = (int)1e9 + 7;
        final int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            final int val = (int) Math.pow(i, x);
            if(val > n) {
                break;
            }
            for(int j = n; j >= val; j++) {
                dp[j] = (dp[j] + dp[j -val]) % MOD;
            }
        }
        return dp[n];
    }
}

package leetcode.dp;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 15.10.2023
 **/
public class NumberOfWaysTOAtTheSamePlace_1269 {

    private final int MOD = 1_000_000_007;
    private int[][] dp;

    public static void main(String[] args) {

    }

    //Space optimized Bottom-OP DP
    public int numWaysIterative(final int steps, final int arrLen) {
        final int MOD = (int) 1e9 + 7;
        final int m = Math.min(arrLen, steps);
        int[] dp = new int[m];
        int[] prevDp = new int[m];
        prevDp[0] = 1;

        for (int remain = 1; remain <= steps; remain++) {
            dp = new int[arrLen];

            for (int curr = m - 1; curr >= 0; curr--) {
                int ans = prevDp[curr];
                if (curr > 0) {
                    ans = (ans + prevDp[curr - 1]) % MOD;
                }

                if (curr < arrLen - 1) {
                    ans = (ans + prevDp[curr + 1]) % MOD;
                }

                dp[curr] = ans;
            }

            prevDp = dp;
        }

        return dp[0];
    }

    //TOP-DOWN DP Space and Time complexity are O(n*min(m))
    public int numWays(final int steps, final int arrLen) {
        final int n = Math.min(steps, arrLen);
        dp = new int[n][steps + 1];
        for(final int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return dp(0, steps);
    }

    private int dp(final int index, final int remain) {
        if(remain == 0) {
            return index == 0 ? 1 : 0;
        }

        if(dp[index][remain] != -1) {
            return dp[index][remain];
        }

        int ans = dp(index, remain - 1);
        if(index > 0) {
            ans += dp[index - 1][remain - 1] == -1 ? dp(index - 1, remain - 1) : dp[index - 1][remain - 1];
            ans%=MOD;
        }

        if( index < dp.length - 1) {
            ans += dp[index + 1][remain - 1] == -1 ? dp(index + 1, remain - 1) : dp[index - 1][remain - 1];
            ans%=MOD;
        }
        return dp[index][remain] = ans%MOD;

    }
}

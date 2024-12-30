package leetcode.dp;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 30.12.2024
 **/
public class CountWaysToBuildGoodStrings_2466 {

    public static void main(String[] args) {

    }

    //Time O(high) and Space O(high)
    public static int countGoodStringsIterative(final int low, final int high, final int one, final int zero) {
        // Use dp[i] to record the number of good strings of length i.
        final int[] dp = new int[high + 1];
        dp[0] = 1;
        final int mod = (int)(1e7 + 7);

        // Iterate over each length `end`.
        for (int end = 1; end <= high; ++end) {
            // check if the current string can be made by append zero `0`s or one `1`s.
            if (end >= zero) {
                dp[end] += dp[end - zero];
            }
            if (end >= one) {
                dp[end] += dp[end - one];
            }
            dp[end] %= mod;
        }

        // Add up the number of strings with each valid length [low ~ high].
        int answer = 0;
        for (int i = low; i <= high; ++i) {
            answer += dp[i];
            answer %= mod;
        }
        return answer;
    }

    // Use dp[i] to record to number of good strings of length i.
    private int[] dp;
    private final int mod = 1_000_000_007;

    //Time O(high) and Space O(high)
    public int countGoodStringsRecursiveDP(int low, int high, int zero, int one) {
        dp = new int[high + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;

        // Add up the number of strings with each valid length [low ~ high].
        int answer = 0;
        for (int end = low; end <= high; ++end) {
            answer += dfs(end, zero, one);
            answer %= mod;
        }
        return answer;

    }

    // Find the number of good strings of length `end`.
    private int dfs(int end, int zero, int one) {
        if (dp[end] != -1)
            return dp[end];
        int count = 0;
        if (end >= one) {
            count += dfs(end - one, zero, one);
        }
        if (end >= zero) {
            count += dfs(end - zero, zero, one);
        }
        dp[end] = count % mod;
        return dp[end];
    }
}

package leetcode.dp;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 27.11.2023
 **/
public class KnightDialer_935 {

    private static int num;
    private static int dp[][];
    private static int MOD = 1_000_000_007;
    private static int[][] dialPad = new int[][] {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3,  9, 0}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};
    public static void main(String[] args) {
        System.out.println(knightDialer(3131));
        System.out.println(knightDialerSpaceOptimized(3131));
    }

    //O(1) and O(1)
    public static int knightDialer(final int n) {
        num = n;
        dp = new int[n + 1][10];
        int ans = 0;
        for(int i=0; i<10; i++) {
            ans = (ans + dp(n - 1, i)) % MOD;
        }
        return ans;
    }

    private static int dp(final int remain, final int dial) {
        if(remain == 0) {
            return 1;
        }
        if(dp[remain][dial] != 0) {
            return dp[remain][dial];
        }

        int total = 0;
        for(int i : dialPad[dial]) {
            total = (total + dp(remain - 1, i)) % MOD;
        }
        dp[remain][dial] = total;
        return total;
    }

    public static int knightDialerSpaceOptimized(final int n) {
        int[] prevDP = new int[10];
        Arrays.fill(prevDP, 1);
        for(int i=1; i < n; i++) {
            final int[] dp = new int[10];
            for(int j=0; j < 10; j++) {
                int total = 0;
                for(int index : dialPad[j]) {
                    total = (total + prevDP[index]) % MOD;
                }
                dp[j] = total;
            }
            prevDP = dp;
        }
        int ans = 0;
        for(int i=0; i<10; i++) {
            ans = (ans + prevDP[i]) % MOD;
        }
        return ans;
    }
}

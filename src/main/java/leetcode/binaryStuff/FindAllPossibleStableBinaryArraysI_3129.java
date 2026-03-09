package leetcode.binaryStuff;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 09.03.2026
 **/
public class FindAllPossibleStableBinaryArraysI_3129 {

    private final static int MOD = (int)(1e9 + 7);
    private static int res = 0;
    public static void main(String[] args) {

    }

    //Dynamic Programming Time O(zero*one) and Space O(zero*one)
    public int numberOfStableArraysDP(int zero, int one, int limit) {
        final long MOD = 1000000007;
        final long[][][] dp = new long[zero + 1][one + 1][2];
        for (int i = 0; i <= Math.min(zero, limit); i++) {
            dp[i][0][0] = 1;
        }
        for (int j = 0; j <= Math.min(one, limit); j++) {
            dp[0][j][1] = 1;
        }
        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                if (i > limit) {
                    dp[i][j][0] =
                            dp[i - 1][j][0] +
                                    dp[i - 1][j][1] -
                                    dp[i - limit - 1][j][1];
                } else {
                    dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1];
                }
                dp[i][j][0] = ((dp[i][j][0] % MOD) + MOD) % MOD;
                if (j > limit) {
                    dp[i][j][1] =
                            dp[i][j - 1][1] +
                                    dp[i][j - 1][0] -
                                    dp[i][j - limit - 1][0];
                } else {
                    dp[i][j][1] = dp[i][j - 1][1] + dp[i][j - 1][0];
                }
                dp[i][j][1] = ((dp[i][j][1] % MOD) + MOD) % MOD;
            }
        }
        return (int) ((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }

    //TLE
    public static int numberOfStableArrays(int zero, int one, final int limit) {
        res = 0;
        dfs('0', zero, one, 1, 0, 1, limit);
        dfs('1', zero, one, 0, 1, 1, limit);
        return  res;
    }

    private static void dfs(final char prev, final int zero, final int one, final int numOfZeros, final int numOfOnes, final int strike, final int limit) {
        if(numOfOnes > one || numOfZeros > zero || strike > limit) return;
        if((zero + one) == (numOfOnes + numOfZeros)) {
            res = (res + 1)%MOD;
            return;
        }

        if(prev == '1') {
            dfs(prev, zero, one, numOfZeros, numOfOnes + 1, strike + 1, limit);
        } else {
            dfs('1', zero, one, numOfZeros, numOfOnes + 1, 1, limit);
        }

        if(prev == '0') {
            dfs(prev, zero, one, numOfZeros + 1, numOfOnes, strike + 1, limit);
        } else {
            dfs('0', zero, one, numOfZeros + 1, numOfOnes, 1, limit);
        }
    }
}

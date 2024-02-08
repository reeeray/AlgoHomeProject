package leetcode.pureLogic;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 22.11.2022
 **/
public class PerfectSquares_279 {

    public static void main(String[] args) {
        assert 2 == numSquares(53);

    }

    //
    private static int numSquares(final int n) {
        final int[] dp = new int [n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1; i<=n; i++) {
            int min = Integer.MAX_VALUE;
            for(int j=1; j*j <= i; j++) {
                min = Math.min(min, dp[i - j*j] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    //it's not more rfficient, it's TLE
    private static int numSquaresTLE(final int n) {
        if(n == 0)
            return 0;
        int mult = 1;
        for(int i=1; i<n; i++) {
            if(i*i > n) {
                mult = i -1;
                break;
            }
        }
        int steps = Integer.MAX_VALUE;
        for(int i=mult; i>0; i--) {
            if(i*i == n)
                return 1;
            steps = Math.min(steps, 1 +  numSquaresTLE(n-i*i));
        }
        return steps;
    }

}

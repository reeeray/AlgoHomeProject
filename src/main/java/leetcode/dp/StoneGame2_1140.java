package leetcode.dp;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.05.2023
 **/
public class StoneGame2_1140 {

    public static void main(String[] args) {

    }

    public int stoneGame(final int[] piles) {
        if(piles.length == 0) return 0;
        final int n = piles.length;

        final int[][] dp = new int[n][n];
        final int[] backTrackSum = new int[n];
        backTrackSum[n-1] = piles[n-1];
        for(int i=n-2; i>= 0; i--) {
            backTrackSum[i] = piles[i] + backTrackSum[i+1];
        }

        return bottomUp(piles, dp, backTrackSum, 0, 1);
    }

    private static int bottomUp(final int[] piles, final int[][] dp, final int[] backTrackSum, final int index, final int M) {
        if(index == piles.length) return 0;
        if(index + 2*M >= piles.length) return backTrackSum[index];

        if(dp[index][M] != 0) return dp[index][M];

        int res = 0;
        for(int k=1; k<=2*M; k++) {
            res = Math.max(res, backTrackSum[index] - bottomUp(piles, dp, backTrackSum, index + k, Math.max(M, k)));
        }
        dp[index][M] = res;

        return res;
    }
}

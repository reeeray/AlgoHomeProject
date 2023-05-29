package leetcode.dp;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 27.05.2023
 **/
public class StoneGame3_1406 {

    public String stoneGameIII(final int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[3];

        for (int i = n - 1; i >= 0; i--) {
            int takeOne = stoneValue[i] - dp[(i + 1) % 3];

            int takeTwo = Integer.MIN_VALUE;
            if (i + 1 < n)
                takeTwo = stoneValue[i] + stoneValue[i + 1] - dp[(i + 2) % 3];

            int takeThree = Integer.MIN_VALUE;
            if (i + 2 < n)
                takeThree = stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - dp[(i + 3) % 3];

            dp[i % 3] = Math.max(Math.max(takeOne, takeTwo), takeThree);
        }

        int value = dp[0];
        if (value > 0)
            return "Alice";
        else if (value < 0)
            return "Bob";
        else
            return "Tie";
    }

//    private static void bottomUp(final int[] piles, final int[][] dp, final int index, final boolean isAlice, int alice, int bob) {
//        if(index == piles.length) return;
//        if (index + 2 >= piles.length) {
//            int sum = 0;
//            for(int i=0; i<3 && index+i < piles.length; i++) {
//                sum += piles[index + i];
//            }
//            if (isAlice) {
//                alice += sum;
//            } else {
//                bob += sum;
//            }
//            return;
//        }
//        for(int i =0; i<3; i++) {
//            if (dp[index][i] != 0) return dp[index][i];
//
//            int res = 0;
//            res = Math.max(res, backTrackSum[index] - bottomUp(piles, dp, backTrackSum, index + k, Math.max(M, k)));
//
//            dp[index][i] = res;
//        }
//    }
}

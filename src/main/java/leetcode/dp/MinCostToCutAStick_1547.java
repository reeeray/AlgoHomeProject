package leetcode.dp;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 28.05.2023
 **/
public class MinCostToCutAStick_1547 {

    private static int[][] dp;

    public static void main(String[] args) {
//        final int[] cuts = {5, 6, 1, 4, 2};
//        System.out.println(minCostEff(9, cuts));
        final int[] cuts = {1, 3, 4, 5};
        System.out.println(minCostEff(7, cuts));

    }

    private static int minCost(final int n, final int[] cuts) {
        dp = new int[cuts.length][cuts.length];
        for(final int[] row : dp) {
            Arrays.fill(row, -1);
        }
        Arrays.sort(cuts);
        return solve(0, n, cuts, 0, cuts.length-1);
    }

    private static int solve(final int stickIndexLeft, final int stickIndexRight, final int[] cuts, final int left, final int right) {
        if(left > right) return 0;

        if(dp[left][right] != -1) return dp[left][right];
        int cost = Integer.MAX_VALUE;
        for(int i=left; i<= right; i++) {
            final int left_cost = solve(stickIndexLeft, cuts[i], cuts, left, i-1);
            final int right_cost = solve(cuts[i], stickIndexRight, cuts, i+1, right);
            cost = Math.min(cost, (stickIndexRight - stickIndexLeft) + left_cost + right_cost);
        }
        return dp[left][right] = cost;
    }

    //NOT WORKING!!!!!!!!!!!!!!Incorrect answer
    private static int minCostEff(final int n, final int[] cuts) {
        Arrays.sort(cuts);
        return solveEff(0, n, cuts, 0 ,cuts.length);
    }

    private static int solveEff (final int leftBound, final int rightBound, final int[] cuts, final int left, final int right) {
        if(right - left < 1) return 0;
        int minDiff = Integer.MAX_VALUE;
        int resCutIndex = 0;
        int balanceDiff = Integer.MAX_VALUE;
        for(int i=left; i<right; i++) {
            int diff = Math.abs((cuts[i] - leftBound) - (rightBound - cuts[i]));
            int bd = Math.abs( i - (cuts.length - 1 - i));
            if(diff <= minDiff) {
                if(diff == minDiff && bd > balanceDiff) {
                    continue;
                }
                if(diff == minDiff && bd == balanceDiff) {
                    int res1 = solveEff(leftBound, cuts[resCutIndex], cuts, left, resCutIndex)  + solveEff(cuts[resCutIndex], rightBound, cuts, resCutIndex + 1, cuts.length);
                    int res2 = solveEff(leftBound, cuts[i], cuts, left, i)  + solveEff(cuts[i], rightBound, cuts, i + 1, cuts.length);

                    if(res1 < res2) {
                        continue;
                    }
                }
                resCutIndex = i;
                minDiff = diff;
                balanceDiff = bd;
            }
        }

       return (rightBound - leftBound)
               + solveEff(leftBound, cuts[resCutIndex], cuts, left, resCutIndex)
               + solveEff(cuts[resCutIndex], rightBound, cuts, resCutIndex + 1, right);
    }
}

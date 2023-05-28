package leetcode.dp;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 28.05.2023
 **/
public class MinCostToCutAStick_1547 {

    private static int[][] dp;

    public static void main(String[] args) {

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
}

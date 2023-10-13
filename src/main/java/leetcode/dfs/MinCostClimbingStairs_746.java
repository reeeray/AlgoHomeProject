package leetcode.dfs;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 13.10.2023
 **/
public class MinCostClimbingStairs_746 {

    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        final int[] input = new int[] {1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(input));
    }

    //Space O(n) and Time O(n)
    public int minCostClimbingStairsDP(int[] cost) {
        final int n = cost.length;
        final int[] dp = new int[n];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return Math.min(dp[n - 1], dp[n - 2]);
    }

    //TLE Space O(n) Time O(2^n)
    public static int minCostSimplified(final int[] cost) {
        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }

    private static int dfs(final int[] cost, final int index) {
        if(index >= cost.length) {
            return 0;
        }
        return cost[index] + Math.min(dfs(cost, index + 1), dfs(cost, index + 2));
    }


    //TLE
    public static int minCostClimbingStairs(final int[] cost) {
        dfs(cost, 0, 0);
        dfs(cost, 1, 0);
        return min;
    }

    private static void dfs(final int[] cost, final int index, final int curr) {
        if(index >= cost.length) {
            min = Math.min(min, curr);
            return;
        }

        final int c = curr + cost[index];
        if(c >= min) {
            return;
        }
        dfs(cost, index + 1, c);
        dfs(cost, index + 2, c);
    }
}

package leetcode.pureLogic;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 14.10.2023
 **/
public class PaintingTheWalls_2742 {

    public static void main(String[] args) {
        final int[] cost = new int[]{2, 3, 4, 2};
        final int[] time = new int[]{1, 1, 1, 1};
        System.out.println(paintWalls(cost, time));

    }

    //Top-Down DP
    public int paintWallsDP(final int[] cost, final int[] time) {
        final int n = cost.length;
        return dp(0, n, cost, time, new int[n][n + 1]);
    }

    public int dp(final int index, final int remain, final int[] cost, final int[] time, final int[][] memo) {
        if (remain <= 0) {
            return 0;
        }

        if (index == cost.length) {
            return (int) 1e9;
        }

        if (memo[index][remain] != 0) {
            return memo[index][remain];
        }

        int paint = cost[index] + dp(index + 1, remain - 1 - time[index], cost, time, memo);
        int dontPaint = dp(index + 1, remain, cost, time, memo);
        memo[index][remain] = Math.min(paint, dontPaint);
        return memo[index][remain];
    }

    //nice try but at the final stage when they left 1 and 1 from each sides - not correct
    private static int paintWalls(final int[] cost, final int[] time) {
        final int n = cost.length;
        final Pair[] work = new Pair[n];
        for(int i=0; i<n; i++) {
            work[i] = new Pair(cost[i], time[i]);
        }
        Arrays.sort(work, (a, b) -> ((a.left / a.right) - (b.left / b.right)));

        int total = 0;
        int left = 0, right = n-1;
        while(left <= right) {
            final Pair payable = work[left++];
            total += payable.left;
            right -= payable.right;
        }
        return total;
    }

    private static class Pair {
        public int left;
        public int right;

        public Pair(final int left, final int right) {
            this.left = left;
            this.right = right;
        }
    }
}

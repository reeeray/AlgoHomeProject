package leetcode.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 08.07.2025
 **/
public class MaxNumberOfEventsThatCanBeAttendedII_1751 {

    public static void main(String[] args) {

    }

    private static int[][] dp;


    //Bottom up DP, looks more elegant but asymptotic stays the same
    public int maxValueMoreElegant(int[][] events, int k) {
        final int n = events.length;
        final int[][] dp = new int[k + 1][n + 1];
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        for (int curIndex = n - 1; curIndex >= 0; --curIndex) {
            for (int count = 1; count <= k; count++) {
                int nextIndex = bs(events, events[curIndex][1]);
                dp[count][curIndex] = Math.max(dp[count][curIndex + 1], events[curIndex][2] + dp[count - 1][nextIndex]);
            }
        }
        return dp[k][0];
    }


    //Top down DP
    //It's a Dynamic programming, Depth First Search and Binary Search all together
    //Space O(n*k) and Time O(n*k*logn)
    public static int maxValue(final int[][] events, final int k) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        //with casched next indexes slope of asymptotic goes lower : Time O(n(k + logn))
        //        nextIndices = new int[n];
        //        for (int curIndex = 0; curIndex < n; ++curIndex) {
        //            nextIndices[curIndex] = bisectRight(events, events[curIndex][1]);
        //        }
        //
        dp = new int[k + 1][events.length];
        for(final int[] event : dp) {
            Arrays.fill(event, -1);
        }
        return dfs(0, k, events);
    }

    private static int dfs(final int currIndex, final int currEventNumber, final int[][] events) {
        //corner cases
        if(currIndex == events.length || currEventNumber == 0) {
            return 0;
        }
        if(dp[currEventNumber][currIndex] != -1) {
            return dp[currEventNumber][currIndex];
        }
        final int nextIndex = bs(events, events[currIndex][1]);
        //we have 2 options either skip it or go for curr event
        dp[currEventNumber][currIndex] = Math.max(dfs(currIndex + 1, currEventNumber, events),
                dfs(nextIndex, currEventNumber - 1, events) + events[currIndex][2]);
        return dp[currEventNumber][currIndex];
    }

    private static int bs(final int[][] events, final int target) {
        int left = 0, right = events.length;
        while (left < right) {
            final int mid = (left + right) / 2;
            if(events[mid][0] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


}

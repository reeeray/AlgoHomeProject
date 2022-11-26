package leetcode.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.11.2022
 **/
public class MaxProfitInJobScheduling_1235 {

    public static void main(String[] args) {
        final int[] startTime = {1, 2, 3, 3};
        final int[] endTime = {3, 4, 5, 6};
        final int[] profit = {50, 10, 40, 70};

        assert 120 == jobScheduling(startTime, endTime, profit);

    }

    private static int jobScheduling(final int[] startTime, final int[] endTime, final int[] profit) {
        final int jobsNumber = startTime.length;
        final int[][] jobs = new int[jobsNumber][3];
        for(int i=0; i<jobsNumber; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(jobs, (x,y) -> x[0]-y[0] != 0 ? x[0] - y[0] : x[1] - y[1]);

        int[] dp = IntStream.range(0, jobsNumber+1).map(j -> 0).toArray();
        for (int i = jobsNumber-1; i >= 0; i--)
        {
            int k = Arrays.binarySearch(jobs, new int[]{jobs[i][1], 0, 0},
                    Comparator.comparingInt(j -> j[0]));
            k = (k>=0) ? k : -k-1;
            dp[i] = Math.max(dp[i+1], dp[k] + jobs[i][2]);
        }
        return dp[0];
    }
}

package leetcode.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 31.12.2024
 **/
public class MinCostForTickets_983 {

    private static final Set<Integer> travelTimes = new HashSet<>();

    //Time O(K) and Space O(K) where K is max day in days
    public static int mincostTickets(final int[] days, final int[] costs) {
        final int[] dp = new int[days[days.length - 1] + 1];
        Arrays.fill(dp, -1);
        for(final int day : days) {
            travelTimes.add(day);
        }

        return solve(dp, days, costs, 1);
    }

    private static int solve(final int[] dp, final int[] days, final int[] costs, final int day) {
        if(day > days[days.length - 1]) {
            return 0;
        }

        if(!travelTimes.contains(day)) {
            return solve(dp, days, costs, day + 1);
        }

        if(dp[day] != -1) {
            return dp[day];
        }

        final int dayTicket = costs[0] + solve(dp, days, costs, day + 1);
        final int weekTicket = costs[1] + solve(dp, days, costs, day + 7);
        final int monthTicket = costs[2] + solve(dp, days, costs, day + 30);

        return dp[day] = Math.min(dayTicket, Math.min(weekTicket, monthTicket));
    }

    //O(K) and O(K)
    public static int mincostTicketsBottomUpDP(final int[] days, final int[] costs) {
        // The last day on which we need to travel.
        final int lastDay = days[days.length - 1];
        final int dp[] = new int[lastDay + 1];
        Arrays.fill(dp, 0);

        int i = 0;
        for (int day = 1; day <= lastDay; day++) {
            // If we don't need to travel on this day, the cost won't change.
            if (day < days[i]) {
                dp[day] = dp[day - 1];
            } else {
                // Buy a pass on this day, and move on to the next travel day.
                i++;
                // Store the cost with the minimum of the three options.
                dp[day] = Math.min(dp[day - 1] + costs[0],
                        Math.min(dp[Math.max(0, day - 7)] + costs[1],
                                dp[Math.max(0, day - 30)] + costs[2]));
            }
        }

        return dp[lastDay];
    }
}

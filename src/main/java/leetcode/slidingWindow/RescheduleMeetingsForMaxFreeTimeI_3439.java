package leetcode.slidingWindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 09.07.2025
 **/
public class RescheduleMeetingsForMaxFreeTimeI_3439 {

    public static void main(String[] args) {
        maxFreeTime(34, 2, new int[] {0, 17}, new int[] {14, 19});
    }

    //Greedy + Sliding Window : Time O(n) and Space O(1)
    public int maxFreeTimeOptimum(final int eventTime, final int k, final int[] startTime, final int[] endTime) {
        int res = 0;
        int window = 0;
        for (int i = 0; i < startTime.length; i++) {
            window += endTime[i] - startTime[i];
            int left = i <= k - 1 ? 0 : endTime[i - k];
            int right = i == startTime.length - 1 ? eventTime : startTime[i + 1];
            res = Math.max(res, right - left - window);
            if (i >= k - 1) {
                window -= endTime[i - k + 1] - startTime[i - k + 1];
            }
        }
        return res;
    }

    //Greedy + Prefix sum : Time O(n) and Space O(n)
    public int maxFreeTimeGreedy(final int eventTime, final int k, final int[] startTime, final int[] endTime) {
        final int n = startTime.length;
        int res = 0;
        final int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + endTime[i] - startTime[i];
        }
        for (int i = k - 1; i < n; i++) {
            int right = i == n - 1 ? eventTime : startTime[i + 1];
            int left = i == k - 1 ? 0 : endTime[i - k];
            res = Math.max(res, right - left - (sum[i + 1] - sum[i - k + 1]));
        }
        return res;
    }


    //not correct implementation
    public static int maxFreeTime(final int eventTime, final int k, final int[] startTime, final int[] endTime) {
        final List<Integer> intervals = new ArrayList<>();
        int start = 0;
        for(int i = 0; i < startTime.length; i ++) {
            if(start < startTime[i]) {
                intervals.add(startTime[i] - start);
            }
            start = endTime[i];
        }
        if(start < eventTime) {
            intervals.add(eventTime - start);
        }
        Collections.sort(intervals);
        int res = 0;
        for(int i = 0; i <= k && i < intervals.size(); i++) {
            res += intervals.get(intervals.size() - 1 - i);
        }
        return res;
    }
}

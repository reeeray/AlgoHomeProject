package leetcode.slidingWindow;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 10.07.2025
 **/
public class RescheduleMeetingsForMaximumFreeTimeII_3440 {

    public static void main(String[] args) {

    }

    //Greedy : Time O(n) and Space O(n)
    public static int maxFreeTime(final int eventTime, final int[] startTime, final int[] endTime) {
        //There are two options : 1. it maybe space somewhere either left or right where we can move current meeting. That's why we need additional iteration
        //Option 2 : is that we can just merge 2 closest free spaces
        final boolean[] dp = new boolean[startTime.length];
        //we check in one iteration both sides
        for(int i = 0, t1 = 0, t2 = 0; i < startTime.length; i++) {
            if(t1 >= endTime[i] - startTime[i]) {
                dp[i] = true;
            }
            t1 = Math.max(t1, startTime[i] - (i == 0 ? 0 : endTime[i - 1]));
            if(t2 >= endTime[startTime.length - 1 - i] - startTime[startTime.length - 1 - i]) {
                dp[startTime.length - 1 - i] = true;
            }
            t2 = Math.max(t2, (i == 0 ? eventTime : startTime[startTime.length - i]) - endTime[startTime.length - i - 1]);
        }

        int maxGap = 0;
        for(int i = 0; i < startTime.length; i++) {
            final int left = i == 0 ? 0 : endTime[i - 1];
            final int right = i == startTime.length - 1 ? eventTime : startTime[i + 1];
            if(dp[i]) {
                maxGap = Math.max(maxGap, right - left);
            } else {
                maxGap = Math.max(maxGap, right - left - (endTime[i] - startTime[i]));
            }
        }
        return maxGap;
    }
}

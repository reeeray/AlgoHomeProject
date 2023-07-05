package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 05.07.2023
 **/
public class LongestArrayOf1AfterRemOne_1493 {

    public static void main(String[] args) {
        final int[] input = {0,0,1,0,1,0,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1};
        System.out.println(longestSubarraySliding(input));
    }

    public static int longestSubarray(final int[] nums) {
        int zeroCount = 0;
        int longestWindow = 0;
        // Left end of the window.
        int start = 0;
        for(int i=0; i<nums.length; i++) {
            zeroCount += nums[i] == 0 ? 1 : 0;

            // Shrink the window until the zero counts come under the limit.
            while(zeroCount > 1) {
                zeroCount -= nums[start++] == 0 ? 1 : 0;
            }
            longestWindow = Math.max(longestWindow, i - start);
        }
        return longestWindow;
    }

    public static int longestSubarraySliding(final int[] nums) {
        final int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int indexMid = -1;
        int max = 0;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] == 0) {
                if(i -1 == indexMid) {
                    dp[i] = 0;
                    indexMid = -1;
                } else if (indexMid != -1){
                    dp[i] = dp[i-1] - dp[indexMid];
                    indexMid = i;
                } else if (dp[i-1] != 0){
                    dp[i] = dp[i-1];
                    indexMid = i;
                } else {
                    dp[i] = 0;
                }
            } else {
                dp[i] = dp[i-1]+1;
            }
            max = Math.max(max, dp[i]);
        }
        return max == nums.length ? max - 1 : max;
    }
}

package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 06.07.2023
 **/
public class MinSizeSubArraySum_209 {

    public static void main(String[] args) {

    }

    public static int minSubArrayLen(final int target, final int[] nums) {
        int left = 0, window = 0;
        int res = Integer.MAX_VALUE;
        for(int right = 0; right<nums.length; right++) {
            window += nums[right];

            while (window >= target) {
                res = Math.min(res, right - left + 1);
                window -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

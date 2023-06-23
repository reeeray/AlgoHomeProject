package leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 23.06.2023
 **/
public class LongestArithmeticSubsequence_1027 {

    public static void main(String[] args) {
        final int[] nums = {20,1,15,3,10,5,8};
        assert 4 == longestArithmeticSubseqLen(nums);
    }

    public static int longestArithmeticSubseqLen(final int[] nums) {
        int maxLength = 0;
        final Map<Integer, Integer>[] dp = new HashMap[nums.length];
        for(int right=0; right<nums.length; right++) {
            dp[right] = new HashMap<>();
            for(int left=0; left<right; left++) {
                final int diff = nums[right] - nums[left];
                dp[right].put(diff, dp[left].getOrDefault(diff, 1) + 1);
                maxLength = Math.max(maxLength, dp[right].get(diff));

            }
        }
        return maxLength;
    }
}

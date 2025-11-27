package leetcode.dp;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 27.11.2025
 **/
public class MaxSubarraySumWithLengthDivisibleByK_3381 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(k)
    public static long maxSubarraySum(final int[] nums, final int k) {
        long prefixSum = 0;
        final long[] kArr = new long[k];
        long maxSum = Long.MIN_VALUE;
        Arrays.fill(kArr, Long.MAX_VALUE / 2);
        kArr[k - 1] = 0;
        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            maxSum = Math.max(maxSum, prefixSum - kArr[i % k]);
            kArr[i % k] = Math.min(kArr[i % k], prefixSum);
        }
        return maxSum;
    }
}

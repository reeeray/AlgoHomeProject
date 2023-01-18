package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 18.01.2023
 **/
public class MaxSumCircularSubArr_918 {

    public static void main(String[] args) {

    }


    /**
     *
     * Find the max between ordinary max subArray and special one which can rotate(circular).
     * Normal can be found via Kadane's algorithm.
     * Special one can be found by finding max sum in prefix and suffix.
     * Time O(n) and Space O(n)
     * @param nums
     * @return
     */
    public static int maxSubarraySumCircular(final int[] nums) {
        final int n = nums.length;
        final int[] rightMax = new int[n];
        rightMax[n - 1] = nums[n - 1];
        for (int suffixSum = nums[n - 1], i = n - 2; i >= 0; --i) {
            suffixSum += nums[i];
            rightMax[i] = Math.max(rightMax[i + 1], suffixSum);
        }
        int maxSum = nums[0];
        int specialSum = nums[0];
        for (int i = 0, prefixSum = 0, curMax = 0; i < n; ++i) {
            curMax = Math.max(curMax, 0) + nums[i];
            // This is Kadane's algorithm.
            maxSum = Math.max(maxSum, curMax);
            prefixSum += nums[i];
            if (i + 1 < n) {
                specialSum = Math.max(specialSum, prefixSum + rightMax[i + 1]);
            }
        }
        return Math.max(maxSum, specialSum);
    }

    /**
     * the same idea, but sum of special one could be found as totalSum - minSum.
     * minSum can be found also via Kadane's algorithm
     * @param nums
     * @return
     */
    private static int maxSubarraySumCircularOptimized(final int[] nums) {
        int currMax = 0, currMin = 0, sum = 0, maxSum = nums[0], minSum = nums[0];
        for(int num : nums) {
            //Kadane's for max sum
            currMax = Math.max(currMax, 0) + num;
            maxSum = Math.max(maxSum, currMax);

            //Kadane's for min sum
            currMin = Math.min(0, currMin) + num;
            minSum = Math.min(minSum, currMin);

            sum+=num;
        }
        return sum == minSum ? maxSum : Math.max(maxSum, sum - minSum);
    }
}

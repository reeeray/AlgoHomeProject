package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 18.01.2023
 **/
public class MaxSubArr_53 {

    public static void main(String[] args) {
        final int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        assert 6 == maxSubArr(input);
    }

    /**
     * Kadane's Algorithm of finding maximum sum of subArray
     * @param nums
     * @return
     */
    private static int maxSubArr(final int[] nums) {
        int subSum = nums[0], maxSum = nums[0];
        for(int i=0; i<nums.length; i++) {
            if(subSum < 0) {
                subSum = 0;
            }

            subSum += nums[i];
            maxSum = Math.max(maxSum, subSum);
        }
        return maxSum;
    }
}

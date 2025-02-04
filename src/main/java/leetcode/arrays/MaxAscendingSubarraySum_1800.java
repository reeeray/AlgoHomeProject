package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 04.02.2025
 **/
public class MaxAscendingSubarraySum_1800 {

    public static void main(String[] args) {
        final int[] input = new int[] {10, 20, 30, 5, 10 ,50};
        maxAscendingSum(input);
    }

    //Time O(n) and Space O(1)
    public static int maxAscendingSum(final int[] nums) {
        int maxSum = nums[0];
        int currSum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]) {
                currSum += nums[i];
            } else {
                maxSum = Math.max(maxSum, currSum);
                currSum = nums[i];
            }
        }
        return Math.max(currSum, maxSum);
    }
}

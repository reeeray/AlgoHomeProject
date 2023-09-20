package leetcode.slidingWindow;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 20.09.2023
 **/
public class MinOperationsToReduceXToZero_1658 {

    public static void main(String[] args) {

    }

    public static int minOperations(final int[] nums, final int x) {
        //we convert this problem into finding longest chain
        int target = -x, n = nums.length;
        for(int num : nums) {
            target += num;
        }
        if (target == 0) return n;

        int maxLen = 0, currSum = 0, left = 0;
        for(int right = 0; right < n; right++) {
            currSum += nums[right];
            while(left <= right && currSum > target) {
                currSum -= nums[left++];
            }
            if (currSum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        return maxLen != 0 ? n - maxLen : -1;
    }
}

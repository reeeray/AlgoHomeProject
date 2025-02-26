package leetcode.dp;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.02.2025
 **/
public class MaxAbsoluteSumOfAnySubarray_1749 {

    public static void main(String[] args) {

    }

    //Kadane's algorithm Time O(n) and Space O(1)
    public static int maxAbsoluteSum(final int[] nums) {
        int maxAbsSum = 0, minPrefixSum = Integer.MAX_VALUE, maxPrefixSum = Integer.MIN_VALUE, prefixSum = 0;
        for(final int num : nums) {
            prefixSum += num;
            minPrefixSum = Math.min(minPrefixSum, prefixSum);
            maxPrefixSum = Math.max(maxPrefixSum, prefixSum);

            if(prefixSum >= 0) {
                maxAbsSum = Math.max(maxAbsSum, Math.max(prefixSum, prefixSum - minPrefixSum));
            } else if (prefixSum <= 0){
                maxAbsSum = Math.max(maxAbsSum, Math.max(Math.abs(prefixSum), Math.abs(prefixSum - maxPrefixSum)));
            }
        }
        return maxAbsSum;
    }

    public static int maxAbsoluteSumSpaceOpt(final int[] nums) {
        int prefixSum = 0, maxPrefixSum = 0, minPrefixSum = 0;
        for(final int num : nums) {
            prefixSum += num;
            maxPrefixSum = Math.max(maxPrefixSum, prefixSum);
            minPrefixSum = Math.min(minPrefixSum, prefixSum);
        }
        return maxPrefixSum - minPrefixSum;
    }
}

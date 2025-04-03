package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 03.04.2025
 **/
public class MaxValueOfAnOrderedTriplet2_2874 {

    public static void main(String[] args) {

    }

    //Greedy Time O(n) and Space O(1)
    public static long maxTripletValue(final int[] nums) {
        long res = 0;
        int maxDiff = 0, maxLeft = 0;
        for(int k = 0; k < nums.length; k++) {
            res = Math.max(res, (long)maxDiff *nums[k]);
            maxDiff = Math.max(maxDiff, maxLeft - nums[k]);
            maxLeft = Math.max(maxLeft, nums[k]);
        }
        return res;
    }

    //Greedy plus prefix Time O(n) and Space O(n)
    public static long maxTripletValueGreedyPrefix(final int[] nums) {
        final int[] maxLeftPrefix = new int[nums.length];
        final int[] maxRightPrefix = new int[nums.length];
        long res = 0;
        for(int i = 1; i < nums.length; i++) {
            maxLeftPrefix[i] = Math.max(maxLeftPrefix[i - 1], nums[i - 1]);
            maxRightPrefix[nums.length - 1 - i] = Math.max(maxRightPrefix[nums.length - i], nums[nums.length - i]);
        }
        for(int j = 1; j < nums.length; j++) {
            res = Math.max(res, (long)(maxLeftPrefix[j] - nums[j])*maxRightPrefix[j]);
        }
        return res;
    }
}

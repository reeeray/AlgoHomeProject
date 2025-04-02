package leetcode.slidingWindow;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 02.04.2025
 **/
public class MaxValueOfAnOrderedTriplet1_2873 {

    public static void main(String[] args) {

    }

    //Brute force Time O(n^3) and Space O(1)
    public static long maxTripletValue(final int[] nums) {
        long ans = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i + 1; j < nums.length - 1; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    if(nums[i] - nums[j] <= 0) {
                        continue;
                    }
                    ans = Math.max(ans, (nums[i] - nums[j])*nums[k]*1l);
                }
            }
        }
        return ans;
    }

    //Greedy Time O(n^2) and Space O(1)
    public static long maxTripletValueGreedy(final int[] nums) {
        long ans = 0;
        for(int k = 2; k < nums.length; k++) {
            int maxFirst = nums[0];
            for(int j = 1; j < k; j++) {
                ans = Math.max(ans, (long)(maxFirst - nums[j])*nums[k]);
                maxFirst = Math.max(maxFirst, nums[j]);
            }
        }
        return ans;
    }

    //greedy and prefix. Time O(n) and Space O(n)
    public static long maxTripletValueLinearGreedyPrefix(final int[] nums) {
        final int[] leftMax = new int[nums.length];
        final int[] rightMax = new int[nums.length];
        long res = 0;
        for(int i = 1; i < nums.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i - 1]);
            rightMax[nums.length - 1 - i] = Math.max(rightMax[nums.length - i], nums[nums.length - i]);
        }
        for(int j = 1; j < nums.length - 1; j++) {
            res = Math.max(res, (long)(leftMax[j] - nums[j])*rightMax[j]);
        }
        return res;
    }

    //linear greedy Time O(n) and Space O(1)
    public static long maxTripletValueLinearGreedy(final int[] nums) {
        long res = 0;
        int diffMax = 0, leftMax = 0;
        for(int k = 0; k < nums.length; k++) {
            res = Math.max(res, (long)diffMax*nums[k]);
            diffMax = Math.max(diffMax, leftMax - nums[k]);
            leftMax = Math.max(leftMax, nums[k]);
        }
        return res;
    }
}

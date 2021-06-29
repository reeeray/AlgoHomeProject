package leetcode.search;

/**
 * 1004. MaxConsecutiveOnes III
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 * User : Shein G.A.{@reeeray}
 * Date : 29.06.2021
 **/
public class MaxConsecutiveOnes_1004 {

    public static void main(String[] args) {
        final int[] nums = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        final int k = 3;

        System.out.println(longestOnes(nums, k));

    }

    private static int longestOnes(final int[] ones, final int k) {
        int maxOnes = Integer.MIN_VALUE;
        int left = 0, consecutiveOnes = 0;

        for (int right = 0; right < ones.length; right++) {
            if (ones[right] == 0) {
                consecutiveOnes++;
            }

            while (k < consecutiveOnes) {
                if (ones[left] == 0) {
                    consecutiveOnes--;
                }
                left++;
            }

            maxOnes = Math.max(maxOnes, right - left + 1);
        }
        return maxOnes;
    }
}

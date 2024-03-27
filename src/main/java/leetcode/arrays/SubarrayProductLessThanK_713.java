package leetcode.arrays;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 27.03.2024
 **/
public class SubarrayProductLessThanK_713 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(1)
    public static int numSubarrayProductLessThanK(final int[] nums, final int K) {
        int answ = 0;
        int prod = 1;
        for(int left=0, right=0; right<nums.length; right++) {
            prod *= nums[right];

            while (prod >= K) {
                prod /= nums[left++];
            }

            answ += right - left + 1;
        }
        return answ;
    }
}

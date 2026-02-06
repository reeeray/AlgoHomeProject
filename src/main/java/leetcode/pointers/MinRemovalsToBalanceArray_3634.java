package leetcode.pointers;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 06.02.2026
 **/
public class MinRemovalsToBalanceArray_3634 {

    public static void main(String[] args) {

    }

    //Time O(nlogn) and Space O(n) due to sorting
    public static int minRemoval(final int[] nums, final int k) {
        Arrays.sort(nums);
        int res = nums.length;
        int right = 0;
        for(int left = 0; left < nums.length; left++) {
            while (right < nums.length && nums[right] <= (long)k * nums[left]) {
                right++;
            }
            res = Math.min(res, nums.length - (right - left));
        }
        return res;
    }
}

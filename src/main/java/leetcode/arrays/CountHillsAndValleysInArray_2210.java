package leetcode.arrays;

import patterns.creational.factory.Page;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 27.07.2025
 **/
public class CountHillsAndValleysInArray_2210 {

    public static void main(String[] args) {

    }

    public static int countHillValue(final int[] nums) {
        int left = 0;
        int right = 2;
        int index = 1;
        int res = 0;
        while (right < nums.length) {
            if((nums[index] < nums[left] && nums[index] < nums[right]) ||
                    (nums[index] > nums[left] && nums[index] > nums[right])) {
                res++;
                left = right - 1;
                index = right;
                right++;
            } else if(nums[index] == nums[right]) {
                right++;
            } else {
                left = right - 1;
                index = right;
                right++;
            }
        }
        return res;
    }
}

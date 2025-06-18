package leetcode.arrays;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 18.06.2025
 **/
public class DivideArrayIntoArraysWithMaxDifference_2966 {

    public static void main(String[] args) {

    }

    //Space O(n or log n) and Time O(nlogn)
    public static int[][] divideArray(final int[] nums, final int k) {
        Arrays.sort(nums);
        final int[][] res = new int[nums.length / 3][3];
        for(int i = 2; i < nums.length; i += 3) {
            if(nums[i] - nums[i - 2] > k) {
                return new int[0][];
            }
            res[i / 3] = new int[]{nums[i - 2], nums[i - 1], nums[i]};

        }
        return res;
    }
}

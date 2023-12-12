package leetcode.arrays;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 12.12.2023
 **/
public class MaxProductOf2Elements_1464 {

    public static void main(String[] args) {

    }

    //Time : O(n*log(n)) because if Quick sort implementation in Java and Space complexity for Quick sort is O(log(n))
    public static int maxProduct(final int[] nums) {
        Arrays.sort(nums);
        final int n = nums.length;
        return (nums[n - 1] - 1) * (nums[n - 2] - 1);
    }

    //Time O(n) and Space O(1)
    public static int maxProductEff(final int[] nums) {
        int x = Integer.MIN_VALUE, y = Integer.MIN_VALUE;
        for(int i=0; i < nums.length; i++) {
            if(nums[i] > x) {
                y = x;
                x = nums[i];
            } else {
                y = nums[i] > y ? nums[i] : y;
            }
        }
        return (x - 1) * (y - 1);
    }
}

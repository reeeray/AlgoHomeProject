package leetcode.arrays;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 12.02.2024
 **/
public class MajorityElement_169 {

    public static void main(String[] args) {

    }

    public static int majorityElement(final int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    //Time O(n) and Space O(1)
    public static int majorityElementSpaceOptimized(final int[] nums) {
        int res = 0;
        int majority = 0;
        for(int n : nums) {
            if(majority == 0) {
                res = n;
            }
            majority += res == n ? 1 : -1;
        }
        return res;
    }
}

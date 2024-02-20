package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 20.02.2024
 **/
public class MissingNumber_268 {

    public static void main(String[] args) {

    }

    //Space O(1) and Time O(n)
    public static int missingNumber(final int[] nums ) {
        int actual = 0;
        int expected = 0;
        for(int i=0; i<nums.length; i++) {
            actual += nums[i];
            expected += i + 1;
        }

        return expected - actual;
    }

    public static int missingNumberSpaceOptimized(final int[] nums) {
        final int expected = nums.length * (nums.length-1) / 2;
        int actual = 0;
        for(int num : nums) {
            actual += num;
        }
        return expected - actual;
    }
}

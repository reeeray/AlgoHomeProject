package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 29.09.2023
 **/
public class IsArrayMonotonic_896 {


    public static boolean isMonotonic(final int[] nums) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                decreasing = false;
            } else if (nums[i] < nums[i - 1]) {
                increasing = false;
            }

            if (!increasing && !decreasing) {
                return false;
            }
        }

        return true;
    }
}

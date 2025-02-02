package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 02.02.2025
 **/
public class CheckIfArrayIsSortedAndRotated_1752 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(1)
    public static boolean isSortedAndRotated(final int[] nums) {
        int rotationIndex = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] >= nums[i - 1]) {
                continue;
            } else {
                rotationIndex++;
                if(rotationIndex > 1) {
                    return false;
                }
            }
        }
        return rotationIndex == 0 || nums[nums.length - 1] <= nums[0];
    }
}

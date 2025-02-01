package leetcode.binaryStuff;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 01.02.2025
 **/
public class SpecialArray1_3151 {

    public static void main(String[] args) {
        isArraySpecial(new int[] {4, 3, 1, 4});
    }

    public static boolean isArraySpecial(final int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            if(((nums[i - 1] & 1) ^ (nums[i] & 1)) == 0)  {
                return false;
            }
        }
        return true;
    }
    //Time O(n) and Space O(1)
    public static boolean isArraySpecialNonOptimized(final int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] % 2 == nums[i] % 2) {
                return false;
            }
        }
        return true;
    }
}

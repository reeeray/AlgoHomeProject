package leetcode.pointers;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 28.10.2025
 **/
public class MakeArrayElementsEqualToZero_3354 {

    public static void main(String[] args) {

    }
    //prefix Time O(2n) and Space O(1)
    public static int countValidSelections(final int[] nums) {
        int leftSum = 0, rightSum = 0, res = 0;
        for(final int num : nums) {
            rightSum += num;
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                final int diff = Math.abs(leftSum - rightSum);
                if(diff == 0) {
                    res +=2;
                }
                if(diff == 1) {
                    res++;
                }
            } else {
                leftSum += nums[i];
                rightSum -= nums[i];
            }
        }
        return res;
    }
}

package leetcode.bruteforce;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 30.09.2025
 **/
public class FindTriangularSumOfAnArray_2221 {

    public static void main(String[] args) {

    }

    //Time O(n^2) and Space O(1)
    public static int triangularSum(final int[] nums) {
        for(int i = nums.length - 1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                nums[j] = (nums[j] + nums[j + 1]) % 10;
            }
        }
        return nums[0];
    }
}

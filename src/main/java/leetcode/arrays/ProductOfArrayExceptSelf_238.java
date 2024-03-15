package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 15.03.2024
 **/
public class ProductOfArrayExceptSelf_238 {

    public int[] productExceptSelf(int[] nums) {
        final int n = nums.length;
        final int[] ans = new int[n];
        final int[] left = new int[n];
        final int[] right = new int[n];

        left[0] = 1;
        right[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            ans[i] = left[i] * right[i];
        }

        return ans;
    }

}

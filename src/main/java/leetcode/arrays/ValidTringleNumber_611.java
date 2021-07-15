package leetcode.arrays;

import java.util.Arrays;

/**
 * 611. Valid Triangle Number.
 * <p>
 * Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
 * <p>
 * User : Shein G.A.{@reeeray}
 * Date : 15.07.2021
 **/
public class ValidTringleNumber_611 {

    public static void main(String[] args) {
        final int actual = triangleNumber(new int[]{4, 2, 3, 4});
        assert actual == 4;
    }

    public static int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                k = binarySearch(nums, k, nums.length - 1, nums[i] + nums[j]);
                count += k - j - 1;
            }
        }
        return count;
    }

    private static int binarySearch(int nums[], int l, int r, int x) {
        while (r >= l && r < nums.length) {
            int mid = (l + r) / 2;
            if (nums[mid] >= x)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }
}

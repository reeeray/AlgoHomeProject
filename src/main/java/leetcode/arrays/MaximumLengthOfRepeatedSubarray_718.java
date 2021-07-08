package leetcode.arrays;

/**
 * 718. Maximum Length of Repeated Subarray
 * <p>
 * Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.
 * <p>
 * User : Shein G.A.{@reeeray}
 * Date : 08.07.2021
 **/
public class MaximumLengthOfRepeatedSubarray_718 {

    public static void main(String[] args) {
        System.out.println(findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }

    private static int findLength(final int[] nums1, final int[] nums2) {
        int asnw = 0;
        final int[][] cache = new int[nums1.length + 1][nums2.length + 1];

        for (int i = nums1.length - 1; i >= 0; i--) {
            for (int j = nums2.length - 1; j >= 0; j--) {
                if (nums1[i] == nums2[j]) {
                    cache[i][j] = cache[i + 1][j + 1] + 1;
                    if (asnw < cache[i][j]) asnw = cache[i][j];
                }
            }
        }
        return asnw;
    }
}

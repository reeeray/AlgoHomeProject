package leetcode.arrays;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 20.02.2022
 **/
public class MergeSortedArray_88 {

    public static void main(String[] args) {
        final int[] nums1 = {1, 2, 3, 0, 0, 0};
        final int[] nums2 = {2, 4, 5};

        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    public static void mergeImroved(final int[] nums1, final int m, final int[] nums2, final int n) {
        int i = m - 1;
        int j = n - 1;
        for (int k = (i + j + 1); k >= 0; --k) {
            if (i < 0) {
                nums1[k] = nums2[j];
                j--;
            } else if (j < 0) {
                nums1[k] = nums1[i];
                i--;
            } else if (nums1[i] < nums2[j]) {
                nums1[k] = nums2[j];
                j--;
            } else {
                nums1[k] = nums1[i];
                i--;
            }
        }
    }


    public static void merge(final int[] nums1, final int m, final int[] nums2, final int n) {
        if (n == 0)
            return;

        int indexN = 0;

        for (int i = 0; i < nums1.length; i++) {
            final int val1 = nums1[i];
            final int val2 = nums2[indexN];
            if (i == m) {
                for (int j = i; j < nums1.length; j++) {
                    nums1[j] = nums2[indexN++];
                }
                return;
            }
            if (val2 < val1) {
                final int val = nums1[i];
                nums1[i] = nums2[indexN];
                nums2[indexN] = val;
                Arrays.sort(nums2);
            }
        }
    }
}

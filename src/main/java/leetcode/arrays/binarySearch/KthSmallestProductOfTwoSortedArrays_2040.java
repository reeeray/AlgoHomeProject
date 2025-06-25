package leetcode.arrays.binarySearch;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 25.06.2025
 **/
public class KthSmallestProductOfTwoSortedArrays_2040 {

    public static void main(String[] args) {

    }

    //Time O(n1 * logn2 * logC) and Space O(1) where C - 2 * 10^10 + 1 problem constaint
    public static long kthSmallestProduct(final int[] nums1, final int[] nums2, final long k) {
        //due to constaints
        long left = -10000000000L, right = 10000000000L;
        while(left <= right) {
            final long mid = (left + right) / 2;
            long countNumberOfElementsForSelectedProduct = 0;
            for(int i = 0; i < nums1.length; i++) {
                countNumberOfElementsForSelectedProduct += countSmallest(nums2, nums1[i], mid);
            }
            if(countNumberOfElementsForSelectedProduct < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private static long countSmallest(final int[] nums, final int element, final long product) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            final int mid = (left + right) / 2;
            final long currProduct = (long)nums[mid] * element;
            if((element >= 0 && currProduct <= product) || (element < 0 && currProduct > product)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if(element >= 0) {
            return left;
        } else {
            return nums.length - left;
        }
    }
}

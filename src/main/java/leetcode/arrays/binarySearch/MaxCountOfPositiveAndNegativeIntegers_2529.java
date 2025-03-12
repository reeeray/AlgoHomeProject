package leetcode.arrays.binarySearch;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 12.03.2025
 **/
public class MaxCountOfPositiveAndNegativeIntegers_2529 {

    public static void main(String[] args) {

    }

    public static int maximumCount(final int[] nums) {
        final int positiveCount = nums.length - binarySearchPositive(nums);
        final int negativeCount = binarySearchNegative(nums);
        return Math.max(positiveCount, negativeCount);
    }
    private static int binarySearchNegative(final int[] nums) {
        int left = 0, right = nums.length - 1, index = nums.length;
        while (left <= right) {
            final int mid = (left + right) / 2;
            if(nums[mid] < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
                index = mid;
            }
        }
        return index;
    }
    private static int binarySearchPositive(final int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length;
        while (left <= right) {
            final int mid = (left + right) / 2;
            if(nums[mid] <= 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
                index = mid;
            }
        }
        return index;
    }


}

package leetcode.binaryStuff;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 15.05.2026
 **/
public class FindMinimumInRotatedSortedArray_153 {

    public static void main(String[] args) {

    }

    private static int findMin(final int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            final int mid = (left + right) / 2;
            if(nums[right] > nums[mid]) {
                    right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}

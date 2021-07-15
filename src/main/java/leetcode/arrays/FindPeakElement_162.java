package leetcode.arrays;

/**
 * 162. Find Peak Element.
 * <p>
 * A peak element is an element that is strictly greater than its neighbors.
 * <p>
 * Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
 * <p>
 * You may imagine that nums[-1] = nums[n] = -∞.
 * <p>
 * You must write an algorithm that runs in O(log n) time.
 * User : Shein G.A.{@reeeray}
 * Date : 15.07.2021
 **/
public class FindPeakElement_162 {

    public static void main(String[] args) {
        final int peak = findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4});

        System.out.println(peak);
        assert peak == 5;
    }

    private static int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}

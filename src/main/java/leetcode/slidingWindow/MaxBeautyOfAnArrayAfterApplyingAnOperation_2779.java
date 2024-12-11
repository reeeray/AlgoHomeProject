package leetcode.slidingWindow;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 11.12.2024
 **/
public class MaxBeautyOfAnArrayAfterApplyingAnOperation_2779 {

    public static void main(String[] args) {

    }

    //Time O(nlogn) and Space O(logn)
    public int maximumBeautyBinarySearch(int[] nums, int k) {
        Arrays.sort(nums);
        int maxBeauty = 0;

        for (int i = 0; i < nums.length; i++) {
            // Find the farthest index where the value is within the range [nums[i], nums[i] + 2*k]
            int upperBound = findUpperBound(nums, nums[i] + 2 * k);
            // Update the maximum beauty based on the current range
            maxBeauty = Math.max(maxBeauty, upperBound - i + 1);
        }
        return maxBeauty;
    }

    // Helper function to find the largest index where arr[index] <= val
    private int findUpperBound(int[] arr, int val) {
        int low = 0, high = arr.length - 1, result = 0;

        // Perform binary search to find the upper bound
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= val) {
                result = mid; // Update the result and move to the right half
                low = mid + 1;
            } else {
                high = mid - 1; // Move to the left half
            }
        }
        return result;
    }

    //Time O(nlogn) and Space O(logn) because of sort implementation in java
    public int maximumBeautySlidingWindow(int[] nums, int k) {
        Arrays.sort(nums);
        int right = 0; // Pointer for the end of the valid range
        int maxBeauty = 0;

        // Iterate through the array with the left pointer
        for (int left = 0; left < nums.length; left++) {
            // Expand the right pointer while the range condition is met
            while (right < nums.length && nums[right] - nums[left] <= 2 * k) {
                right++;
            }
            // Update the maximum beauty based on the current range
            // We do not add 1 here as right is already pointing to one position beyond the valid range.
            maxBeauty = Math.max(maxBeauty, right - left);
        }
        return maxBeauty;
    }

    //Time O(n + maxValue) and Space O(maxValue)
    public int maximumBeautyLineSweep(int[] nums, int k) {
        // If there's only one element, the maximum beauty is 1
        if (nums.length == 1) return 1;

        int maxBeauty = 0;
        int maxValue = 0;

        // Find the maximum value in the array
        for (int num : nums) maxValue = Math.max(maxValue, num);

        // Create an array to keep track of the count changes
        int[] count = new int[maxValue + 1];

        // Update the count array for each value's range [val - k, val + k]
        for (int num : nums) {
            count[Math.max(num - k, 0)]++; // Increment at the start of the range
            count[Math.min(num + k + 1, maxValue)]--; // Decrement after the range
        }

        int currentSum = 0; // Tracks the running sum of counts
        // Calculate the prefix sum and find the maximum value
        for (int val : count) {
            currentSum += val;
            maxBeauty = Math.max(maxBeauty, currentSum);
        }

        return maxBeauty;
    }
}

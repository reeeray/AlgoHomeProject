package leetcode.arrays.binarySearch;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 18.03.2025
 **/
public class LongestNiceSubarray_2401 {

    public static void main(String[] args) {

    }

    //Time O(n^2logn) and Space O(1)
    public static int longestNiceSubarray(final int[] nums) {
        // Binary search for the longest nice subarray length
        int left = 0, right = nums.length;
        int result = 1; // Minimum answer is 1 (as subarrays of length 1 are always nice)

        while (left <= right) {
            int length = (left + right) / 2;
            if (canFormNiceSubarray(length, nums)) {
                result = length; // Update the result
                left = length + 1; // Try to find a longer subarray
            } else {
                right = length - 1; // Try a shorter length
            }
        }
        return result;
    }

    private static boolean canFormNiceSubarray(final int length, final int[] nums) {
        if (length <= 1) return true; // Subarray of length 1 is always nice

        // Try each possible starting position for subarray of given length
        for (int start = 0; start <= nums.length - length; ++start) {
            int bitMask = 0; // Tracks the bits used in the current subarray
            boolean isNice = true;

            // Check if the subarray starting at 'start' with 'length' elements is nice
            for (int pos = start; pos < start + length; ++pos) {
                // If current number shares any bits with existing mask,
                // the subarray is not nice
                if ((bitMask & nums[pos]) != 0) {
                    isNice = false;
                    break;
                }
                bitMask |= nums[pos]; // Add current number's bits to the mask
            }

            if (isNice) return true; // Found a nice subarray of the specified length
        }
        return false; // No nice subarray of the given length exists
    }

    public static int longestSubarray(final int length, final int[] nums) {
        int usedBits = 0, left = 0, maxLnegth = 0;
        // Tracks bits used in current window
        // Start position of current window
        // Length of longest nice subarray found
        for(int right = 0; right < nums.length; right++) {
            // If current number shares bits with window, shrink window from left
            // until there's no bit conflict
            while ((usedBits & nums[right]) != 0) {
                usedBits ^= nums[left++];// Remove leftmost element's bits
            }
            // Add current number to the window
            usedBits |= nums[right];
            // Update max length if current window is longer
            maxLnegth = Math.max(maxLnegth, right - left + 1);
        }
        return maxLnegth;
    }
}

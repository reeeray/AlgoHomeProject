package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 03.02.2025
 **/
public class LongestStrictlyIncreasingOrStrictlyDecreasingArray_3105 {

    public static void main(String[] args) {
        final int[] input = new int[] {1, 9, 7, 1};
        longestMonotonicSubarray(input);
    }

    //Time O(n) single iteration, Space O(1)
    public static int longestMonotonicSubarray(final int[] nums) {
        int dir = 0;
        int max = 0;
        int counter = 1;
        for(int i = 1; i < nums.length; i++) {
            if(dir == 1 && nums[i] > nums[i - 1]) {
                counter++;
            } else if (dir == -1 && nums[i] < nums[i - 1]) {
                counter++;
            } else {
                max = Math.max(max, counter);
                if(nums[i] > nums[i - 1]) {
                    dir = 1;
                    counter = 2;
                } else if (nums[i] < nums[i - 1]) {
                    dir = -1;
                    counter = 2;
                } else {
                    dir = 0;
                    counter = 1;
                }
            }
        }
        return Math.max(max, counter);
    }

    public int longestMonotonicSubarrayAlternative(final int[] nums) {
        // Track current lengths of increasing and decreasing sequences
        int incLength = 1, decLength = 1;
        int maxLength = 1;

        // Iterate through array comparing adjacent elements
        for (int pos = 0; pos < nums.length - 1; pos++) {
            if (nums[pos + 1] > nums[pos]) {
                // If next element is larger, extend increasing sequence
                incLength++;
                decLength = 1; // Reset decreasing sequence
            } else if (nums[pos + 1] < nums[pos]) {
                // If next element is smaller, extend decreasing sequence
                decLength++;
                incLength = 1; // Reset increasing sequence
            } else {
                // If elements are equal, reset both sequences
                incLength = 1;
                decLength = 1;
            }

            // Update max length considering both sequences
            maxLength = Math.max(maxLength, Math.max(incLength, decLength));
        }
        return maxLength;
    }
}

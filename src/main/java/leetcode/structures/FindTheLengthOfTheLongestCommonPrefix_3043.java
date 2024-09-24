package leetcode.structures;

import java.util.HashSet;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 24.09.2024
 **/
public class FindTheLengthOfTheLongestCommonPrefix_3043 {

    public static void main(String[] args) {

    }

    //Time O(m*log10m + nlog10n) and Space O(mlog10m)
    public int longestCommonPrefix(final int[] arr1, final int[] arr2) {
        final HashSet<Integer> arr1Prefixes = new HashSet<Integer>(); // Set to store all prefixes from arr1

        // Step 1: Build all possible prefixes from arr1
        for (int val : arr1) {
            while (!arr1Prefixes.contains(val) && val > 0) {
                // Insert current value as a prefix
                arr1Prefixes.add(val);
                // Generate the next shorter prefix by removing the last digit
                val /= 10;
            }
        }

        int longestPrefix = 0;

        // Step 2: Check each number in arr2 for the longest matching prefix
        for (int val : arr2) {
            while (!arr1Prefixes.contains(val) && val > 0) {
                // Reduce val by removing the last digit if not found in the prefix set
                val /= 10;
            }
            if (val > 0) {
                // Length of the matched prefix using log10 to determine the number of digits
                longestPrefix = Math.max(longestPrefix, (int) Math.log10(val) + 1
                );
            }
        }

        return longestPrefix;
    }
}

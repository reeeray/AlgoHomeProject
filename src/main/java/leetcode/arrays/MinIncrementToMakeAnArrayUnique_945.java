package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 14.06.2024
 **/
public class MinIncrementToMakeAnArrayUnique_945 {

    public static void main(String[] args) {

    }

    //Space O(n) and Time O(n)
    public static int minIncrementForUnique(final int[] nums) {
        int max = 0;
        for(final int num : nums) {
            max = max > num ? max : num;
        }
        final boolean[] freq = new boolean[max + nums.length];
        int count = 0;
        for(final int num : nums) {
            int val = num;
            while (freq[val] != false) {
                val++;
                count++;
            }
            freq[val] = true;
        }
        return count;

    }

    //Space O(n + max) and Time(n + max)
    public static int minIncrementForUniqueOpt(final int[] nums) {
        int n = nums.length;
        int max = 0;
        int minIncrements = 0;

        // Find maximum value in array to determine range of frequencyCount array
        for (int val : nums) {
            max = Math.max(max, val);
        }

        // Create a frequencyCount array to store the frequency of each value in nums
        int[] frequencyCount = new int[n + max];

        // Populate frequencyCount array with the frequency of each value in nums
        for (int val : nums) {
            frequencyCount[val]++;
        }

        // Iterate over the frequencyCount array to make all values unique
        for (int i = 0; i < frequencyCount.length; i++) {
            if (frequencyCount[i] <= 1) continue;

            // Determine excess occurrences, carry them over to the next value,
            // ensure single occurrence for current value, and update minIncrements.
            int duplicates = frequencyCount[i] - 1;
            frequencyCount[i + 1] += duplicates;
            frequencyCount[i] = 1;
            minIncrements += duplicates;
        }

        return minIncrements;
    }
}

package leetcode.arrays.binarySearch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 17.03.2025
 **/
public class DivideArrayIntoEqualPairs_2206 {

    public static void main(String[] args) {
        final int[] input = new int[] {1,2,3,4};
        divideArray(input);
    }

    public static boolean divideArray(final int[] nums) {
        final Map<Integer, Integer> frequency = new HashMap<>();
        for(final int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        for(final int val : frequency.values()) {
            if(val % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    //Time O(n) and Space O(maxNum)
    public boolean divideArrayArray(int[] nums) {
        // Find maximum value in array
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(num, maxNum);
        }

        // Toggle pair status for each number
        boolean[] needsPair = new boolean[maxNum + 1];
        for (int num : nums) {
            needsPair[num] = !needsPair[num];
        }

        // Check if any number remains unpaired
        for (int num : nums) {
            if (needsPair[num]) {
                return false;
            }
        }

        return true;
    }

    public boolean divideArrayHashSet(int[] nums) {
        // Track unpaired numbers
        final Set<Integer> unpaired = new HashSet<>();

        // Add numbers to set if unseen, remove if seen
        for (int num : nums) {
            if (unpaired.contains(num)) {
                unpaired.remove(num);
            } else {
                unpaired.add(num);
            }
        }

        // Return true if all numbers were paired
        return unpaired.isEmpty();
    }
}

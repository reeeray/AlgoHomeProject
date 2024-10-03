package leetcode.arrays;

import leetcode.structures.HashMapImpl_706;

import java.util.HashMap;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 03.10.2024
 **/
public class MakeSumDevisibleByP_1590 {

    public static void main(String[] args) {

    }

    //Time O(2n) and Space O(n)
    public static int minSubarray(final int[] nums, final int p) {
        int totalSum = 0;
        // Step 1: Calculate total sum and target remainder
        for(final int num : nums) {
            totalSum = (totalSum + num) % p;
        }
        final int targetReminder = totalSum  % p;
        if (targetReminder == 0) {
            return 0; // The array is already divisible by p
        }
        // Step 2: Use a hash map to track prefix sum mod p
        final Map<Integer, Integer> reminderIndexes = new HashMap<>();
        int minLen = nums.length;
        int reminderOfCurrentSum = 0;
        // Step 3: Iterate over the array
        for(int i=0; i<nums.length; i++) {
            reminderOfCurrentSum = (reminderOfCurrentSum + nums[i]) % p;
            // Calculate what we need to remove
            final int needToRemove = (reminderOfCurrentSum - targetReminder + p) % p;
            // If we have seen the needed remainder, we can consider this subarray
            if(reminderIndexes.containsKey(needToRemove)) {
                minLen = Math.min(minLen, i - reminderIndexes.get(needToRemove));
            }
            // Store the current remainder and index
            reminderIndexes.put(reminderOfCurrentSum, i);
        }
        // Step 4: Return result
        return minLen == nums.length ? - 1 : minLen;
    }
}

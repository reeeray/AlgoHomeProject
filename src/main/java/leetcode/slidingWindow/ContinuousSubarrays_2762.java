package leetcode.slidingWindow;

import java.util.TreeMap;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 14.12.2024
 **/
public class ContinuousSubarrays_2762 {

    public static void main(String[] args) {
        System.out.println(continuousSubarrays(new int[]{5, 4, 2, 4}));
    }

    //TLE
    public static long continuousSubarrays(final int[] nums) {
        long ans = 0;
        for(int i=0; i<nums.length; i++) {
            int min = nums[i];
            int max = nums[i];
            for(int j=i; j<nums.length; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                if(max - min >= 0 && max - min <= 2) {
                    ans++;
                } else {
                    break;
                }
            }
        }
        return ans;
    }

    //Two pointers Time O(n) and Space O(1)
    public long continuousSubarraysTwoPointers(int[] nums) {
        int right = 0, left = 0;
        int curMin, curMax;
        long windowLen = 0, total = 0;

        // Initialize window with first element
        curMin = curMax = nums[right];

        for (right = 0; right < nums.length; right++) {
            // Update min and max for current window
            curMin = Math.min(curMin, nums[right]);
            curMax = Math.max(curMax, nums[right]);

            // If window condition breaks (diff > 2)
            if (curMax - curMin > 2) {
                // Add subarrays from previous valid window
                windowLen = right - left;
                total += ((windowLen * (windowLen + 1)) / 2);

                // Start new window at current position
                left = right;
                curMin = curMax = nums[right];

                // Expand left boundary while maintaining condition
                while (
                        left > 0 && Math.abs(nums[right] - nums[left - 1]) <= 2
                ) {
                    left--;
                    curMin = Math.min(curMin, nums[left]);
                    curMax = Math.max(curMax, nums[left]);
                }

                // Remove overcounted subarrays if left boundary expanded
                if (left < right) {
                    windowLen = right - left;
                    total -= ((windowLen * (windowLen + 1)) / 2);
                }
            }
        }

        // Add subarrays from final window
        windowLen = right - left;
        total += ((windowLen * (windowLen + 1)) / 2);

        return total;
    }

    //TreeMap O(nlogk=3) and Space O(k=3)
    public long continuousSubarraysTreeMap(int[] nums) {
        // TreeMap to maintain sorted frequency map of current window
        final TreeMap<Integer, Integer> freq = new TreeMap<>();
        int left = 0, right = 0;
        int n = nums.length;
        long count = 0; // Total count of valid subarrays

        while (right < n) {
            // Add current element to frequency map
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            // While window violates the condition |nums[i] - nums[j]| ≤ 2
            // Shrink window from left
            while (freq.lastEntry().getKey() - freq.firstEntry().getKey() > 2) {
                // Remove leftmost element from frequency map
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0) {
                    freq.remove(nums[left]);
                }
                left++;
            }

            // Add count of all valid subarrays ending at right
            count += right - left + 1;
            right++;
        }

        return count;
    }
}

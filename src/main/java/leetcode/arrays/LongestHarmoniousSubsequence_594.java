package leetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 30.06.2025
 **/
public class LongestHarmoniousSubsequence_594 {

    public static void main(String[] args) {
        findLHS(new int[] {1,3,2,2,5,2,3,7});
    }

    //Time O(2n)) and Space O(n)
    public static int findLHS(final int[] nums) {
        final Map<Integer, Integer> frequency = new HashMap<>();
        for(final int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        for(final Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if(frequency.get(entry.getKey() + 1) != null) {
                max = Math.max(max, entry.getValue() + frequency.get(entry.getKey() + 1));
            }
        }
        return max;
    }

    //due to sorting Time O(nlogn) and Space O(1)
    public static int findLHSSpaceOptimized(int[] nums) {
        Arrays.sort(nums);
        int j = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] - nums[j] > 1) {
                j++;
            }
            if (nums[i] - nums[j] == 1) {
                maxLength = Math.max(maxLength, i - j + 1);
            }
        }
        return maxLength;
    }
}

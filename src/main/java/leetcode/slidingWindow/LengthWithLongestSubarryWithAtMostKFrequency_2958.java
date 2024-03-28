package leetcode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 28.03.2024
 **/
public class LengthWithLongestSubarryWithAtMostKFrequency_2958 {

    public static void main(String[] args) {
        final int[] input = new int[]{1, 2, 3, 1, 2, 3, 3, 1, 2};
        maxSubarrayLength(input, 2);

    }

    //Time O(n) and Space O(n)
    public static int maxSubarrayLength(final int[] nums, final int k) {
        final Map<Integer, Integer> freq = new HashMap<>();
        int ans = 0;
        for(int left = 0, right = 0; right < nums.length; right++) {
            int f = freq.getOrDefault(nums[right], 0) + 1;
            freq.put(nums[right], f);
            while (f > k) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if(nums[left++] == nums[right]) {
                    f--;
                }
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}

package leetcode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 19.11.2024
 **/
public class MaxSumOfDistinctSubarraysWithLengthK_2461 {

    public static void main(String[] args) {
        final int[] input = new int[] {1, 5, 4, 2, 9, 9, 9};
        maximumSubarraySum(input, 3);
    }

    //Space O(n) and Time(n)
    public static long maximumSubarraySumOpt(final int[] nums, final int k) {
        long ans = 0;
        long sum = 0;
        int left = 0, right = 0;
        final Map<Integer, Integer> valueIndexMap = new HashMap<>();

        while (right < nums.length) {
            final int val = nums[right];
            final int occured = valueIndexMap.getOrDefault(val, - 1);

            while (left <= occured || right - left + 1 > k) {
                sum -= nums[left++];
            }
            valueIndexMap.put(val, right);
            sum += nums[right];
            if(right - left + 1 == k) {
                ans = Math.max(ans, sum);
            }
            right++;
        }
        return ans;
    }


    //TLE
    public static long maximumSubarraySum(final int[] nums, final int k) {
       final Map<Integer, Integer> freqMap = new HashMap<>();
       long sum = 0l;
       long ans = -1;
       for(int i=0; i<k; i++) {
           freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
           sum += nums[i];
       }
       for(int i=0; i < nums.length - k; i++) {
           if(freqMap.values().stream().noneMatch(v -> v > 1)) {
               ans = Math.max(ans, sum);
           }
           sum -= nums[i];
           freqMap.put(nums[i], freqMap.get(nums[i]) - 1);
           sum += nums[i + k];
           freqMap.put(nums[i + k], freqMap.getOrDefault(nums[i + k], 0) + 1);
       }
        if(freqMap.values().stream().noneMatch(v -> v > 1)) {
            ans = Math.max(ans, sum);
        }
       return ans;
    }
}

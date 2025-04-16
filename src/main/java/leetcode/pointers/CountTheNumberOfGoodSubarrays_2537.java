package leetcode.pointers;

import java.util.HashMap;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 16.04.2025
 **/
public class CountTheNumberOfGoodSubarrays_2537 {

    public static void main(String[] args) {

    }

    //Time O(2n) and Space O(n)
    public static long countGood(final int[] nums, final int k) {
        final int n = nums.length;
        long ans = 0;
        final Map<Integer, Integer> digitCounter = new HashMap<>();
        int pairsCounter = 0, right = -1;
        for(int left = 0; left < n; left ++) {
            while (pairsCounter < k && right + 1 < n) {
                right++;
                pairsCounter += digitCounter.getOrDefault(nums[right], 0);
                digitCounter.put(nums[right], digitCounter.getOrDefault(nums[right], 0) + 1);
            }
            if(pairsCounter >= k) {
                ans += n - right;
            }
            digitCounter.put(nums[left], digitCounter.get(nums[left]) - 1);
            pairsCounter -= digitCounter.get(nums[left]);
        }
        return ans;
    }
}

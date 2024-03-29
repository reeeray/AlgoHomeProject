package leetcode.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 29.03.2024
 **/
public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes_2962 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(1)
    public static long countSubarrays(int[] nums, int k) {
        final int maxElement = Arrays.stream(nums).max().getAsInt();
        long ans = 0;

        for (int start = 0, maxElementsInWindow = 0, end = 0; end < nums.length; end++) {
            if (nums[end] == maxElement) {
                maxElementsInWindow++;
            }
            while (k == maxElementsInWindow) {
                if (nums[start++] == maxElement) {
                    maxElementsInWindow--;
                }
            }
            ans += start;
        }

        return ans;
    }

    //Time O(n) and Space O(n)
    public long countSubarraysAlternative(int[] nums, int k) {
        final int maxElement = Arrays.stream(nums).max().getAsInt();
        final List<Integer> indexesOfMaxElements = new ArrayList<>();
        long ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == maxElement) {
                indexesOfMaxElements.add(i);
            }

            int freq = indexesOfMaxElements.size();
            if (freq >= k) {
                ans += indexesOfMaxElements.get(freq - k) + 1;
            }
        }

        return ans;
    }
}

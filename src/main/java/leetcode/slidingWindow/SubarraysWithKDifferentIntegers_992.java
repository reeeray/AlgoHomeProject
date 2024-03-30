package leetcode.slidingWindow;

import leetcode.structures.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 30.03.2024
 **/
public class SubarraysWithKDifferentIntegers_992 {

    public static void main(String[] args) {
        final int[] input = new int[] {1, 2, 1, 2, 3};
        subarraysWithKDistinct(input, 2);

    }

    //doesn't work on corenr case
//    public static int subArraysWithKDistinct(final int[] nums, final int k) {
//        final Map<Integer, Integer> counter = new HashMap<>();
//        int numberOfDistinct = 0;
//        int ans = 0;
//        for(int left = 0, right = 0; right <nums.length; right++) {
//            if(counter.get(nums[right]) == null) {
//                numberOfDistinct++;
//            }
//            counter.put(nums[right], counter.getOrDefault(nums[right], 0) + 1);
//            if(numberOfDistinct < k) {
//                continue;
//            }
//            while (numberOfDistinct > k) {
//                final int c = counter.get(nums[left]) - 1;
//                counter.put(nums[left++], c);
//                if(c == 0) {
//                    numberOfDistinct--;
//                } else {
//                    ans++;
//                }
//            }
//            ans++;
//        }
//        return ans;
//    }


    //Space O(n) and Time(n)
    public static int subarraysWithKDistinct(int[] nums, int k) {
        // Array to store the count of distinct values encountered
        int[] distinctCount = new int[nums.length + 1];

        int totalCount = 0;
        int left = 0;
        int right = 0;
        int currCount = 0;

        while (right < nums.length) {
            // Increment the count of the current element in the window
            if (distinctCount[nums[right++]]++ == 0) {
                // If encountering a new distinct element, decrement K
                k--;
            }

            // If K becomes negative, adjust the window from the left
            if (k < 0) {
                // Move the left pointer until the count of distinct elements becomes valid again
                --distinctCount[nums[left++]];
                k++;
                currCount = 0;
            }

            // If K becomes zero, calculate subarrays
            if (k == 0) {
                // While the count of left remains greater than 1, keep shrinking the window from the left
                while (distinctCount[nums[left]] > 1) {
                    --distinctCount[nums[left++]];
                    currCount++;
                }
                // Add the count of subarrays with K distinct elements to the total count
                totalCount += (currCount + 1);
            }
        }
        return totalCount;
    }
}

package leetcode.binaryStuff;

import java.util.HashMap;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 16.01.2025
 **/
public class BitwiseXOROfAllPairings_2425 {

    public static void main(String[] args) {

    }

    //Time O(n + m) and Space O(1)
    public static int xorAllNums(final int[] nums1, final int[] nums2) {
        int xorNums1 = 0;
        int xorNums2 = 0;
        if(nums2.length % 2 != 0) {
            for (int i = 1; i < nums1.length; i++) {
                xorNums1 ^= nums1[i];
            }
        }
        if(nums2.length % 2 != 0) {
            for (int i = 1; i < nums2.length; i++) {
                xorNums2 ^= nums2[i];
            }
        }
        return xorNums1 ^ xorNums2;
    }

    //Time O(n + m) and Space O(n + m)
    public static int xorAllNumsSpaceNotOptimized(final int[] nums1, final int[] nums2) {
        // Get lengths of arrays
        final int len1 = nums1.length;
        final int len2 = nums2.length;

        // Map to store frequency of each number
        final Map<Integer, Integer> freq = new HashMap<>();

        // Add frequencies for nums1 elements
        // Each element appears n2 times in final result
        for (int num : nums1) {
            freq.put(num, freq.getOrDefault(num, 0) + len2);
        }

        // Add frequencies for nums2 elements
        // Each element appears n1 times in final result
        for (int num : nums2) {
            freq.put(num, freq.getOrDefault(num, 0) + len1);
        }

        // XOR numbers that appear odd number of times
        int ans = 0;
        for (int num : freq.keySet()) {
            if (freq.get(num) % 2 == 1) {
                ans ^= num;
            }
        }

        return ans;
    }
}

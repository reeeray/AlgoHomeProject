package leetcode.arrays.binarySearch;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 13.11.2024
 **/
public class CountTheNumberOfFairPairs_2563 {

    public static void main(String[] args) {
//        final int[] input = new int[] {0, 1, 7, 4, 4, 5};
//        countPairPairs(input, 3, 6);
//        final int[] input = new int[] {1, 7, 9, 2, 5};
//        countPairPairs(input, 11, 11);
        final int[] input = new int[] {6,9,4,2,7,5,10,3};
        countFairPairs(input, 13, 13);
    }

    public static long countFairPairs(final int[] nums, final int lower, final int upper) {
        Arrays.sort(nums);
        long count = 0;
        int prevR = nums.length - 1;
        for(int i=0; i<nums.length; i++) {
            int left = -1;
            for(int j=i + 1; j<nums.length; j++) {
                if(nums[i] + nums[j] >= lower) {
                    left = j;
                    break;
                }
            }
            if(left == -1) {
                continue;
            }
            if(nums[i] + nums[left] > upper) {
                continue;
            }
            for(int k=prevR; k>=left; k--) {
                if(nums[i] + nums[k] <= upper) {
                    prevR = k;
                    break;
                }
            }
            if(nums[i] + nums[prevR] > upper) {
                break;
            }
            count += prevR - left + 1;
        }
        return count;
    }

    //Space O(logn) and Time O(nlogn)
    public long countFairPairsoPT(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return lower_bound(nums, upper + 1) - lower_bound(nums, lower);
    }

    // Calculate the number of pairs with sum less than `value`.
    private long lower_bound(int[] nums, int value) {
        int left = 0, right = nums.length - 1;
        long result = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            // If sum is less than value, add the size of window to result and move to the
            // next index.
            if (sum < value) {
                result += (right - left);
                left++;
            } else {
                // Otherwise, shift the right pointer backwards, until we get a valid window.
                right--;
            }
        }

        return result;
    }
}

package leetcode.slidingWindow;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 14.08.2024
 **/
public class FindKthSmallestPairDistance_719 {

    public static void main(String[] args) {

    }

    //Binary search with sliding window engine. Time O(nlog + nlogM) where M - is maximum distance. Space O(1) constant but it's required for QuickSort implemented in Java O(logn)
    public static int smallestDistancePair(final int[] nums, final int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length - 1] - nums[0];

        while (left <= right) {
            final int mid = (left + right) / 2;
            if(count(nums, mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static int count (final int[] nums, final int dist) {
        int count = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++) {
            while(nums[right] - nums[left] > dist) {
                left++;
            }
            count += right - left;
        }
        return count;
    }
}

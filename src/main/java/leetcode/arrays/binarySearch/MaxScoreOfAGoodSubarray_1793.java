package leetcode.arrays.binarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 22.10.2023
 **/
public class MaxScoreOfAGoodSubarray_1793 {

    public static void main(String[] args) {

    }

    public static int maximumScore(int[] nums, final int k) {
        int ans = solve(nums, k);
        for(int i=0; i<nums.length / 2; i++) {
            final int temp = nums[i];
            final int index = nums.length - 1 - i;
            nums[i] = nums[index];
            nums[index] = temp;
        }
        return Math.max(ans, solve(nums, nums.length - 1 - k));
    }

    private static int solve(final int[] nums, final int k) {
        final int n = nums.length;
        final int[] left = new int[k];
        int currMin = Integer.MAX_VALUE;
        for(int i=k-1; i>=0; i--) {
            currMin = Math.min(currMin, nums[i]);
            left[i] = currMin;
        }

        final List<Integer> right = new ArrayList<>();
        currMin = Integer.MAX_VALUE;
        for(int i=k; i<n; i++) {
            currMin = Math.min(currMin, nums[i]);
            right.add(currMin);
        }

        int ans = 0;
        for(int j=0; j<right.size(); j++) {
            currMin = right.get(j);
            int i = binarySearch(left, currMin);
            final int size = (k + j) - i + 1;
            ans = Math.max(ans, currMin*size);
        }
        return ans;
    }

    private static int binarySearch(final int[] nums, final int target) {
        int left = 0;
        int right = nums.length;
        while(left < right) {
            final int mid = (left + right) / 2;
            if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

package leetcode.pureLogic;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 30.10.2024
 **/
public class MinNumberOfRemovalsToMakeMountainArray_1671 {

    public static void main(String[] args) {

    }

    //Time O(n*n) and Space O(n)
    public static int minimumMountainRemovals(final int[] nums) {
        final int n = nums.length;
        final int[] longestIncreasing = new int[n];
        final int[] longestDecreasing = new int[n];
        Arrays.fill(longestDecreasing, 1);
        Arrays.fill(longestIncreasing, 1);

        for(int i=0; i<n; i++) {
            for(int j=i-1; j >= 0; j--) {
                if(nums[i] > nums[j]) {
                    longestIncreasing[i] = Math.max(longestIncreasing[i], longestIncreasing[j] + 1);
                }
            }
        }

        for(int i=n - 1; i >= 0; i--) {
            for(int j = i + 1; j < n; j++) {
                if(nums[i] > nums[j]) {
                    longestDecreasing[i] = Math.max(longestDecreasing[i], longestDecreasing[j] + 1);
                }
            }
        }

        int minRemovals = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            if(longestIncreasing[i] > 1 && longestDecreasing[i] > 1) {
                minRemovals = Math.min(minRemovals, n - longestDecreasing[i] - longestIncreasing[i] + 1);
            }
        }
        return minRemovals;
    }
}

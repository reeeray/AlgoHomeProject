package leetcode.arrays.binarySearch;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 21.06.2023
 **/
public class MinCostToMakeArraysEq_2448 {

    public static void main(String[] args) {
        final int[] nums = {735103,366367,132236,133334,808160,113001,49051,735598,686615,665317,999793,426087,587000,649989,509946,743518};
        final int[] cost = {724182,447415,723725,902336,600863,287644,13836,665183,448859,917248,397790,898215,790754,320604,468575,825614};
        minCost(nums, cost);
    }

    public long minCostPrefSum(int[] nums, int[] cost) {
        // Sort integers by values.
        int n = nums.length;
        int[][] numsAndCost = new int[n][2];
        for (int i = 0; i < n; ++i) {
            numsAndCost[i][0] = nums[i];
            numsAndCost[i][1] = cost[i];
        }
        Arrays.sort(numsAndCost, (a, b) -> a[0] - b[0]);

        // Get the prefix sum array of the costs.
        long[] prefixCost = new long[n];
        prefixCost[0] = numsAndCost[0][1];
        for (int i = 1; i < n; ++i)
            prefixCost[i] = numsAndCost[i][1] + prefixCost[i - 1];

        // Then we try every integer nums[i] and make every element equals nums[i],
        // Start with nums[0]
        long totalCost = 0l;
        for (int i = 1; i < n; ++i)
            totalCost += 1l * numsAndCost[i][1] * (numsAndCost[i][0] - numsAndCost[0][0]);
        long answer = totalCost;

        // Then we try nums[1], nums[2] and so on. The cost difference is made by the change of
        // two parts: 1. prefix sum of costs. 2. suffix sum of costs.
        // During the iteration, record the minimum cost we have met.
        for (int i = 1; i < n; ++i) {
            int gap = numsAndCost[i][0] - numsAndCost[i - 1][0];
            totalCost += 1l * prefixCost[i - 1] * gap;
            totalCost -= 1l * (prefixCost[n - 1] - prefixCost[i - 1]) * gap;
            answer = Math.min(answer, totalCost);
        }

        return answer;
    }

    //Do not work with big numbers
    public static long minCost(final int[] nums, final int[] cost) {
        long numerator = 0;
        int denominator = 0;
        for(int i=0; i<nums.length; i++){
            numerator += (long)(nums[i] * cost[i]);
            denominator += cost[i];
        }
        long average = numerator/denominator;
        long minCost = 0;
        for(int i=0; i<nums.length; i++) {
            minCost += Math.abs(nums[i] - average) * cost[i];
        }
        return minCost;
    }

    // Get the cost of making every element equals base.
    private long getCost(int[] nums, int[] cost, int base) {
        long result = 0L;
        for (int i = 0; i < nums.length; ++i)
            result += 1L * Math.abs(nums[i] - base) * cost[i];
        return result;
    }
    public long minCostBS(int[] nums, int[] cost) {
        // Initialize the left and the right boundary of the binary search.
        int left = 1000001, right = 0;
        for (int num : nums) {
            left = Math.min(left, num);
            right = Math.max(right, num);
        }
        long answer = getCost(nums, cost, nums[0]);

        // As shown in the previous picture, if F(mid) > F(mid + 1), then the minimum
        // is to the right of mid, otherwise, the minimum is to the left of mid.
        while (left < right) {
            int mid = (right + left) / 2;
            long cost1 = getCost(nums, cost, mid);
            long cost2 = getCost(nums, cost, mid + 1);
            answer = Math.min(cost1, cost2);

            if (cost1 > cost2)
                left = mid + 1;
            else
                right = mid;
        }
        return answer;
    }
}

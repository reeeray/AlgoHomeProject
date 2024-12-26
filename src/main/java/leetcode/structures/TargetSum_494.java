package leetcode.structures;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.12.2024
 **/
public class TargetSum_494 {

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[] {1, 1, 1, 1, 1}, 3));
    }

    //work only for digits
    public static int findTargetSumWays(final int[] nums, final int target) {
        int count = 0;
         final List<String> combinations = new ArrayList<>();
         final StringBuilder sb = new StringBuilder();
         for(final int i : nums) {
             sb.append(i);
         }
         combinations.add(sb.toString());
         combinations.add("-" + sb.toString());
         while (!combinations.isEmpty()) {
             final String combination = combinations.remove(0);
             if(combination.length() == 1 || (combination.length() == 2 && combination.startsWith("-"))) {
                 count += Integer.valueOf(combination) == target ? 1 : 0;
                 continue;
             }
             int first, second;
             String rest;
             if(combination.startsWith("-")) {
                 first = Integer.parseInt(combination.substring(0, 2));
                 second = Integer.parseInt(combination.substring(2, 3));
                 rest = combination.length() > 3 ? combination.substring(3) : "";

             } else {
                 first = Integer.parseInt(combination.substring(0, 1));
                 second = Integer.parseInt(combination.substring(1, 2));
                 rest = combination.length() > 2 ? combination.substring(2) : "";
             }
             combinations.add("" + (first + second) + rest);
             combinations.add("" + (first - second) + rest);
         }
        return count;
    }

    int totalWays = 0;

    //TLE because Time complexity is O(2^n) and Space O(n)
    public int findTargetSumWaysRecursive(int[] nums, int target) {
        calculateWays(nums, 0, 0, target);
        return totalWays;
    }

    private void calculateWays(final int[] nums, final int currentIndex, final int currentSum, final int target) {
        if (currentIndex == nums.length) {
            // Check if the current sum matches the target
            if (currentSum == target) {
                totalWays++;
            }
        } else {
            // Include the current number with a positive sign
            calculateWays(
                    nums,
                    currentIndex + 1,
                    currentSum + nums[currentIndex],
                    target
            );
            // Include the current number with a negative sign
            calculateWays(
                    nums,
                    currentIndex + 1,
                    currentSum - nums[currentIndex],
                    target
            );
        }
    }

    int totalSum = 0;

    //Recursion with memoization works, Time O(n * totalSum) and Space O(n*totalSum)
    public int findTargetSumWaysWithMemoization(final int[] nums, final int target) {
        totalSum = Arrays.stream(nums).sum();

        final int[][] memo = new int[nums.length][2 * totalSum + 1];
        for (final int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return calculateWays(nums, 0, 0, target, memo);
    }

    private int calculateWays(final int[] nums, final int currentIndex, final int currentSum, final int target, final int[][] memo) {
        if (currentIndex == nums.length) {
            // Check if the current sum matches the target
            if (currentSum == target) {
                return 1;
            } else {
                return 0;
            }
        } else {
            // Check if the result is already computed
            if (memo[currentIndex][currentSum + totalSum] != Integer.MIN_VALUE) {
                return memo[currentIndex][currentSum + totalSum];
            }
            // Calculate ways by adding the current number
            int add = calculateWays(
                    nums,
                    currentIndex + 1,
                    currentSum + nums[currentIndex],
                    target,
                    memo
            );

            // Calculate ways by subtracting the current number
            int subtract = calculateWays(
                    nums,
                    currentIndex + 1,
                    currentSum - nums[currentIndex],
                    target,
                    memo
            );

            // Store the result in memoization table
            memo[currentIndex][currentSum + totalSum] = add + subtract;

            return memo[currentIndex][currentSum + totalSum];
        }
    }

    //Time O(n * totalSum) and Space O(n*totalSum)
    public static int findTargetSumWaysDynamicProgramming(final int[] nums, final int target) {
        final int totalSum = Arrays.stream(nums).sum();
        final int[][] dp = new int[nums.length][2 * totalSum + 1];

        // Initialize the first row of the DP table
        dp[0][nums[0] + totalSum] = 1;
        dp[0][-nums[0] + totalSum] += 1;

        // Fill the DP table
        for (int index = 1; index < nums.length; index++) {
            for (int sum = -totalSum; sum <= totalSum; sum++) {
                if (dp[index - 1][sum + totalSum] > 0) {
                    dp[index][sum + nums[index] + totalSum] += dp[index -
                            1][sum + totalSum];
                    dp[index][sum - nums[index] + totalSum] += dp[index -
                            1][sum + totalSum];
                }
            }
        }

        // Return the result if the target is within the valid range
        return Math.abs(target) > totalSum
                ? 0
                : dp[nums.length - 1][target + totalSum];
    }

    //Time O(n*totalSum) and Space O(2*totalSum)
    public static int findTargetSumWaysSpaceOptimizedDP(final int[] nums, final int target) {
        final int totalSum = Arrays.stream(nums).sum();
        int[] dp = new int[2 * totalSum + 1];

        // Initialize the first row of the DP table
        dp[nums[0] + totalSum] = 1; // Adding nums[0]
        dp[-nums[0] + totalSum] += 1; // Subtracting nums[0]

        // Fill the DP table
        for (int index = 1; index < nums.length; index++) {
            int[] next = new int[2 * totalSum + 1];
            for (int sum = -totalSum; sum <= totalSum; sum++) {
                if (dp[sum + totalSum] > 0) {
                    next[sum + nums[index] + totalSum] += dp[sum + totalSum];
                    next[sum - nums[index] + totalSum] += dp[sum + totalSum];
                }
            }
            dp = next;
        }

        // Return the result if the target is within the valid range
        return Math.abs(target) > totalSum ? 0 : dp[target + totalSum];
    }
}

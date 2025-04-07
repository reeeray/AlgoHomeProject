package leetcode.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 07.04.2025
 **/
public class PartitionEqualSubsetSum_416 {

    public static void main(String[] args) {

    }

    //Time O(n*target) and Space O(target)
    private static boolean canPartitionDP(final int[] nums) {
        int sum = 0;
        for(final int num : nums) {
            sum += num;
        }
        if(sum % 2 != 0) {
            return false;
        }
        final int target = sum / 2;
        final boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for(final int num : nums) {
            for(int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[target];
    }
    //TLE
    public static boolean canPartition(final int[] nums) {
        int sum = 0;
        for(final int num : nums) {
            sum += num;
        }
        if(sum % 2 != 0) {
            return false;
        }
        return dfs(nums, 0, sum / 2, 0);
    }

    private static boolean dfs(final int[] nums, final int index, final int target, final int curr) {
        if(curr == target) {
            return true;
        }
        if(curr > target) {
            return false;
        }
        if(dfs(nums, index + 1, target, curr + nums[index])) {
            return true;
        }
        if(dfs(nums, index + 1, target, curr)) {
            return true;
        }
        return false;
    }
}

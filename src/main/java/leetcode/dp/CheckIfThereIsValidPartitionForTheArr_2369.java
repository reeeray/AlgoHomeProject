package leetcode.dp;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 13.08.2023
 **/
public class CheckIfThereIsValidPartitionForTheArr_2369 {

    public static void main(String[] args) {

    }

    public static boolean validPartition(final int[] nums) {
        final boolean[] dp = new boolean[nums.length + 1];
        dp[0] = true;
        for(int i=0; i<nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                dp[i+1] |= dp[i-1];
            }
            if(i > 1 && nums[i] == nums[i-1] && nums[i-1] == nums[i-2]) {
                dp[i+1] |= dp[i-2];
            }
            if(i > 1 && nums[i] == nums[i-1] + 1 && nums[i-1] == nums[i-2] + 1) {
                dp[i+1] |= dp[i-2];
            }
        }
        return dp[nums.length];
    }
}

package leetcode.dp;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 17.07.2025
 **/
public class FindTheMaxLengthOfValidSubseqII_3202 {

    public static void main(String[] args) {

    }

    //Time O(k^2 + n*k) and Space O(k^2)
    public static int maximumLength(final int[] nums, final int k) {
        final int[][] dp = new int[k][k];
        int res = 0;
        for(int num : nums) {
            num %= k;
            for(int prev = 0; prev < k; prev++) {
                dp[prev][num] = dp[num][prev] + 1;
                res = Math.max(res, dp[prev][num]);
            }
        }
        return res;
    }
}

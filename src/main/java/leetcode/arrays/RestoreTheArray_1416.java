package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 23.04.2023
 **/
public class RestoreTheArray_1416 {

    public static void main(String[] args) {

    }

    private static int numberOfArrays(final String s, final int k) {
        final Integer[] dp = new Integer[s.length()];// dp[i] is a number of ways to print valid arrays from string s starting at i
        return dfs(s, k, 0, dp);
    }

    private static int dfs(final String s, final int k, final int i, final Integer[] dp) {
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;
        if(dp[i] != null) return dp[i];
        int ans = 0;
        long num = 0;
        for(int j=i; j<s.length(); j++) {
            num = num*10 + s.charAt(j) - '0';
            if(num > k) break;
            ans += dfs(s, k, j+1, dp);
            ans %= 1_000_000_007;
        }
        return dp[i] = ans;
    }
}

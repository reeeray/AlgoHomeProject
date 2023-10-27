package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 27.10.2023
 **/
public class LongestPalindromicSubstring_5 {

    public static void main(String[] args) {

    }

    public String longestPalindrome_1(String s) {
        if(s == null || s.isEmpty())
            return s;
        final int len = s.length();
        int max = 0;
        String ans = "";
        final boolean[][] dp = new boolean[len][len];
        for(int j=0; j<len; j++) {
            for(int i=0; i<=j; i++) {
                final boolean judge = s.charAt(i) == s.charAt(j);
                dp[i][j] = j - i > 2 ? (dp[i+1][j-1] && judge) : judge;

                if(dp[i][j] && j- i + 1> max) {
                    max = j - i + 1;
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }

    //O(n^3) and O(1)
    public String longestPalindrome_2(String s) {
        for (int length = s.length(); length > 0; length--) {
            for (int start = 0; start <= s.length() - length; start++) {
                if (check(start, start + length, s)) {
                    return s.substring(start, start + length);
                }
            }
        }

        return "";
    }

    private boolean check(int i, int j, String s) {
        int left = i;
        int right = j - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    //DP : O(n^2) and O(n^2)
    public String longestPalindrome_3(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] ans = new int[]{0, 0};

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                ans[0] = i;
                ans[1] = i + 1;
            }
        }

        for (int diff = 2; diff < n; diff++) {
            for (int i = 0; i < n - diff; i++) {
                int j = i + diff;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }

        int i = ans[0];
        int j = ans[1];
        return s.substring(i, j + 1);
    }
}

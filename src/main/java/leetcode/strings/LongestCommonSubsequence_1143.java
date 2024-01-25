package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 25.01.2024
 **/
public class LongestCommonSubsequence_1143 {

    public static void main(String[] args) {

    }

    //DP
    public static int longestCommonSubsequence(final String text1, final String text2) {
        final int[][] dp = new int[text1.length() + 1][text2.length() + 1];
//        for(int i=0; i<text1.length(); i++) {
//            dp[i][0] = text1.charAt(i) == text2.charAt(0) ? 1 : 0;
//        }
//
//        for(int i=1; i<text2.length(); i++) {
//            dp[0][i] = text2.charAt(i) == text1.charAt(0) ? 1 : 0;
//        }

        for(int i=1; i<=text1.length(); i++) {
            for(int j=1; j<=text2.length(); j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}

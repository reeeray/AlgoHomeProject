package leetcode.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 23.09.2024
 **/
public class ExtraCharactersInAString_2707 {

    public static void main(String[] args) {

    }

    //bottom up dynaming approach with substring. Space O(n + m*k) and Time O(n^3). n - length of the string, m - average length of string dictionary and k - number of strings in dictionary
    public static int minExtraChar(final String s, final String[] dictionary) {
        final int n = s.length();
        final Set<String> vocabulary = new HashSet<>(Arrays.asList(dictionary));
        final int[] dp = new int[n + 1];
        for(int start = n - 1; start >= 0; start++) {
            dp[start] = dp[start + 1] + 1;
            for(int end = start; end < n; end++) {
                final String curr = s.substring(start, end + 1);
                if(vocabulary.contains(curr)) {
                    dp[start] = Math.min(dp[start], dp[end + 1]);
                }
            }
        }
        return dp[0];
    }
}

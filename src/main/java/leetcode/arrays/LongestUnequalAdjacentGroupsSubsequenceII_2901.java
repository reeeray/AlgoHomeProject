package leetcode.arrays;

import leetcode.structures.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 16.05.2025
 **/
public class LongestUnequalAdjacentGroupsSubsequenceII_2901 {

    public static void main(String[] args) {
        getWordsInLongestSubsequence(new String[]{"bad","dc","bc","ccd","dd","da","cad","dba","aba"}, new int[] {9,7,1,2,6,8,3,7,2});
    }

    //Dynamic Programming where Time is O(n^2L) and Space O(n) where L is the length of each string in words
    public static List<String> getWordsInLongestSubsequence(final String[] words, final int[] groups) {
        final int n = groups.length;
        final int[] dp = new int[n];
        final int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j] && hammingDistance(words[i], words[j]) &&
                                dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }
        final List<String> ans = new ArrayList<>();
        for (int i = maxIndex; i >= 0; i = prev[i]) {
            ans.add(words[i]);
        }
        Collections.reverse(ans);
        return ans;
    }

    private static boolean hammingDistance(final String word1, final String word2) {
        if(word1.length() != word2.length()) {
            return false;
        }
        boolean wasDiff = false;
        for(int i = 0; i < word1.length(); i++) {
            if(word1.charAt(i) != word2.charAt(i)) {
                if(wasDiff) {
                    return false;
                } else {
                    wasDiff = true;
                }
            }
        }
        return true;
    }
}

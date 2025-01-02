package leetcode.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 02.01.2025
 **/
public class CountVowelStringsInRanges_2559 {

    public static void main(String[] args) {
        vowelStrings(new String[] {"aba", "bcb", "ece", "aa", "e"}, new int[][] {{0, 2}, {1, 4}, {1, 1}});
    }

    public static int[] vowelStrings(final String[] words, final int[][] queries) {
        final Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        final int[] res = new int[queries.length];
        final int[] dp = new int[words.length];
        for(int i = words.length - 1; i >= 0; i--) {
            final int add = vowels.contains(words[i].charAt(0)) && vowels.contains(words[i].charAt(words[i].length() - 1)) ? 1 : 0;
            dp[i] = (i < words.length + 1 ? dp[i - 1] : 0) + add;
        }

        for(int i = 0; i < queries.length; i++) {
            final int[] querie = queries[i];
            final int left = dp[querie[0]];
            final int right = dp[querie[1]];
            final int add = vowels.contains(words[querie[1]].charAt(0)) && vowels.contains(words[querie[1]].charAt(words[i].length() - 1)) ? 1 : 0;
            res[i] = left - right + add;
        }
        return res;
    }

    //Time O(m + n) where m is size of words and n size of queries, Space O(m)
    public int[] vowelStringsPrefixSum(String[] words, int[][] queries) {
        final int[] ans = new int[queries.length];
        final HashSet<Character> vowels = new HashSet<>(
                Arrays.asList('a', 'e', 'i', 'o', 'u')
        );
        final int[] prefixSum = new int[words.length];
        int sum = 0;
        for (int i = 0; i < words.length; i++) {
            final String currentWord = words[i];
            if (
                    vowels.contains(currentWord.charAt(0)) &&
                            vowels.contains(currentWord.charAt(currentWord.length() - 1))
            ) {
                sum++;
            }
            prefixSum[i] = sum;
        }

        for (int i = 0; i < queries.length; i++) {
            final int[] currentQuery = queries[i];
            ans[i] =
                    prefixSum[currentQuery[1]] -
                            (currentQuery[0] == 0 ? 0 : prefixSum[currentQuery[0] - 1]);
        }

        return ans;
    }

    public int[] vowelStringsFstest(final String[] words, final int[][] queries) {
        final int n = words.length;
        final int[] count = new int[n+1];
        for (int i=0;i<n;i++) {
            if (isVowelString(words[i])) {
                count[i+1]++;
            }
        }
        for (int i=1;i<=n;i++) {
            count[i]+= count[i-1];
        }
        final int[] res = new int[queries.length];
        int i = 0;
        for (int[] q:queries) {
            int l = q[0];
            int r = q[1];
            res[i++] = count[r+1]-count[l];
        }
        return res;
    }
    public boolean isVowelString(String str) {
        return isVowel(str.charAt(0)) && isVowel(str.charAt(str.length()-1));
    }
    public boolean isVowel(char ch) {
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }
}

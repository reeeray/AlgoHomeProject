package leetcode.dp;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 29.12.2024
 **/
public class NumberOfWaysToFormATargetStringGivenADictionary_1639 {

    private static final int MOD = (int)(1e9 + 7);

    public static void main(String[] args) {
        System.out.println(numWays(new String[] {"acca", "bbbb", "caca"}, "aba"));
    }

    public static int numWays(final String[] words, final String target) {
        final List<int[]> levels = new ArrayList<>();
        for(int i=0; i<words[0].length(); i++) {
            final int[] currLevel = new int[26];
            for(final String word : words) {
                currLevel[word.charAt(i) - 'a']++;
            }
            levels.add(currLevel);
        }
        final int[] ans = new int[1];
        for(int i=0; i<=words[0].length() - target.length(); i++) {
            final int[] currLevel = levels.get(i);
            if(currLevel[target.charAt(0) - 'a'] == 0) {
                continue;
            }
            dfs(levels, target, 1, i+1, currLevel[target.charAt(0) - 'a'], ans);
        }

        return ans[0];
    }

    private static void dfs(final List<int[]> levels, final String target, final int index, final int level, final int factor, final int[] ans) {
        if(target.length() == index) {
            ans[0] += factor % MOD;
            return;
        }
        if((target.length() - index > levels.size() - level)) {
            return;
        }
        final int[] currLevel = levels.get(level);
        if(currLevel[target.charAt(index) - 'a'] != 0) {
            dfs(levels, target, index + 1, level + 1, factor*currLevel[target.charAt(index) - 'a'], ans);
        }
        dfs(levels, target, index, level + 1, factor, ans);
    }

    //Time O(wordLength*targetLength + wordLength*totalWords) and Space O(wordLength*targetLength)
    public int numWaysTopDownDynamicProgramming(String[] words, String target) {
        int wordLength = words[0].length();
        int targetLength = target.length();

        // Initialize DP table and frequency table
        int[][] dp = new int[wordLength][targetLength];
        for (int i = 0; i < wordLength; i++) {
            Arrays.fill(dp[i], -1);
        }
        int[][] charFrequency = new int[wordLength][26];

        // Store the frequency of every character at each index in the words
        for (String word : words) {
            for (int j = 0; j < wordLength; j++) {
                int character = word.charAt(j) - 'a';
                charFrequency[j][character]++;
            }
        }

        return (int) getWords(words, target, 0, 0, dp, charFrequency);
    }

    private long getWords(
            String[] words,
            String target,
            int wordsIndex,
            int targetIndex,
            int[][] dp,
            int[][] charFrequency
    ) {
        int MOD = 1000000007;

        // If the target is fully matched
        if (targetIndex == target.length()) return 1;

        // If we have no more columns in the words or not enough columns left to match
        // the target
        if (
                wordsIndex == words[0].length() ||
                        words[0].length() - wordsIndex < target.length() - targetIndex
        ) return 0;

        // If already computed, return the stored result
        if (
                dp[wordsIndex][targetIndex] != -1
        ) return dp[wordsIndex][targetIndex];

        long countWays = 0;
        int curPos = target.charAt(targetIndex) - 'a';

        // Don't match any character of the target with the current word column
        countWays += getWords(
                words,
                target,
                wordsIndex + 1,
                targetIndex,
                dp,
                charFrequency
        );

        // Match the current character of the target with the current word column
        countWays +=
                charFrequency[wordsIndex][curPos] *
                        getWords(
                                words,
                                target,
                                wordsIndex + 1,
                                targetIndex + 1,
                                dp,
                                charFrequency
                        );

        // Store the result in dp and return the answer
        dp[wordsIndex][targetIndex] = (int) (countWays % MOD);

        return dp[wordsIndex][targetIndex];
    }

    //Time (wordLength*targetLength + wordLength*totalWords) and Space (wordLength * targetLength)
    public int numWaysBottomUpDynamicProgramming(String[] words, String target) {
        int wordLength = words[0].length();
        int targetLength = target.length();
        final int MOD = 1000000007;

        // Step 1: Calculate frequency of each character at every index in
        // "words".
        int[][] charFrequency = new int[wordLength][26];
        for (String word : words) {
            for (int j = 0; j < wordLength; ++j) {
                charFrequency[j][word.charAt(j) - 'a']++;
            }
        }

        // Step 2: Initialize a DP table.
        long[][] dp = new long[wordLength + 1][targetLength + 1];

        // Base case: There is one way to form an empty target string.
        for (int currWord = 0; currWord <= wordLength; ++currWord) {
            dp[currWord][0] = 1;
        }

        // Step 3: Fill the DP table.
        for (int currWord = 1; currWord <= wordLength; ++currWord) {
            for (int currTarget = 1; currTarget <= targetLength; ++currTarget) {
                // Carry over the previous value (not using this index of
                // "words").
                dp[currWord][currTarget] = dp[currWord - 1][currTarget];

                // Add ways using the current index of "words" if the characters
                // match.
                int curPos = target.charAt(currTarget - 1) - 'a';
                dp[currWord][currTarget] +=
                        (charFrequency[currWord - 1][curPos] *
                                dp[currWord - 1][currTarget - 1]) %
                                MOD;
                dp[currWord][currTarget] %= MOD;
            }
        }

        // Step 4: The result is in dp[wordLength][targetLength].
        return (int) dp[wordLength][targetLength];
    }

    public int numWaysSpaceOptimizedBottomUpDP(String[] words, String target) {
        int wordLength = words[0].length();
        int targetLength = target.length();

        final int MOD = 1_000_000_007;

        //Step 1: Calculate frequency of each character at every index in "words".
        int[][] charFrequency = new int[wordLength][26];
        for (String word : words) {
            for (int j = 0; j < wordLength; j++) {
                charFrequency[j][word.charAt(j) - 'a']++;
            }
        }

        //Step 2: Initialize two DP arrays: prev and curr.
        long[] prevCount = new long[targetLength + 1];
        long[] currCount = new long[targetLength + 1];

        //Base case: There is one way to form an empty target string.
        prevCount[0] = 1;

        //Step 3: Fill the DP arrays.
        for (int currWord = 1; currWord <= wordLength; currWord++) {
            // Copy the previous row into the current row for DP.
            System.arraycopy(prevCount, 0, currCount, 0, currCount.length);
            for (int currTarget = 1; currTarget <= targetLength; currTarget++) {
                // If characters match, add the number of ways.
                int curPos = target.charAt(currTarget - 1) - 'a';
                currCount[currTarget] +=
                        (1L *
                                charFrequency[currWord - 1][curPos] *
                                prevCount[currTarget - 1]) %
                                MOD;
                currCount[currTarget] %= MOD;
            }
            // Move current row to previous row for the next iteration.
            System.arraycopy(currCount, 0, prevCount, 0, prevCount.length);
        }

        //Step 4: The result is in prev[targetLength].
        return (int) prevCount[targetLength];
    }
}

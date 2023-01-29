package leetcode.graphs;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 27.01.2023
 **/
public class ConcatenatedWords_472 {

    public static void main(String[] args) {

    }

    private List<String> findAllConcatenatedWordsInADict(final String[] words) {
        final Set<String> dictionary = new HashSet<>();
        final List<String> result = new ArrayList<>();
        for(final String word : words) {
            dictionary.add(word);
        }

        for(final String word : words) {
            final boolean[] visited = new boolean[word.length()];

            if(dfs(dictionary, word, 0, visited)) {
                result.add(word);
            }
        }
        return result;
    }

    private static boolean dfs(final Set<String> dictionary, final String word, final int length, final boolean[] visited) {
        if(length == word.length()) {
            return true;
        }

        if(visited[length]) {
            return false;
        }
        visited[length] = true;

        for(int i=word.length() - (length == 0 ? 1 : 0); i > length; i--) {
            if(dictionary.contains(word.substring(length, i)) && dfs(dictionary, word, i, visited)) {
                return true;
            }
        }
        return false;
    }

    //Dynamic programming (DP)

    /**
     * Steps
     * Put all the words into a HashSet as a dictionary.
     * Create an empty list answer.
     * For each word in the words create a boolean array dp of length = word.length + 1, and set dp[0] = true.
     * For each index i from 1 to word.length, set dp[i] to true if we can find a value j from 0 (1 if i == word.length) such that dp[j] = true and word.substring(j, i) is in the dictionary.
     * Put word into answer if dp[word.length] = true.
     * After processing all the words, return answer.
     * @param words
     * @return
     */
    public List<String> findAllConcatenatedWordsInADictDP(String[] words) {
        final Set<String> dictionary = new HashSet<>(Arrays.asList(words));
        final List<String> answer = new ArrayList<>();
        for (final String word : words) {
            final int length = word.length();
            final boolean[] dp = new boolean[length + 1];
            dp[0] = true;
            for (int i = 1; i <= length; ++i) {
                for (int j = (i == length ? 1 : 0); !dp[i] && j < i; ++j) {
                    dp[i] = dp[j] && dictionary.contains(word.substring(j, i));
                }
            }
            if (dp[length]) {
                answer.add(word);
            }
        }
        return answer;
    }
}

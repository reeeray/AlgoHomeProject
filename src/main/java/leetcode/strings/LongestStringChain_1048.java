package leetcode.strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 23.09.2023
 **/
public class LongestStringChain_1048 {

    public static void main(String[] args) {

    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        final Map<String, Integer> map = new HashMap<>();
        int ans = 0;

        for (String word : words) {
            int longest = 0;
            for (int i = 0; i < word.length(); i++) {
                final StringBuilder sub = new StringBuilder(word);
                sub.deleteCharAt(i);
                final String subStr = sub.toString();
                longest = Math.max(longest, map.getOrDefault(subStr, 0) + 1);
            }
            map.put(word, longest);
            ans = Math.max(ans, longest);
        }

        return ans;
    }
}

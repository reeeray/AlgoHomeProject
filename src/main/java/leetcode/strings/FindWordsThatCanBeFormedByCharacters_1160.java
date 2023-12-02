package leetcode.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 02.12.2023
 **/
public class FindWordsThatCanBeFormedByCharacters_1160 {

    public static void main(String[] args) {
        final String chars = "welldonehoneyr";
        countCharacters(new String[] {"hello", "world", "leetcode"}, chars);
    }

    public static int countCharacters(final String[] words, final String chars) {
        final List<Character> pool = new ArrayList<>();
        for(char c : chars.toCharArray()) {
            pool.add(c);
        }
        int total = 0;
        for(final String word : words) {
            final List<Character> hash = new ArrayList<>(pool);
            boolean flag = true;
            for(char c : word.toCharArray()) {
                if(!hash.remove((Character)c)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                total += word.length();
            }
        }
        return total;
    }

    public int countCharactersArr(String[] words, String chars) {
        int[] counts = new int[26];
        for (Character c : chars.toCharArray()) {
            counts[c - 'a']++;
        }

        int ans = 0;
        for (String word : words) {
            int[] wordCount = new int[26];
            for (Character c : word.toCharArray()) {
                wordCount[c - 'a']++;
            }

            boolean good = true;
            for (int i = 0; i < 26; i++) {
                if (counts[i] < wordCount[i]) {
                    good = false;
                    break;
                }
            }

            if (good) {
                ans += word.length();
            }
        }

        return ans;
    }
}

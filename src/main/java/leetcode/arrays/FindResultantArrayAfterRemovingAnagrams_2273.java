package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 13.10.2025
 **/
public class FindResultantArrayAfterRemovingAnagrams_2273 {

    public static void main(String[] args) {

    }

    //Time O(mn) and Space O(sum)
    public List<String> removeAnagrams(final String[] words) {
        final List<String> res = new ArrayList<>();
        res.add(words[0]);
        String lastRepr = represent(words[0]);
        for(int i = 1; i < words.length; i++) {
            final String currRepr = represent(words[i]);
            if(!currRepr.equals(lastRepr)) {
                res.add(words[i]);
                lastRepr = currRepr;
            }
        }
        return res;
    }

    private static String represent(final String word) {
        final int[] chars = new int[26];
        for(final char c : word.toCharArray()) {
            chars[c - 'a']++;
        }
        final StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            while (chars[i] != 0) {
                sb.append((char)('a' + i));
                chars[i]--;
            }
        }
        return sb.toString();
    }
}

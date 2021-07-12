package leetcode.strings;

import java.util.HashMap;

/**
 * 205. Isomorphic Strings.
 * <p>
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
 * <p>
 * User : Shein G.A.{@reeeray}
 * Date : 12.07.2021
 **/
public class IsomorphicStrings_205 {

    public static void main(String[] args) {

        final boolean actual = isIsomorphic("paper", "title");

        System.out.println(actual);

        assert actual == true;

    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map1.containsKey(c1)) {
                if (c2 != map1.get(c1)) {
                    return false;
                }
            } else {
                if (map2.containsKey(c2)) {
                    return false;
                }

                map1.put(c1, c2);
                map2.put(c2, c1);
            }
        }
        return true;
    }
}

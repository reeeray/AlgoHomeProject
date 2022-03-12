package leetcode.arrays;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 12.03.2022
 **/
public class LongestSubstrWithoutRepeating_3 {

    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutRepeatingCharacters("abcabcbb"));
    }


    private static int longestSubstringWithoutRepeatingCharacters(final String s) {
        final Set<Character> uniqeLine = new LinkedHashSet<>();
        int longest = 0;
        int tempLength = 0;
        for (char c : s.toCharArray()) {
            if (uniqeLine.contains(c)) {
                longest = longest > tempLength ? longest : tempLength;
                final Iterator<Character> iterator = uniqeLine.iterator();
                while (iterator.hasNext()) {
                    final char toRemove = iterator.next();
                    iterator.remove();
                    if (toRemove == c) {
                        break;
                    }
                }
                uniqeLine.add(c);
                tempLength = uniqeLine.size();
            } else {
                tempLength++;
                uniqeLine.add(c);
            }
        }
        longest = longest > tempLength ? longest : tempLength;
        return longest;
    }
}

package leetcode.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 17.10.2022
 **/
public class Panagram_1832 {

    public static void main(String[] args) {
        assert isPanagram("thequickbrownfoxjumpsoverthelazydog") == true;
    }

    private static boolean isPanagram(final String sentence) {
        final Set<Character> chars = new HashSet<>();
        for (char c : sentence.toCharArray()) {
            chars.add(c);
        }

        return chars.size() == 26;
    }
}

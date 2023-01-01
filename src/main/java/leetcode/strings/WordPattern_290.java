package leetcode.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 01.01.2023
 **/
public class WordPattern_290 {

    public static void main(String[] args) {
        final String pattern = "abba";
        final String str = "dog cat cat dog";

        assert true == wordPattern(pattern, str);
    }

    private static boolean wordPattern(final String pattern, final String s) {
        final Map<Character, String> dic = new HashMap<>();
        final String[] words = s.split(" ");
        final Set<String> uniqe = new HashSet<>();
        if(pattern.length() != words.length) {
            return false;
        }

            for(int i=0; i<words.length; i++) {
            final String check = dic.get(pattern.charAt(i));
            if(check == null) {
                if(!uniqe.add(words[i])) {
                    return false;
                }
                dic.put(pattern.charAt(i), words[i]);
            } else if(!check.equals(words[i])) {
                return false;
            }
        }
        return true;
    }
}

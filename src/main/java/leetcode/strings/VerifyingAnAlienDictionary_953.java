package leetcode.strings;

import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 02.02.2023
 **/
public class VerifyingAnAlienDictionary_953 {

    public static void main(String[] args) {
        final String[] words = {"iekm", "tpnhnbe"};
        isAlienSorted(words, "loxbzapnmstkhijfcuqdewyvrg");
    }

    public static boolean isAlienSorted(final String[] words, final String order) {
        final int[] priority = new int[26];
        for(int i=0; i<26; i++) {
            priority[order.charAt(i) - 'a'] = 26 - i;
        }

        for(int i=1; i<words.length; i++) {
            final String left = words[i-1];
            final String right = words[i];
            if(left.contains(right)) {
                return false;
            }
            for(int j=0; j<left.length()&&j<right.length(); j++) {
                if(priority[left.charAt(j) - 'a'] > priority[right.charAt(j) - 'a']) {
                    break;
                }
                if(priority[left.charAt(j) - 'a'] < priority[right.charAt(j) - 'a']) {
                    return false;
                }
            }
        }

        return true;
    }
}

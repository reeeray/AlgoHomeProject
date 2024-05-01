package leetcode.strings;

import coursera.data_structures.stack.Stack;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 01.05.2024
 **/
public class ReversePrefixOfWord_2000 {

    public static void main(String[] args) {

    }

    public String reversePrefix(final String word, final char ch) {
        final StringBuilder sb = new StringBuilder();
        for(int i = 0; i<word.length(); i++) {
            final char c = word.charAt(i);
            sb.append(c);
            if(c == ch) {
                return sb.reverse().toString() + word.substring(i+1);
            }
        }
        return word;
    }
}

package leetcode.strings;

import java.util.Stack;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 11.04.2023
 **/
public class RemovinStarsFromString_2390 {

    public static void main(String[] args) {
        final String str = "leet**cod*e";
        assert "lecoe".equals(removeStars(str));
    }

    public static String removeStars(final String s) {
        final Stack<Character> stack = new Stack<>();
        for(final char c : s.toCharArray()) {
            if(c == '*') {
                stack.pop();
            } else {
                stack.add(c);
            }
        }
        final StringBuilder sb = new StringBuilder();
        for(final char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}

package leetcode.strings;

import java.util.Stack;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 22.02.2022
 **/
public class ValidParanthesis_20 {

    public static void main(String[] args) {
        System.out.println(isValid("{[]()}"));
    }


    public static boolean isValid(String s) {
        final Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                final char character = stack.pop();
                if (c == ')' && character == '(') continue;
                if (c == '}' && character == '{') continue;
                if (c == ']' && character == '[') continue;
                return false;
            }
        }
        return stack.isEmpty();
    }
}

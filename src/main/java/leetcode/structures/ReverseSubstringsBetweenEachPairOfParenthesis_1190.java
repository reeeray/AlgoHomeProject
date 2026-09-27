package leetcode.structures;

import java.util.Stack;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 27.09.2026
 **/
public class ReverseSubstringsBetweenEachPairOfParenthesis_1190 {

    public static void main(String[] args) {
        reverseParentheses("a(bcdefghijkl(mno)p)q");
    }

    //Time O(n) and SpaceO(n)
    public static String reverseParentheses(String s) {
        final Stack<StringBuilder> sbStack = new Stack<>();
        StringBuilder sb = null;
        for(final char c : s.toCharArray()) {
            if(c == '(') {
                if(sb != null) sbStack.push(sb);
                sb = new StringBuilder();
            } else if(c == ')') {
                if(!sbStack.isEmpty()) sb = sbStack.pop().append(sb.reverse().toString());
                else sb = sb.reverse();
            } else {
                if(sb == null) sb = new StringBuilder();
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

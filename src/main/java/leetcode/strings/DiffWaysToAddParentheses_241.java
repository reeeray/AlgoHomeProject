package leetcode.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 19.09.2024
 **/
public class DiffWaysToAddParentheses_241 {

    public static void main(String[] args) {
        diffWaysToCompute("2-1-1");
    }

    //Time O(n*(2^n)) and Space O(2^n)
    public static List<Integer> diffWaysToCompute(final String expression) {
        final List<Integer> result = new ArrayList<>();
        if(expression.length() == 0) {
            return result;
        }

        if(expression.length() < 3) {
            result.add(Integer.parseInt(expression));
            return result;
        }

        for(int i=0; i<expression.length(); i++) {
            if(Character.isDigit(expression.charAt(i))) continue;
            final List<Integer> leftRes = diffWaysToCompute(expression.substring(0, i));
            final List<Integer> rightRes = diffWaysToCompute(expression.substring(i+1));
            for(final int left : leftRes) {
                for(final int right : rightRes) {
                    final char operator = expression.charAt(i);
                    switch (operator) {
                        case '+' : result.add(left + right); break;
                        case '-' : result.add(left - right); break;
                        case '*' : result.add(left * right); break;
                        case '/' : result.add(left / right); break;
                    }

                }
            }
        }

        return result;
    }
}

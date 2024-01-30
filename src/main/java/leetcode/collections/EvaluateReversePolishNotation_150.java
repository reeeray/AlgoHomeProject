package leetcode.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 30.01.2024
 **/
public class EvaluateReversePolishNotation_150 {

    public static void main(String[] args) {
        final String[] tokens = new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
        assert evalRPN(tokens) == 22;
    }

    public static int evalRPN(final String[] tokens) {
        final Stack<Integer> digits = new Stack<>();
        final List<String> operands = new ArrayList<>();
        operands.add("+");
        operands.add("-");
        operands.add("*");
        operands.add("/");
        for(final String token : tokens) {
            if(operands.contains(token)) {
                int b = digits.pop();
                int a = digits.pop();
                switch (token) {
                    case "+": digits.add(a + b); break;
                    case "-" : digits.add(a - b); break;
                    case "*" : digits.add(a * b); break;
                    case "/" : digits.add(a / b); break;
                }
            } else {
                digits.add(Integer.parseInt(token));
            }
        }
        return digits.pop();
    }

    int i;

    public int evalRPNEfficient(String[] tokens) {
        i = tokens.length-1;
        return operation(tokens);
    }

    public int operation(String[] tokens){
        String op = tokens[i--];
        int left, right;
        switch(op){
            case "*":
                right = operation(tokens);
                left = operation(tokens);
                return left * right;
            case "/":
                right = operation(tokens);
                left = operation(tokens);
                return left / right;
            case "-":
                right = operation(tokens);
                left = operation(tokens);
                return left - right;
            case "+":
                right = operation(tokens);
                left = operation(tokens);
                return left + right;
            default :
                return Integer.parseInt(op);
        }
    }
}

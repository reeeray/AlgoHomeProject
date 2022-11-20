package leetcode.pureLogic;

import java.util.Stack;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 20.11.2022
 **/
public class BasicCalculator_224 {

    public static void main(String[] args) {

        assert 23 == calculateWorking("(1+(4+5+2)-3)+(6+8)");
    }

    public static int calculate(final String expression) {
        int value = 0;
        int res = 0;
        int sign = 1;
        final Stack<Integer> stk = new Stack<>();
        final Stack<Integer> stkSign = new Stack<>();

        for(char c : expression.toCharArray()){
            if(c >= '0' && c <= '9'){
                value = value* 10 + (c-'0');
            }else if(c == '+'){
                res += sign * value;
                value = 0;
                sign = 1;
            }else if(c == '-'){
                res += sign * value;
                value = 0;
                sign = -1;
            }else if(c == '('){
                stk.push(res);
                stkSign.push(sign);
                res = 0;
                sign = 1;
            }else if(c == ')'){
                res += sign * value;
                res *= stkSign.firstElement();
                stkSign.pop();
                res += stk.firstElement();
                stk.pop();
                value = 0;
            }
        }
        return res + sign * value;
    }

    public static int calculateWorking(String s) {
        int res = 0;
        int sign = 1;
        final Stack<Integer> stk = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                int val = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                val = val * sign;
                sign = 1;
                res += val;
            }
            else if(ch == '('){
                stk.push(res);
                stk.push(sign);
                res = 0;
                sign = 1;
            }
            else if(ch == ')'){
                res *= stk.pop();
                res += stk.pop();
            }
            else if(ch == '-'){
                sign*= -1;
            }
        }
        return res;
    }
}

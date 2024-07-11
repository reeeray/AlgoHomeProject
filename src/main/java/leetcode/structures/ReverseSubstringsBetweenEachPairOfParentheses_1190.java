package leetcode.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 11.07.2024
 **/
public class ReverseSubstringsBetweenEachPairOfParentheses_1190 {

    public static void main(String[] args) {
        assert "leetcopogde".equals(reverseParenthese("(ed(et(oc)pog)el)"));
    }

    //OTime (n^2) and Space O(n)
    public static String reverseParenthese(final String s) {
        final Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.add(sb.toString());
                sb.setLength(0);
            } else if(s.charAt(i) == ')') {
                final String str = sb.reverse().toString();
                sb = new StringBuilder();
                sb.append(stack.pop());
                sb.append(str);
            } else {
                sb.append(s.charAt(i));
            }
        }
          return sb.toString();
    }

    public String reverseParentheses(String s) {
        char[] ar = s.toCharArray();
        return helper(ar);
    }

    public String helper(char[] s){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < s.length){
            if(s[i] == ')'){
                i++;
                return sb.reverse().toString();
            }else if(s[i] == '('){
                i++;
                String st  = helper(s);
                //System.out.println(st);
                sb.append(st);
            }else{
                sb.append(s[i]);
                i++;
            }
        }
        return sb.toString();

    }
}

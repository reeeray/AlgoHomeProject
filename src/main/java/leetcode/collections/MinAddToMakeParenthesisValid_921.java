package leetcode.collections;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 09.10.2024
 **/
public class MinAddToMakeParenthesisValid_921 {

    public static void main(String[] args) {

    }

    public static int minAddToMakeParenthesisValid(final String s) {
        int counter = 0;
        int missed = 0;
        for(final char c : s.toCharArray()) {
            if(c == '(') {
                counter++;
            } else {
                if(counter > 0) {
                    counter--;
                } else {
                    missed++;
                }
            }
        }
        return counter + missed;
    }
}

package leetcode.pureLogic;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 03.09.2024
 **/
public class SumOfDigitsOfStringAfterConvert_1945 {

    public static void main(String[] args) {

    }

    //Most optimized from beginning, Space O(1) and Time O(1)
    public static int getLucky(final String s, final int k) {
        final StringBuilder sb = new StringBuilder();
        for(final char c : s.toCharArray()) {
            final int digit = c - 'a' + 1;
            sb.append(digit / 10);
            sb.append(digit % 10);
        }
        String curr = sb.toString();
        for(int i=0; i<k; i++) {
            int res = 0;
            for(final char c : curr.toCharArray()) {
                res += c - '0';
            }
            curr = "" + res;
        }
        return Integer.parseInt(curr);
    }
}

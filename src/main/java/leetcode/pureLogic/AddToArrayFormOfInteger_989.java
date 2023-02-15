package leetcode.pureLogic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 15.02.2023
 **/
public class AddToArrayFormOfInteger_989 {

    public static void main(String[] args) {
        addToArrayFormEff(new int[] {9,9,9,9,9,9,9,9,9,9}, 1);
    }

    private static  List<Integer> addToArrayFormEff(final int[] num, final int k) {
        final String repr = String.valueOf(k);
        final List<Integer> answ = new ArrayList<>();
        int j = num.length - 1;
        int i = repr.length() - 1;
        int leftover = 0;
        while(i >= 0 || j >= 0) {
            final int left = j >= 0 ? num[j--] : 0;
            final int right = i >= 0 ? repr.charAt(i--) - '0' : 0;
            final int sum = leftover + left + right;
            answ.add(sum%10);
            leftover = sum/10;
        }
        if(leftover != 0) {
            answ.add(leftover);
        }
        Collections.reverse(answ);
        return answ;
    }

    public List<Integer> addToArrayForm(final int[] num, final int k) {
        final StringBuilder numStr = new StringBuilder();
        for(final int digit : num) {
            numStr.append(digit);
        }
        final int res = Integer.valueOf(numStr.toString()) + k;
        final List<Integer>  answ = new ArrayList<>();
        for(final char c : String.valueOf(res).toCharArray()) {
            answ.add(c - '0');
        }
        return answ;
    }
}

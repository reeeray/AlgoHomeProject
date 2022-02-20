package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 02.02.2022
 **/
public class PalindromNumber9 {

    public static void main(String[] args) {
        System.out.println(isPalindrom(123));
        System.out.println(isPalindrom(121));
    }

    private static boolean isPalindrom(final int num) {
        final char[] representation = String.valueOf(num).toCharArray();
        int fi = 0;
        int li = representation.length - 1;

        while (fi < li) {
            if (representation[fi] != representation[li])
                return false;
            fi++;
            li--;
        }
        List<Integer> arr = new ArrayList<>();
//        ((int[])arr.toArray());
        return true;
    }
}

package leetcode.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 03.01.2023
 **/
public class DeleteColumnsToMakeSorted_944 {

    public static void main(String[] args) {
        final String[] input = {"rrjk", "furt", "guzm"};
        System.out.println(minDeletionSize(input));

    }

    private static int minDeletionSize(final String[] strs) {
        final int n = strs[0].length();
//        final Set<Integer> cols = new HashSet<>();
        int counter = 0;
        for(int i=0; i<n; i++) {
            for(int j=1; j<strs.length; j++) {
                if(strs[j-1].charAt(i) > strs[j].charAt(i)) {
                    counter++;
                    break;
                }
            }
        }
        return counter;
    }
}

package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 12.06.2023
 **/
public class SummaryRanges_228 {

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[] {1, 2, 3, 5, 6, 8}));
    }

    public static List<String> summaryRanges(final int[] sums) {
        final List<String> ranges = new ArrayList<>();
        if(sums.length == 0){
            return ranges;
        }
        int left = sums[0];
        int right = sums[0];
        int index = 0;
        while(++index < sums.length) {
            if(sums[index-1] != sums[index] - 1) {
                ranges.add("" + left + (right > left ? "->" + right : ""));
                left = sums[index];
            } else {
                right = sums[index];
            }
        }
        ranges.add("" + left + (right > left ? "->" + right : ""));
        return ranges;
    }
}

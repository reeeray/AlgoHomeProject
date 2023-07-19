package leetcode.arrays;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 19.07.2023
 **/
public class NonOverlappingIntervals_435 {

    public static void main(String[] args) {

    }

    public int eraseOverlappingIntervals(final int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int border = Integer.MIN_VALUE;
        int answer = 0;

        for(int i=0; i<intervals.length; i++) {
            if(intervals[i][0] >= border) {
                border = intervals[i][1];
            } else {
                answer++;
            }
        }

        return answer;
    }
}

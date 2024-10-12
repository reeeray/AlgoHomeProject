package leetcode.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 12.10.2024
 **/
public class DivideIntervalsIntoMinNumberOfGroups_2406 {

    public static void main(String[] args) {

    }

    //Time O(nlogn) and Space O(n)
    public static int minGroups(final int[][] intervals) {
        final List<int[]> events = new ArrayList<>();
        for(final int[] interval : intervals) {
            events.add(new int[] {interval[0], 1});
            events.add(new int[] {interval[1] + 1, -1});
        }

        Collections.sort(events, (a, b) -> {
            if(a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int intersectedIntervals = 0;
        int maxIntersectedIntervals = 0;
        for(final int[] event : events) {
            intersectedIntervals += event[1];
            maxIntersectedIntervals = Math.max(intersectedIntervals, maxIntersectedIntervals);
        }
        return maxIntersectedIntervals;
    }
}

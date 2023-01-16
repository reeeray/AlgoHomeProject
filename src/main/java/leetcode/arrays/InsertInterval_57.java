package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 16.01.2023
 **/
public class InsertInterval_57 {

    public static void main(String[] args) {
        final int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
//        Arrays.toString(insertInterval(intervals, new int[]{4, 8}));
        Arrays.toString(insertInterval(new int[][]{{3,5}, {12,15}}, new int[]{6, 6}));

    }


    private static int[][] insertInterval(final int[][] intervals, final int[] newInterval) {
        final List<String> newIntervals = new ArrayList<>();
        Integer start = null;
        Integer end = null;
        boolean done = false;
        if(intervals.length == 0 || newInterval[1] < intervals[0][0]) {
            newIntervals.add("" + newInterval[0] + ";" + newInterval[1]);
            done = true;
        }
        for(final int[] interval : intervals) {
            if(done) {
                newIntervals.add("" + interval[0] + ";" + interval[1]);
                continue;
            }
            if(start == null && interval[1] < newInterval[0]) {
                newIntervals.add("" + interval[0] + ";" + interval[1]);
            }else if (start == null){
                if(newInterval[1] < interval[0]) {
                    newIntervals.add("" + newInterval[0] + ";" + newInterval[1]);
                    newIntervals.add("" + interval[0] + ";" + interval[1]);
                    done = true;
                    continue;
                }
                start = Math.min(newInterval[0], interval[0]);
                if(newInterval[1] <= interval[1]) {
                    end = interval[1];
                    newIntervals.add("" + start + ";" + end);
                    done = true;
                }
            } else {
                if(interval[1] >= newInterval[1]) {
                    if(interval[0] <= newInterval[1]) {
                        end = interval[1];
                        newIntervals.add("" + start + ";" + end);
                        done = true;
                    } else {
                        end = newInterval[1];
                        newIntervals.add("" + start + ";" + end);
                        newIntervals.add("" + interval[0] + ";" + interval[1]);
                        done = true;
                    }
                }
            }
        }
        if(!done) {
            start = start == null ? newInterval[0] : start;
            newIntervals.add("" + start + ";" + newInterval[1]);
        }
        final int[][] res = new int[newIntervals.size()][2];
        for(int i=0; i<newIntervals.size(); i++) {
            res[i][0] = Integer.valueOf(newIntervals.get(i).split(";")[0]);
            res[i][1] = Integer.valueOf(newIntervals.get(i).split(";")[1]);
        }
        return res;
    }
}

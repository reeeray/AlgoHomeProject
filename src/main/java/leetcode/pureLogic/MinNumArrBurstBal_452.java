package leetcode.pureLogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 05.01.2023
 **/
public class MinNumArrBurstBal_452 {

    public static void main(String[] args) {
        final int[][] balloons = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};

        assert 2 == findMinArrowShots(balloons);
    }

    private static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int arrow=1;
        int end=points[0][1];
        for(int i=1;i<points.length;i++){
            if(points[i][0]>end){
                arrow++;
                end=points[i][1];
            }
        }
        return arrow;
//        final List<List<Integer>> intersections = new ArrayList<>();
//
//        for(final int[] bal : points) {
//            boolean changed = false;
//            for(List<Integer> rang : intersections) {
//                final int leftR = rang.get(0);
//                final int rightR = rang.get(1);
//                if((leftR >= bal[0] && leftR <= bal[1]) || (rightR >= bal[0] && rightR <= bal[1]) || leftR==bal[1] || rightR==bal[0]) {
//                    rang.set(0, Math.max(leftR, rang.get(0)));
//                    rang.set(1, Math.min(rightR, rang.get(1)));
//                    changed = true;
//                    break;
//                }
//            }
//            if(!changed) {
//                final List<Integer> range = new ArrayList<>();
//                range.add(bal[0]);
//                range.add(bal[1]);
//                intersections.add(range);
//            }
//        }
//        return intersections.size();
    }
}

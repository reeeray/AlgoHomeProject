package leetcode.pureLogic;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 21.12.2023
 **/
public class WidestVerticalAreaBtwTwoPoints_1637 {

    public static void main(String[] args) {

    }

    public int maxWidthOfVerticalArea(final int[][] points) {
//        final int[] x = new int[points.length];
//        for(int i = 0; i<points.length; i++) {
//            x[i] = points[i][0];
//        }
//        Arrays.sort(x);
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int max = 0;
        for(int i=1; i<points.length; i++) {
            max = Math.max(points[i][0] - points[i-1][0], max);
        }
        return max;
    }
}

package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 03.12.2023
 **/
public class MinTimeVisitingAllPoints_1266 {

    public static void main(String[] args) {

    }

    public static int minTimeToVisitAllPoints(final int[][] points) {
        int total = 0;
        for(int i=0; i<points.length-1; i++) {
            total += Math.max(Math.abs(points[i+1][0] - points[i][0]), Math.abs(points[i+1][1] - points[i][1]));
        }
        return total;
    }
}

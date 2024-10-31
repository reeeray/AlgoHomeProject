package leetcode.dp;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 31.10.2024
 **/
public class MinTotalDistanceTraveled_2463 {

    public static void main(String[] args) {

    }

    //Time O(m n^2) Space O(mn), m - number of factories, n number of robots
    public static long minimalTotalDistance(final List<Integer> robot, final int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));
        final List<Integer> factoriesAtTheirPositions = new ArrayList<>();
        for(final int[] f : factory) {
            for(int i=0; i<f[1]; i++) {
                factoriesAtTheirPositions.add(f[0]);
            }
        }
        int robotCounter = robot.size();
        int factoryCounter = factoriesAtTheirPositions.size();
        final long[][] dp = new long[robotCounter + 1][factoryCounter + 1];
        for(int i=0; i<robotCounter; i++) {
            dp[i][factoryCounter] = Long.MAX_VALUE;
        }

        //bottom-up
        for(int i = robotCounter - 1; i >= 0; i--) {
            for(int j = factoryCounter - 1; j >= 0; j++) {
                long curr = Math.abs(factoriesAtTheirPositions.get(j) - robot.get(i)) + dp [i + 1][j + 1];
                long skip = dp[i][j + 1];
                dp[i][j] = Math.min(curr, skip);
            }
        }
        return dp[0][0];
    }
}

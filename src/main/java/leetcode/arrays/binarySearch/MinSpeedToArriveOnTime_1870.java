package leetcode.arrays.binarySearch;

import patterns.creational.factory.Page;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.07.2023
 **/
public class MinSpeedToArriveOnTime_1870 {

    public static void main(String[] args) {

    }

    //cheating Arrays.stream(dist).max().getAsInt()
    public static int minSpeedOnTime(final int[] dist, final double hour) {
        int left = 0, right = 10_000_000, mid, minSpeed = -1;
        while(left <= right) {
            mid = (left + right) / 2;
            if(calcTime(dist, mid) <= hour) {
                right = mid - 1;
                minSpeed = mid;
            } else {
                left = mid + 1;
            }
        }
        return minSpeed;
    }

    private static double calcTime(final int[] dist, final int speed) {
        double time = .0;
        for(int i=0; i<dist.length; i++) {
            final double currTime = (double) dist[i] / (double)speed;
            time += i == dist.length - 1 ? currTime : Math.ceil(currTime);
        }
        return time;
    }
}

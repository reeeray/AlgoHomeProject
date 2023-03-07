package leetcode.collections;

import patterns.creational.factory.Page;

import java.util.HashMap;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 07.03.2023
 **/
public class MinTimeToCompleteTrips_2187 {

    public static void main(String[] args) {
        minimumTime(new int[]{5, 10, 10}, 9);
    }

    private static long minimumTime(final int[] time, int totalTrips) {
        final Map<Integer, Integer> timeBus = new HashMap<>();
        for(int t : time) {
            timeBus.put(t, timeBus.getOrDefault(t, 0) + 1);
        }
        int min = 0;
        int max = time[0] * totalTrips;
        while (min < max) {
            int mid = min + (max-min)/2;
            long trips = calc(timeBus, mid);
            if(trips < totalTrips) {
                min = mid + 1;
            }else {
                max = mid;
            }
        }
        return min;
    }

    private static long calc(final Map<Integer, Integer> tripBus, final int time) {
        long trips = 0;
        for(int tripTime : tripBus.keySet()) {
            if(tripTime <= time) {
                trips += tripBus.get(tripTime) * (time/tripTime);
            }
        }

        return trips;
    }

    private static long minimumTimeBr(final int[] time, final int totalTrips) {
        long min = 0;
        long max = 100000000000000L;

        while(min < max) {
            long mid = (min + max)/2;
            long trips = 0;
            for(int t : time) {
                trips += mid/t;
            }
            if(trips < totalTrips) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }
}

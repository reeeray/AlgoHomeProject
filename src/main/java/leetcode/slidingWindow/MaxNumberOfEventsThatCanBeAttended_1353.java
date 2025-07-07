package leetcode.slidingWindow;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 07.07.2025
 **/
public class MaxNumberOfEventsThatCanBeAttended_1353 {

    public static void main(String[] args) {

    }


    //Time O(nlogn) and Space O(n)
    public static int maxEventsGreedy(final int[][] events) {
        int maxDay = 0;
        for(final int[] event : events) {
            maxDay = Math.max(maxDay, event[1]);
        }
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;
        for(int i = 1, j = 0; i <= maxDay; i++) {
            while(j < events.length && events[j][0] <= i) {
                pq.offer(events[j++][1]);
            }
            while (!pq.isEmpty() && pq.peek() < i) {
                pq.poll();
            }
            if(!pq.isEmpty()) {
                pq.poll();
                res++;
            }
        }
        return res;
    }

    //doesn't work
    public static int maxEvents(final int[][] events) {
        Arrays.sort(events, (a, b) -> {
            if(a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        int firstFreeDay = 1;
        int count = 0;
        for(final int[] event : events) {
            if(firstFreeDay <= event[1]) {
                firstFreeDay = Math.max(event[0], firstFreeDay) + 1;
                count++;
            }
        }
        return count;
    }
}

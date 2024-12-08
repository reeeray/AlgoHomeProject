package leetcode.structures;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 08.12.2024
 **/
public class TwoBestNonOverlappingEvents_2054 {

    public static void main(String[] args) {
        final int[][] input = new int[][] {{1, 3, 2}, {4, 5, 2}, {2, 4, 3}};
        maxTwoEvents(input);
    }

    //TLE Time O(n^2) Space O(n)
    public static int maxTwoEvents(final int[][] events) {
        final Map<Integer, List<int[]>> startMap = new HashMap<>();
        int maxStartTime = Integer.MIN_VALUE;
        for(final int[] event : events) {
            startMap.computeIfAbsent(event[0], v -> new ArrayList<>());
            startMap.get(event[0]).add(event);
            maxStartTime = Math.max(maxStartTime, event[0]);
        }
        int maxScore = -1;
        for(final int[] event : events) {
            int score = event[2];
            for(int i=event[1] + 1; i<=maxStartTime; i++) {
                for(final int[] secondEvent : startMap.getOrDefault(i, Collections.emptyList())) {
                    maxScore = Math.max(maxScore, score + secondEvent[2]);
                }
            }
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
    }

    //Time O(nlogn) because of sorting, Space(n)
    public static int maxTwoEventsQueue(final int[][] events) {
        final PriorityQueue<Pair<Integer, Integer>> previousEvents = new PriorityQueue<>(
                Comparator.comparingInt(Pair::getLeft)
        );
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        int ans = -1;
        int maxvalue = 0;
        for(final int[] event : events) {
            while(!previousEvents.isEmpty() && previousEvents.peek().getLeft() < event[0]) {
                maxvalue = Math.max(maxvalue, previousEvents.poll().getRight());
            }
            ans = Math.max(ans, event[2] + maxvalue);
            previousEvents.add(new Pair<>(event[1], event[2]));
        }
        return ans;
    }

    //Time O(nlogn) because of sorting and Space O(n)
    public static int maxTwiEventsQueueAxisRepresentation(final int[][] events) {
        final List<int[]> axisRepresentation = new ArrayList<>();
        for(final int[] event : events) {
            //starts masrk as 1s and end times mark as 0s, to be able to put them after finish events after sorting
            axisRepresentation.add(new int[] {event[0], 1, event[2]});
            axisRepresentation.add(new int[] {event[1] + 1, 0, event[2]});
        }
        axisRepresentation.sort((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        int ans = -1;
        int maxValue = 0;
        for(final int[] checkMark : axisRepresentation) {
            if(checkMark[1] == 1) {
                ans = Math.max(ans, checkMark[2] + maxValue);
            } else {
                maxValue = Math.max(maxValue, checkMark[2]);
            }
        }
        return ans;
    }

    //Complexity is the same O(nlogn) and O(n) but i even didn't try to figure out
    public int maxTwoEventsDP(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int[][] dp = new int[events.length][3];
        for (int[] d : dp) Arrays.fill(d, -1);
        return findEvents(events, 0, 0, dp);
    }

    // Recursive function to find the greatest sum for the pairs.
    int findEvents(int[][] events, int idx, int cnt, int[][] dp) {
        if (cnt == 2 || idx >= events.length) return 0;
        if (dp[idx][cnt] == -1) {
            int end = events[idx][1];
            int lo = idx + 1, hi = events.length - 1;
            while (lo < hi) {
                int mid = lo + ((hi - lo) >> 1);
                if (events[mid][0] > end) hi = mid;
                else lo = mid + 1;
            }
            int include =
                    events[idx][2] +
                            (lo < events.length && events[lo][0] > end
                                    ? findEvents(events, lo, cnt + 1, dp)
                                    : 0);
            int exclude = findEvents(events, idx + 1, cnt, dp);
            dp[idx][cnt] = Math.max(include, exclude);
        }
        return dp[idx][cnt];
    }
}

package leetcode.algos;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 08.05.2025
 **/
public class FindMinTimeToReachLastRoomII_3342 {

    public static void main(String[] args) {

    }

    //Time O(nmlognm) and Space O(nm)
    public static int minTimeToReach(final int[][] moveTime) {
        //as a structure used 4length array where arr[0] x coordinate, arr[1] y coordinate, arr[2] min time reaching this coordinate, arr[3] - time to reach next coordinate
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        final int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        final int n = moveTime.length, m = moveTime[0].length;
        final int[][] reachTimes = new int[n][m];
        final boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(reachTimes[i], Integer.MAX_VALUE);
        }
        reachTimes[0][0] = 0;
        pq.offer(new int[] {0, 0, 0, 1});
        while (!pq.isEmpty()) {
            final int[] currPosition = pq.poll();
            if(visited[currPosition[0]][currPosition[1]]) {
                continue;
            }
            visited[currPosition[0]][currPosition[1]] = true;
            for(final int[] dir : dirs) {
                final int nextX = currPosition[0] + dir[0];
                final int nextY = currPosition[1] + dir[1];
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                    continue;
                }
                final int possibleDistance = Math.max(reachTimes[currPosition[0]][currPosition[1]], moveTime[nextX][nextY]) + currPosition[3];
                if(reachTimes[nextX][nextY] > possibleDistance) {
                    reachTimes[nextX][nextY] = possibleDistance;
                    pq.offer(new int[]{nextX, nextY, possibleDistance, currPosition[3]%2 + 1});
                }

            }
        }
        return reachTimes[n - 1][m - 1];
    }
}

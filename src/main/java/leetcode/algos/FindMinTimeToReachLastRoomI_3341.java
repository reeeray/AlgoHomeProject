package leetcode.algos;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 07.05.2025
 **/
public class FindMinTimeToReachLastRoomI_3341 {

    public static void main(String[] args) {

    }

    //Time O(nmlognm) and Space O(nm)
    public static int minTimeToReach(final int[][] moveTime) {
        final int n = moveTime.length, m = moveTime[0].length;
        final int[][] distances = new int[n][m];
        final boolean[][] visited = new boolean[n][m];
        final int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        //int[] arr length 3 represents arr[0] - x, arr[1] - y, arr[2] - distance
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[] {0, 0, 0});
        for(int i = 0; i < n; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }
        distances[0][0] = 0;
        while (!pq.isEmpty()) {
            final int[] currentState = pq.poll();
            if(visited[currentState[0]][currentState[1]]) {
                continue;
            }
            visited[currentState[0]][currentState[1]] = true;
            for(final int[] dir : dirs) {
                final int newX = currentState[0] + dir[0];
                final int newY = currentState[1] + dir[1];
                if(newX < 0 || newX >= n || newY < 0 || newY >= m) {
                    continue;
                }
                final int distance = Math.max(distances[currentState[0]][currentState[1]], moveTime[newX][newY]) + 1;
                if(distances[newX][newY] > distance) {
                    distances[newX][newY] = distance;
                    pq.offer(new int[]{newX, newY, distance});
                }
            }
        }
        return distances[n - 1][m - 1];
    }

}

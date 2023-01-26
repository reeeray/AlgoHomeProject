package leetcode.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 25.01.2023
 **/
public class FindClosesNodeToGivenTwoNodes_2359 {

    public static void main(String[] args) {

    }

    private static int closestMeetingNodeViaDFS(final int[] edges, final int node1, final int node2) {
        final int n = edges.length;
        final int[] dist1 = new int[n], dist2 = new int[n];
        final boolean[] visited1 = new boolean[n], visited2 = new boolean[n];

        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        dist1[node1] = 0;
        dist2[node2] = 0;
        Arrays.fill(visited1, false);
        Arrays.fill(visited2, false);

        dfs(node1, edges, dist1, visited1);
        dfs(node2, edges, dist2, visited2);

        int minDistNode = -1, minDistTillNow = Integer.MAX_VALUE;
        for(int curr = 0; curr<n; curr++) {
            int minMaxDist = Math.max(dist1[curr], dist2[curr]);
            if(minDistTillNow > minMaxDist) {
                minDistTillNow = minMaxDist;
                minDistNode = curr;
            }
        }
        return minDistNode;
    }

    private static void dfs(final int node, final int[] edges, final int[] dist, final boolean[] visited) {
        visited[node] = true;
        final int neighbour = edges[node];
        if(neighbour != -1 && !visited[neighbour]) {
            dist[neighbour] = dist[node] + 1;
            dfs(neighbour, edges, dist, visited);
        }
    }

    private static int closestMeetingNodeViaBFS(final int[] edges, final int node1, final int node2) {
        final int n = edges.length;
        final int[] dist1 = new int[n], dist2 = new int[n];

        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        dist1[node1] = 0;
        dist2[node2] = 0;

        bfs(node1, edges, dist1);
        bfs(node2, edges, dist2);

        int minDistNode = -1, minDistTillNow = Integer.MAX_VALUE;
        for(int curr = 0; curr<n; curr++) {
            int minMaxDist = Math.max(dist1[curr], dist2[curr]);
            if(minDistTillNow > minMaxDist) {
                minDistTillNow = minMaxDist;
                minDistNode = curr;
            }
        }
        return minDistNode;
    }

    private static void bfs(final int node, final int[] edges, final int[] dist) {
        final int n = edges.length;
        final boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        final Queue<Integer> nodes = new LinkedList<>();
        nodes.offer(node);

        while(!nodes.isEmpty()) {
            final int curr = nodes.poll();
            final int neighbour = edges[curr];
            visited[curr] = true;

            if(neighbour != -1 && !visited[neighbour]) {
                nodes.offer(neighbour);
                dist[neighbour] = dist[curr] + 1;
            }
        }
    }
}

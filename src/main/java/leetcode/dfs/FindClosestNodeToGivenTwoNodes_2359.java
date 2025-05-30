package leetcode.dfs;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 30.05.2025
 **/
public class FindClosestNodeToGivenTwoNodes_2359 {

    public static void main(String[] args) {

    }

    public static int closestMeetingNode(final int[] edges, final int node1, final int node2) {
        final int n = edges.length;
        final int[] dist1 = new int[n], dist2 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        dist1[node1] = 0;
        dist2[node2] = 0;

        final boolean[] visit1 = new boolean[n], visit2 = new boolean[n];

        dfs(node1, edges, dist1, visit1);
        dfs(node2, edges, dist2, visit2);

        int minDistNode = -1, minDistTillNow = Integer.MAX_VALUE;
        for (int currNode = 0; currNode < n; currNode++) {
            if (minDistTillNow > Math.max(dist1[currNode], dist2[currNode])) {
                minDistNode = currNode;
                minDistTillNow = Math.max(dist1[currNode], dist2[currNode]);
            }
        }

        return minDistNode;
    }

    public static void dfs(final int node, final int[] edges, final int[] dist, final boolean[] visit) {
        visit[node] = true;
        final int neighbor = edges[node];
        if (neighbor != -1 && !visit[neighbor]) {
            dist[neighbor] = 1 + dist[node];
            dfs(neighbor, edges, dist, visit);
        }
    }
}

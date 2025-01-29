package leetcode.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 29.01.2025
 **/
public class RedundantConnection_684 {

    public static void main(String[] args) {
        final int[][] input = new int[][] {{9,10},{5,8},{2,6},{1,5},{3,8},{4,9},{8,10},{4,10},{6,8},{7,9}};
        findRedundantConnection(input);
    }

    //Time O(n^2) and Space O(n)
    public int[] findRedundantConnectionDFS(final int[][] edges) {
        final int n = edges.length;
        final List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (final int[] edge : edges) {
            final boolean[] visited = new boolean[n];
            // If DFS returns true, we will return the edge.
            if (isConnected(edge[0] - 1, edge[1] - 1, visited, adjList)) {
                return new int[] { edge[0], edge[1] };
            }
            adjList[edge[0] - 1].add(edge[1] - 1);
            adjList[edge[1] - 1].add(edge[0] - 1);
        }

        return new int[] {};
    }

    // Performs DFS and returns true if there's a path between src and target.
    private boolean isConnected(final int src, final int target, final boolean[] visited, final List<Integer>[] adjList) {
        visited[src] = true;
        if (src == target) {
            return true;
        }
        boolean isFound = false;
        for (int adj : adjList[src]) {
            if (!visited[adj]) {
                isFound = isFound || isConnected(adj, target, visited, adjList);
            }
        }

        return isFound;
    }

    //not correct understanding of requirements
    public static int[] findRedundantConnection(final int[][] edges) {
        final int n = edges.length;
        final boolean[] visited = new boolean[n];
        final int[] ans = new int[2];
        for(final int[] edge : edges) {
            if(visited[edge[0] - 1] && visited[edge[1] - 1]) {
                ans[0] = edge[0];
                ans[1] = edge[1];
            }
            visited[edge[0] - 1] = true;
            visited[edge[1] - 1] = true;
        }
        return ans;
    }
}

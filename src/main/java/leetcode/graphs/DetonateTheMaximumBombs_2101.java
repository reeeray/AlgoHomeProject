package leetcode.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 02.06.2023
 **/
public class DetonateTheMaximumBombs_2101 {

    public static void main(String[] args) {

    }

    public int maximumDetonation(final int[][] bombs) {
        final int n = bombs.length;
        final List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
            for(int j=0; j<n; j++) {
                if(i != j) { // it should be r^2 >= x^2 + y^2
                    long x1 = bombs[i][0];
                    long y1 = bombs[i][1];
                    long r1 = bombs[i][2];
                    long x = bombs[j][0];
                    long y = bombs[j][1];
                    long distanceSq = (x - x1) * (x - x1) + (y - y1) * (y - y1);
                    if (distanceSq <= r1 * r1) {
                        graph.get(i).add(j);
                    }
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            final int[] count = new int[1];
            final boolean[] visited = new boolean[n];
            dfs(graph, visited, i, count);
            ans = Math.max(ans, count[0]);
        }
        return ans;
    }

    private void dfs(final List<List<Integer>> graph, final boolean[] visited, final int node, final int[] count) {
        visited[node] = true;
        count[0]++;
        for(int neighbour : graph.get(node)) {
            if(!visited[neighbour]) {
                dfs(graph, visited, neighbour, count);
            }
        }
    }

}

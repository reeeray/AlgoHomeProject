package leetcode.algos;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 27.01.2026
 **/
public class MinCostPathWithEdgeReversals_3650 {

    public static void main(String[] args) {

    }

    //Time O(n + mlogm) and Space O(n + m) where n - number of vertices and m number of edges
    public static int minCost(final int n, final int[][] edges) {
        final List<int[]>[] nodes = new ArrayList[n];
        for(int i = 0; i < n; i ++) {
            nodes[i] = new ArrayList<>();
        }
        for(final int[] edge : edges) {
            nodes[edge[0]].add(new int[] {edge[1], edge[2]});
            nodes[edge[1]].add(new int[] {edge[0], 2 * edge[2]});
        }

        //Dijkstra
        final int[] minWeight = new int[n];
        final boolean[] visited = new boolean[n];
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Arrays.fill(minWeight, Integer.MAX_VALUE);
        minWeight[0] = 0;
        pq.offer(new int[] {0, 0});
        while (!pq.isEmpty()) {
            final int[] curr = pq.poll();
            if(curr[0] == (n - 1)) {
                return curr[1];
            }
            if(visited[curr[0]]) {
                continue;
            }
            visited[curr[0]] = true;
            for(final int[] neighbour : nodes[curr[0]]) {
                if(curr[1] + neighbour[1] < minWeight[neighbour[0]]) {
                    minWeight[neighbour[0]] = curr[1] + neighbour[1];
                    pq.offer(new int[] {neighbour[0], minWeight[neighbour[0]]});
                }
            }
        }
        return -1;
    }
}

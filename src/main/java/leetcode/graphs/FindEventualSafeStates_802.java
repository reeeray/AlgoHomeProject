package leetcode.graphs;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 24.01.2025
 **/
public class FindEventualSafeStates_802 {

    public static void main(String[] args) {

    }

    //Time O(m + n) where n - number nodes and m - number of edges, and spaces O(n)
    public static List<Integer> eventualSafeNodes(final int[][] graph) {
        final boolean[] looping = new boolean[graph.length];
        final boolean[] visited = new boolean[graph.length];
        for (int i=0; i<graph.length; i++) {
            dfs(i, visited, looping, graph);
        }
        final List<Integer> leadToterminal = new ArrayList<>();
        for(int i=0; i<graph.length; i++) {
            if(!looping[i]) {
                leadToterminal.add(i);
            }
        }
        return leadToterminal;
    }

    private static boolean dfs(final int node, final boolean[] visited, final boolean[] looping, final int[][] edges) {
        if(looping[node]) {
            return true;
        }
        if(visited[node]) {
            return false;
        }

        visited[node] = true;
        looping[node] = true;

        for(final int n : edges[node]) {
            if(dfs(n, visited, looping, edges)) {
                return true;
            }
        }
        looping[node] = false;
        return false;
    }
}

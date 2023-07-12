package leetcode.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 12.07.2023
 **/
public class FindEventualEndStates_802 {

    public static void main(String[] args) {

    }

    public static List<Integer> eventualSafeNodes(final int[][] graph) {
        final int n = graph.length;
        final List<List<Integer>> routes = new ArrayList<>();
        for(int i=0; i<n; i++) {
            routes.add(new ArrayList<>());
            for(int j=0; j<graph[i].length; j++) {
                routes.get(i).add(graph[i][j]);
            }
        }

        final boolean[] visited = new boolean[n];
        final boolean[] notSafe = new boolean[n];
        for(int i=0; i<n; i++) {
            dfs(routes, i, visited, notSafe);
        }

        final List<Integer> safe = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(!notSafe[i]) {
                safe.add(i);
            }
        }
        return safe;
    }

    private static boolean dfs(final List<List<Integer>> routes, final int node, final boolean[] visited, final boolean[] notSafe) {
        if(notSafe[node]) {
            return true;
        }

        if(visited[node]) {
            return false;
        }

        visited[node] = true;
        notSafe[node] = true;
        for(int i=0; i<routes.get(node).size(); i++) {
            if(dfs(routes, routes.get(node).get(i), visited, notSafe)) {
                return true;
            }
        }
        notSafe[node] = false;
        return false;
    }
}

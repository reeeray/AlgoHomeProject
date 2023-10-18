package leetcode.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 18.10.2023
 **/
public class ParallelCourses_2050 {

    Map<Integer, List<Integer>> graph;
    Map<Integer, Integer> memo;

    public int minimumTime(int n, int[][] relations, int[] time) {
        graph = new HashMap<>();
        memo = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : relations) {
            int x = edge[0] - 1;
            int y = edge[1] - 1;
            graph.get(x).add(y);
        }

        int ans = 0;
        for (int node = 0; node < n; node++) {
            ans = Math.max(ans, dfs(node, time));
        }

        return ans;
    }

    public int dfs(final int node, final int[] time) {
        if (memo.containsKey(node)) {
            return memo.get(node);
        }

        if (graph.get(node).size() == 0) {
            return time[node];
        }

        int ans = 0;
        for (int neighbor: graph.get(node)) {
            ans = Math.max(ans, dfs(neighbor, time));
        }

        memo.put(node, time[node] + ans);
        return time[node] + ans;
    }
}

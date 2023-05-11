package leetcode.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 24.03.2023
 **/
public class ReorderRoutes_1466 {

    private static int dfs(List<List<Integer>> tree, boolean[] visited, int from) {
        int change = 0;
        visited[from] = true;
        for (Integer to : tree.get(from))
            if (!visited[Math.abs(to)])
                change += dfs(tree, visited, Math.abs(to)) + (to > 0 ? 1 : 0);
        return change;
    }
    public int minReorder(int n, int[][] connections) {
        final List<List<Integer>> tree = new ArrayList<>();
        for(int i = 0; i < n; ++i)
            tree.add(new ArrayList<>());
        for (int[] c : connections) {
            tree.get(c[0]).add(c[1]);
            tree.get(c[1]).add(-c[0]);
        }
        return dfs(tree, new boolean[n], 0);
    }
}

package leetcode.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 10.11.2023
 **/
public class RestoreTheArrayFromAdjacentPairs_1743 {

    private static final Map<Integer, List<Integer>> graph = new HashMap<>();

    public static void main(String[] args) {

    }


    public int[] restoreArray(int[][] adjacentPairs) {
        for (final int[] edge : adjacentPairs) {
            int x = edge[0];
            int y = edge[1];
            graph.computeIfAbsent(x, v -> new ArrayList<>());
            graph.computeIfAbsent(y, v -> new ArrayList<>());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        int root = 0;
        for (int num : graph.keySet()) {
            if (graph.get(num).size() == 1) {
                root = num;
                break;
            }
        }

        int[] ans = new int[graph.size()];
        dfs(root, Integer.MAX_VALUE, ans, 0);
        return ans;
    }

    private void dfs(final int node, final int prev, final int[] ans, final int i) {
        ans[i] = node;
        for (int neighbor : graph.get(node)) {
            if (neighbor != prev) {
                dfs(neighbor, node, ans, i + 1);
            }
        }
    }


}

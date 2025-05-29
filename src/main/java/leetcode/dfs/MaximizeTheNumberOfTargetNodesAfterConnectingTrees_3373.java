package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 29.05.2025
 **/
public class MaximizeTheNumberOfTargetNodesAfterConnectingTrees_3373 {

    public static void main(String[] args) {

    }

    //Time O(n + m) and Space O(n + m)
    public static int[] maxTargetNodes(final int[][] edges1, final int[][] edges2) {
        final int n = edges1.length + 1, m = edges2.length + 1;
        final int[] color1 = new int[n];
        final int[] color2 = new int[m];
        final int[] count1 = build(edges1, color1);
        final int[] count2 = build(edges2, color2);
        final int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = count1[color1[i]] + Math.max(count2[0], count2[1]);
        }
        return res;
    }

    private static int[] build(final int[][] edges, final int[] color) {
        final int n = edges.length + 1;
        final List<List<Integer>> children = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            children.add(new ArrayList<>());
        }
        for (final int[] edge : edges) {
            children.get(edge[0]).add(edge[1]);
            children.get(edge[1]).add(edge[0]);
        }
        int res = dfs(0, -1, 0, children, color);
        return new int[] { res, n - res };
    }

    private static int dfs(final int node, final int parent, final int depth,
            final List<List<Integer>> children, final int[] color) {
        int res = 1 - (depth % 2);
        color[node] = depth % 2;
        for (final int child : children.get(node)) {
            if (child == parent) {
                continue;
            }
            res += dfs(child, node, depth + 1, children, color);
        }
        return res;
    }
}

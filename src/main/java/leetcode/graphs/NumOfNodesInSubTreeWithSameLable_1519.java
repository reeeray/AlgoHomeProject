package leetcode.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 12.01.2023
 **/
public class NumOfNodesInSubTreeWithSameLable_1519 {

    public static void main(String[] args) {

    }


    private static int[] countSubTress(final int n, int[][] edges, final String labels) {
        final Map<Integer, List<Integer>> nodes = new HashMap<>();
        for(final int[] edge : edges) {
            nodes.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]);
            nodes.computeIfAbsent(edge[1], v -> new ArrayList<>()).add(edge[0]);
        }
        final int[] res = new int[labels.length()];
        dfs(0, -1, nodes, labels, res);
        return res;
    }

    private static int[] dfs(final int node, final int parent, final Map<Integer, List<Integer>> edges, final String labels, final int[] res) {
        final int[] nodeCounts = new int[26];
        nodeCounts[labels.charAt(node) - 'a'] = 1;

        if(!edges.containsKey(node)) {
            return nodeCounts;
        }
        for(final int edge : edges.get(node)) {
            if(edge == parent)
                continue;
            final int[] childCounts = dfs(edge, node, edges, labels, res);

            for(int i=0; i<26; i++) {
                nodeCounts[i] += childCounts[i];
            }
        }
        res[node] = nodeCounts[labels.charAt(node) - 'a'];
        return nodeCounts;
    }
}

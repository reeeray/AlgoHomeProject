package leetcode.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 11.01.2023
 **/
public class MinTimeToCollectAllAppels_1443 {

    public static void main(String[] args) {

    }


    private static int minTime(final int n, final int[][] edges, final List<Boolean> hasApples) {
        final Map<Integer, List<Integer>> tree = new HashMap<>();
        for(final int[] leaf : edges) {
            tree.computeIfAbsent(leaf[0], v -> new ArrayList<>()).add(leaf[1]);
            tree.computeIfAbsent(leaf[1], v -> new ArrayList<>()).add(leaf[0]);
        }
        return dfs(0, -1, tree, hasApples);
    }

    private static int dfs(final int node, final int parent, final Map<Integer, List<Integer>> edges, final List<Boolean> hasAppels) {
        if(!edges.containsKey(node)) {
            return 0;
        }

        int totalTime=0, childTime = 0;
        for(final int child : edges.get(node)) {
            if(child == parent)
                continue;
            childTime = dfs(child, node, edges, hasAppels);


            if(childTime > 0 || hasAppels.get(child)) {
                totalTime += childTime + 2;
            }
        }
        return totalTime;
    }
}

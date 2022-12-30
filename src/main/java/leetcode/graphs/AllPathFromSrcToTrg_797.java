package leetcode.graphs;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 30.12.2022
 **/
public class AllPathFromSrcToTrg_797 {

    public static void main(String[] args) {
        final int[][] graph = {{1, 2}, {3}, {3}, {}};
        allPathsSourceTarget(graph);
    }


    private static List<List<Integer>> allPathsSourceTarget(final int[][] graph) {
        final List<List<Integer>> answer = new ArrayList<>();
        dfs(graph, answer, 0, new HashSet<>());
        return answer;
    }

    private static void dfs(final int[][] graph, final List<List<Integer>> answer, final int level, final Set<Integer> path) {
        if(!path.add(level)) {
            return;
        }
        if(level == graph.length - 1) {
            answer.add(new ArrayList<>(path));
            return;
        }
        for(int node : graph[level]) {
            dfs(graph, answer, node, new LinkedHashSet<>(path));
        }
    }
}

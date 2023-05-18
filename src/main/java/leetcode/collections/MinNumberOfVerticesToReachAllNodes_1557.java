package leetcode.collections;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 18.05.2023
 **/
public class MinNumberOfVerticesToReachAllNodes_1557 {

    public static void main(String[] args) {

    }

    private static List<Integer> findSmallestSetOfVertices(final int n, final List<List<Integer>> edges) {
        final List<Integer> res = new ArrayList<>();
        final int[] visited = new int[n];
        for(final List<Integer> v : edges) {
            visited[v.get(1)] = 1;
        }

        for(int i=0; i<n; i++) {
            if(visited[i] == 0) res.add(i);
        }
        return res;
    }
}

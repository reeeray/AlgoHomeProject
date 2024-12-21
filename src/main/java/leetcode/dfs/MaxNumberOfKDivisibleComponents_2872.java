package leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 21.12.2024
 **/
public class MaxNumberOfKDivisibleComponents_2872 {

    public static void main(String[] args) {

    }

    //Time O(n + m) and Space O(n + m)
    public static int maxKDivisibleComponents(final int n, final int[][] edges, final int[] values, final int k) {
        final List<Integer>[] neighbours = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            neighbours[i] = new ArrayList<>();
        }
        for(final int[] edge : edges) {
            neighbours[edge[0]].add(edge[1]);
            neighbours[edge[1]].add(edge[0]);
        }
        final int[] answ = new int[1];
        dfs(0, -1, neighbours, values, k, answ);
        return answ[0];
    }

    private static int dfs(final int curr, final int parent, final List<Integer>[] neighbours, final int[] values, final int k, final int[] components) {
        int sum = 0;
        for(int neighbour : neighbours[curr]) {
            if(neighbour != parent) {
                sum += dfs(neighbour, curr, neighbours, values, k, components);
                sum %= k;
            }
        }
        sum += values[curr];
        sum %= k;
        if(sum == 0) {
            components[0]++;
        }
        return sum;
    }
}

package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.05.2025
 **/
public class LargestColorValueInADirectedGraph_1857 {

    public static void main(String[] args) {

    }

    public int largestPathValue(final String colors, final int[][] edges) {
        final int n = colors.length();
        final List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (final int[] e : edges)
            adj.get(e[0]).add(e[1]);

        final int[][] count = new int[n][26];
        final int[] vis = new int[n];
        int ans = 0;

        for (int i = 0; i < n && ans != Integer.MAX_VALUE; i++) {
            ans = Math.max(ans, dfs(i, colors, adj, count, vis));
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    //visited[i] == 0 - not visited, 1 - visiting, 2 - visited
    private int dfs(final int node, final String colors, final List<List<Integer>> adj, final int[][] count, final int[] visited) {
        if (visited[node] == 1)
            return Integer.MAX_VALUE;
        if (visited[node] == 2) {
            return count[node][colors.charAt(node) - 'a'];
        }

        visited[node] = 1;
        for (int nxt : adj.get(node)) {
            final int res = dfs(nxt, colors, adj, count, visited);
            if (res == Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            for (int c = 0; c < 26; c++) {
                count[node][c] = Math.max(count[node][c], count[nxt][c]);
            }
        }
        final int col = colors.charAt(node) - 'a';
        count[node][col]++;
        visited[node] = 2;

        return count[node][col];
    }
}

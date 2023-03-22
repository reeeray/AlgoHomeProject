package leetcode.trees;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 22.03.2023
 **/
public class MinScoreOfAPathBetween2Cities_2492 {

    public static void main(String[] args) {

    }

    public int minScore(int n, int[][] roads) {
        int ans = Integer.MAX_VALUE;
        List<List<Pair>> gr = new ArrayList<>();
        for(int i = 0; i < n+1; i++) {
            gr.add(new ArrayList<Pair>());
        }

        for(int[] edge : roads) {
            gr.get(edge[0]).add(new Pair(edge[1], edge[2])); // u-> {v, dis}
            gr.get(edge[1]).add(new Pair(edge[0], edge[2])); // v-> {u, dis}
        }

        int[] vis = new int[n+1];
        Arrays.fill(vis, 0);
        final Queue<Integer> q = new LinkedList<>();
        q.add(1);
        vis[1] = 1;
        while(!q.isEmpty()) {
            int node = q.poll();
            for(Pair pair : gr.get(node)) {
                int v = pair.getLeft();
                int dis = pair.getRight();
                ans = Math.min(ans, dis);
                if(vis[v]==0) {
                    vis[v] = 1;
                    q.add(v);
                }
            }
        }

        return ans;
    }

    private static class Pair {
        private int left;
        private int right;

        public Pair(final int left, final int right) {
            this.left = left;
            this.right = right;
        }

        public int getLeft() {
            return this.left;
        }

        public int getRight() {
            return this.right;
        }
    }
}

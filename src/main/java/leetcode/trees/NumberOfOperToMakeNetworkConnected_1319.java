package leetcode.trees;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 23.03.2023
 **/
public class NumberOfOperToMakeNetworkConnected_1319 {

    public static void main(String[] args) {

    }

    public static int makeConnected(final int n, final int[][] connections) {
        final boolean[] visited = new boolean[n];
        final Map<Integer, List<Integer>> connTree = new HashMap<>();
        int count = 0;
        for(int[] node : connections) {
            connTree.computeIfAbsent(node[0], v -> new ArrayList<>()).add(node[1]);
        }

        for(final Map.Entry<Integer, List<Integer>> entry : connTree.entrySet()) {
            visited[entry.getKey()] = true;
            for(final int child : entry.getValue()) {
                if(visited[child]) {
                    count++;
                } else {
                    visited[child] = true;
                }
            }
        }

        int toVisit = 0;
        for(boolean v : visited) {
            if(!v) {
                toVisit++;
            }
        }
        return count >= toVisit ? toVisit : -1;
    }

    public static int makeConnectedDFS(final int n, final int[][] connections) {
        if(connections.length < n-1) return -1;
        final List<Integer>[] connTree = new List[n];
        Arrays.fill(connTree, new ArrayList<>());
        for(final int[] node : connections) {
            connTree[node[0]].add(node[1]);
            connTree[node[1]].add(node[0]);
        }
        final boolean[] visited = new boolean[n];
        int components = 0;
        for(int node=0; node<n; node++) {
            if(!visited[node]) {
                dfs(node, connTree, visited);
                components++;
            }
        }
        return components - 1;
    }

    private static void dfs(final int node, final List<Integer>[] tree, final boolean[] visited) {
        visited[node] = true;
        for(final int n : tree[node]) {
            dfs(n, tree, visited);
        }
    }

    public int makeConnectedUnionWorks(int n, int[][] connections) {
        // if there are not enough cables than return -1 as  there should be minimum n-1 edges to connect n nodes
        if(connections.length < n-1)
            return -1;

        int[] parent = new int[n];
        int[] rank = new int[n];

        for(int i = 0; i<n; i++){
            parent[i] = i;
        }
        Arrays.fill(rank, 1);

        for(int i = 0; i< connections.length; i++){
            union(parent, rank, connections[i][0], connections[i][1]);
        }

        int countOfUnconnectedComputers =0;
        for(int i = 0; i< parent.length; i++){
            if(parent[i] == i)
                countOfUnconnectedComputers++;

        }
        countOfUnconnectedComputers--; // since one root will be there

        return countOfUnconnectedComputers;


    }

    private void union(int[] parent, int[] rank, int x, int y){
        int parentX = find(parent, x);
        int parentY = find(parent, y);

        if(parentX==parentY)
            return;

        if(rank[parentX] > rank[parentY]){
            parent[parentY] = parent[parentX];
        }else if(rank[parentX] < rank[parentY]){
            parent[parentX] = parent[parentY];
        }else{
            parent[parentY] = parent[parentX];
            rank[parentX]++;
        }

        return;

    }

    private int find(int[] parent, int x){
        if(parent[x] ==x)
            return x;

        return parent[x] = find(parent, parent[x]);
    }
}

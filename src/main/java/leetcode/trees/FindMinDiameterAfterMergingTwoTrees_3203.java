package leetcode.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 24.12.2024
 **/
public class FindMinDiameterAfterMergingTwoTrees_3203 {

    public static void main(String[] args) {
        final int[][] edges1 = new int[][]{{0,1},{0,2},{0,3}};
        final int[][] edges2 = new int[][]{{0,1}};
        minimumDiameterAfterMerge(edges1, edges2);
    }

    public static int minimumDiameterAfterMerge(final int[][] edges1, final int[][] edges2) {
        final Map<Integer, List<Integer>> neighbours1 = new HashMap<>();
        final Map<Integer, List<Integer>> neighbours2 = new HashMap<>();
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(final int[] node : edges1) {
            neighbours1.computeIfAbsent(node[0], k -> new ArrayList<>()).add(node[1]);
            neighbours1.computeIfAbsent(node[1], k -> new ArrayList<>()).add(node[0]);
        }
        for(final int[] node : edges2) {
            neighbours2.computeIfAbsent(node[0], k -> new ArrayList<>()).add(node[1]);
            neighbours2.computeIfAbsent(node[1], k -> new ArrayList<>()).add(node[0]);
        }
        for(int i=0; i<edges1.length; i++) {
            final int[] min = new int[1];
            dfs(neighbours1, i, -1, 0, min);
            min1 = Math.min(min1, min[0]);
        }
        for(int i=0; i<edges2.length; i++) {
            final int[] min = new int[1];
            dfs(neighbours2, i, -1, 0, min);
            min2 = Math.min(min2, min[0]);
        }
        if(min1 == Integer.MAX_VALUE) {
            min1 = 0;
        }
        if(min2 == Integer.MAX_VALUE) {
            min2 = 0;
        }
        return min1 + min2 + 1;
    }

    private static void dfs(final Map<Integer, List<Integer>> neighbours, final int curr, final int parent, final int depth, final int[] ans) {
        if(neighbours.get(curr).size() == 1 && parent != -1) {
            ans[0] = Math.max(ans[0], depth);
        }
        for(final int neighbour : neighbours.get(curr)) {
            if(neighbour == parent) {
                continue;
            }
            dfs(neighbours, neighbour, curr, depth + 1, ans);
        }
    }

    //Time O(n + m) and Space O(n + m)
    public int minimumDiameterAfterMergeOpt(int[][] edges1, int[][] edges2) {
        // Calculate the number of nodes for each tree (number of edges + 1)
        final int n = edges1.length + 1;
        final int m = edges2.length + 1;

        // Build adjacency lists for both trees
        final List<List<Integer>> adjList1 = buildAdjList(n, edges1);
        final List<List<Integer>> adjList2 = buildAdjList(m, edges2);

        // Calculate the diameter of both trees
        final int diameter1 = findDiameter(adjList1, 0, -1).getFirst(); // Start DFS for Tree 1
        final int diameter2 = findDiameter(adjList2, 0, -1).getFirst(); // Start DFS for Tree 2

        // Calculate the diameter of the combined tree
        int combinedDiameter =
                (int) Math.ceil(diameter1 / 2.0) +
                        (int) Math.ceil(diameter2 / 2.0) +
                        1;

        // Return the maximum diameter among the two trees and the combined tree
        return Math.max(Math.max(diameter1, diameter2), combinedDiameter);
    }

    // Helper function to build an adjacency list from an edge list
    private List<List<Integer>> buildAdjList(final int size, final int[][] edges) {
        final List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        return adjList;
    }

    // Helper function to find the diameter of a tree
    // Returns the diameter and the depth of the node's subtree
    private Pair findDiameter(final List<List<Integer>> adjList, final int node, final int parent) {
        int maxDepth1 = 0, maxDepth2 = 0; // Tracks the two largest depths from the current node
        int diameter = 0; // Tracks the diameter of the subtree

        for (int neighbor : adjList.get(node)) {
            if (neighbor == parent) continue; // Skip the parent to avoid cycles

            // Recursively calculate the diameter and depth of the neighbor's subtree
            final Pair result = findDiameter(adjList, neighbor, node);
            int childDiameter = result.getFirst();
            int depth = result.getSecond() + 1; // Increment depth to include edge to neighbor

            // Update the maximum diameter of the subtree
            diameter = Math.max(diameter, childDiameter);

            // Update the two largest depths from the current node
            if (depth > maxDepth1) {
                maxDepth2 = maxDepth1;
                maxDepth1 = depth;
            } else if (depth > maxDepth2) {
                maxDepth2 = depth;
            }
        }

        // Update the diameter to include the path through the current node
        diameter = Math.max(diameter, maxDepth1 + maxDepth2);

        // Return the diameter and the longest depth
        return new Pair(diameter, maxDepth1);
    }

    // Simple Pair class for storing results of the findDiameter function
    class Pair {

        private int first;
        private int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }
    }
}

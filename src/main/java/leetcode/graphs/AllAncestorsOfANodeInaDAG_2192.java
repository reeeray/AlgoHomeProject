package leetcode.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * DAG -directed acyclic graph
 * User : Shein G.A.{@reeeray}
 * Date : 29.06.2024
 **/
public class AllAncestorsOfANodeInaDAG_2192 {

    public static void main(String[] args) {

    }

    //n - number of vertices in the graph and m - length of edges array. Space O(n + m) and Time O(n*n + n*m)
    public List<List<Integer>> getAncestors(final int n, final int[][] edges) {
        // Initialize adjacency list for the graph
        final List<Integer>[] adjacencyList = new ArrayList[n];
        // Populate the adjacency list with reversed edges
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            if(adjacencyList[to] == null) {
                adjacencyList[to] = new ArrayList<>();
            }
            adjacencyList[to].add(from);
        }

        final List<List<Integer>> ancestorsList = new ArrayList<>();

        // For each node, find all its ancestors (children in reversed graph)
        for (int i = 0; i < n; i++) {
            final List<Integer> ancestors = new ArrayList<>();
            final Set<Integer> visited = new HashSet<>();
            findChildren(i, adjacencyList, visited);
            // Add visited nodes to the current nodes' ancestor list
            for (int node = 0; node < n; node++) {
                if (node == i) continue;
                if (visited.contains(node)) ancestors.add(node);
            }
            ancestorsList.add(ancestors);
        }

        return ancestorsList;
    }

    // Helper method to perform DFS and find all children of a given node
    private void findChildren(final int currentNode, final List<Integer>[] adjacencyList, final Set<Integer> visitedNodes) {
        // Mark current node as visited
        visitedNodes.add(currentNode);
        if(adjacencyList[currentNode] == null) {
            return;
        }

        // Recursively traverse all neighbors
        for (int neighbour : adjacencyList[currentNode]) {
            if (!visitedNodes.contains(neighbour)) {
                findChildren(neighbour, adjacencyList, visitedNodes);
            }
        }
    }
}

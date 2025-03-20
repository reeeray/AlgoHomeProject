package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 20.03.2025
 **/
public class MinCostWalkInWeightedGraph_3108 {

    public static void main(String[] args) {

    }

    int[] parent;
    int[] depth;

    public int[] minimumCostUnionFind(final int n, final int[][] edges, final int[][] queries) {
        // Initialize the parent array with -1 as initially each node belongs to its own component
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = -1;

        depth = new int[n];

        // All values are initially set to the number with only 1s in its binary representation
        int[] componentCost = new int[n];
        for (int i = 0; i < n; i++) {
            componentCost[i] = Integer.MAX_VALUE;
        }

        // Construct the connected components of the graph
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        // Calculate the cost of each component by performing bitwise AND of all edge weights in it
        for (int[] edge : edges) {
            int root = find(edge[0]);
            componentCost[root] &= edge[2];
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            // If the two nodes are in different connected components, return -1
            if (find(start) != find(end)) {
                answer[i] = -1;
            } else {
                // Find the root of the edge's component
                int root = find(start);
                // Return the precomputed cost of the component
                answer[i] = componentCost[root];
            }
        }
        return answer;
    }

    // Find function to return the root (representative) of a node's component
    private int find(final int node) {
        // If the node is its own parent, it is the root of the component
        if (parent[node] == -1) return node;
        // Otherwise, recursively find the root and apply path compression
        return parent[node] = find(parent[node]);
    }

    // Union function to merge the components of two nodes
    private void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);

        // If the two nodes are already in the same component, do nothing
        if (root1 == root2) return;

        // Union by depth: ensure the root of the deeper tree becomes the parent
        if (depth[root1] < depth[root2]) {
            int temp = root1;
            root1 = root2;
            root2 = temp;
        }

        // Merge the two components by making root1 the parent of root2
        parent[root2] = root1;

        // If both components had the same depth, increase the depth of the new root
        if (depth[root1] == depth[root2]) {
            depth[root1]++;
        }
    }

    //Time(n + m + q) and Space O(n + m) where n - number of nodes, m - number of edges and q - number of queries
    public int[] minimumCost(final int n, final int[][] edges, final int[][] queries) {
        // Create the adjacency list of the graph
        final List<List<int[]>> adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>(2));
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(new int[] { edge[1], edge[2] });
            adjList.get(edge[1]).add(new int[] { edge[0], edge[2] });
        }

        final boolean[] visited = new boolean[n];

        // Array to store the component ID of each node
        final int[] components = new int[n];
        final List<Integer> componentCost = new ArrayList<>(n);

        int componentId = 0;

        // Perform DFS for each unvisited node to identify components and calculate their costs
        for (int node = 0; node < n; node++) {
            // If the node hasn't been visited, it's a new component
            if (!visited[node]) {
                // Get the component cost and mark all nodes in the component
                componentCost.add(
                        getComponentCost(
                                node,
                                adjList,
                                visited,
                                components,
                                componentId
                        )
                );
                // Increment the component ID for the next component
                componentId++;
            }
        }

        final int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            if (components[start] == components[end]) {
                // If they are in the same component, return the precomputed cost for the component
                answer[i] = componentCost.get(components[start]);
            } else {
                // If they are in different components, return -1
                answer[i] = -1;
            }
        }

        return answer;
    }

    // Helper function to calculate the cost of a component using BFS
    private int getComponentCost(final int node, final List<List<int[]>> adjList, final boolean[] visited,
            final int[] components, final int componentId) {
        // Initialize the cost to the number that has only 1s in its
        // binary representation
        int currentCost = Integer.MAX_VALUE;

        // Mark the node as part of the current component
        components[node] = componentId;
        visited[node] = true;

        // Explore all neighbors of the current node
        for (int[] neighbor : adjList.get(node)) {
            final int weight = neighbor[1];

            // Update the cost by performing a bitwise AND of the edge
            // weights
            currentCost &= weight;

            if (!visited[neighbor[0]]) {
                // Recursively calculate the cost of the rest of the component
                // and accumulate it into currentCost
                currentCost &= getComponentCost(
                        neighbor[0],
                        adjList,
                        visited,
                        components,
                        componentId
                );
            }
        }

        return currentCost;
    }
}

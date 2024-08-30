package leetcode.graphs;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 30.08.2024
 **/
public class ModifyGraphEdgeWeights_2699 {

    private static final int MOD = (int) 2e9;

    public static void main(String[] args) {

    }


    //Traditional Dijkstra's algorithm
    //Time O(E*N^2) where E- number of edges, N - number of nodes and Space O(N^2)
    public int[][] modifiedGraphEdges(final int n, final int[][] edges, final int source, final int destination, final int target) {
        // Step 1: Compute the initial shortest distance from source to destination
        final long currentShortestDistance = runDijkstra(edges, n, source, destination);

        // If the current shortest distance is less than the target, return an empty result
        if (currentShortestDistance < target) return new int[0][0];

        boolean matchesTarget = (currentShortestDistance == target);

        // Step 2: Iterate through each edge to adjust its weight if necessary
        for (int[] edge : edges) {
            // Skip edges that already have a positive weight
            if (edge[2] > 0) continue;

            // Set edge weight to a large value if current distance matches target, else set to 1
            edge[2] = matchesTarget ? MOD : 1;

            // Step 3: If current shortest distance does not match target
            if (!matchesTarget) {
                // Compute the new shortest distance with the updated edge weight
                long newDistance = runDijkstra(edges, n, source, destination);
                // If the new distance is within the target range, update edge weight to match target
                if (newDistance <= target) {
                    matchesTarget = true;
                    edge[2] += target - newDistance;
                }
            }
        }

        // Return modified edges if the target distance is achieved, otherwise return an empty result
        return matchesTarget ? edges : new int[0][0];
    }

    // Dijkstra's algorithm to find the shortest path distance
    private long runDijkstra(final int[][] edges, final int n, final int source, final int destination) {
        // Step 1: Initialize adjacency matrix and distance arrays
        final long[][] adjMatrix = new long[n][n];
        final long[] minDistance = new long[n];
        final boolean[] visited = new boolean[n];

        Arrays.fill(minDistance, MOD);
        for (long[] row : adjMatrix) {
            Arrays.fill(row, MOD);
        }

        // Set the distance to the source node as 0
        minDistance[source] = 0;

        // Step 2: Fill the adjacency matrix with edge weights
        for (int[] edge : edges) {
            if (edge[2] != -1) {
                adjMatrix[edge[0]][edge[1]] = edge[2];
                adjMatrix[edge[1]][edge[0]] = edge[2];
            }
        }

        // Step 3: Perform Dijkstra's algorithm
        for (int i = 0; i < n; ++i) {
            // Find the nearest unvisited node
            int nearestUnvisitedNode = -1;
            for (int j = 0; j < n; ++j) {
                if (
                        !visited[j] &&
                                (nearestUnvisitedNode == -1 ||
                                        minDistance[j] < minDistance[nearestUnvisitedNode])
                ) {
                    nearestUnvisitedNode = j;
                }
            }
            // Mark the nearest node as visited
            visited[nearestUnvisitedNode] = true;

            // Update the minimum distance for each adjacent node
            for (int v = 0; v < n; ++v) {
                minDistance[v] = Math.min(
                        minDistance[v],
                        minDistance[nearestUnvisitedNode] +
                                adjMatrix[nearestUnvisitedNode][v]
                );
            }
        }

        // Return the shortest distance to the destination node
        return minDistance[destination];
    }
}

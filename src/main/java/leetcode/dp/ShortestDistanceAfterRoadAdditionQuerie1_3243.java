package leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 27.11.2024
 **/
public class ShortestDistanceAfterRoadAdditionQuerie1_3243 {

    public static void main(String[] args) {
        final int[][] input = new int[][] {{2, 4}, {0, 2}, {0, 4}};
        shortestDistanceAfterQueries(5, input);
    }

    // Recursive function to find the minimum distance from the current node to
    // the destination node (n-1)
    private int findMinDistance(final List<List<Integer>> adjList, final int n, final int currentNode, final int[] dp) {
        // We've reached the destination node
        if (currentNode == n - 1) return 0;

        // If this node has already been computed, return the stored value
        if (dp[currentNode] != -1) return dp[currentNode];

        int minDistance = n;

        for (int neighbor : adjList.get(currentNode)) {
            // Recursively find the minimum distance from the neighbor to the destination
            minDistance = Math.min(minDistance, findMinDistance(adjList, n, neighbor, dp) + 1);
        }

        // Store the computed minimum distance in the dp array and return it
        return dp[currentNode] = minDistance;
    }

    //Space O(n + q) and Time O(q(n + q))
    public int[] shortestDistanceAfterQueriesCorrect(int n, int[][] queries) {
        final int[] dp = new int[n];
        Arrays.fill(dp, -1);// DP array to store minimum distances from each node

        final List<List<Integer>> adjList = new ArrayList<>(n);

        // Initialize the graph with edges between consecutive nodes
        for (int i = 0; i < n; i++) {
            final List<Integer> list = new ArrayList<>();
            if(i < n - 1) {
                list.add(i + 1);
            }
            adjList.add(list); // Create a new list for each node
        }

        final List<Integer> answer = new ArrayList<>();

        // Process each query to add new edges
        for (int[] road : queries) {
            int u = road[0];
            int v = road[1];

            // Add the directed edge from u to v
            adjList.get(u).add(v);

            // Find the minimum distance from the starting node (0) to the destination (n-1)
            answer.add(findMinDistance(adjList, n, 0, dp));

            // Clear and reset the dp array
            Arrays.fill(dp, -1);
        }

        // Convert List<Integer> to int[] before returning

        return answer.stream().mapToInt(i -> i).toArray(); // Return the results for each query
    }

    public static int[] shortestDistanceAfterQueries(final int n, final int[][] queries) {
        final int[] paths = new int[n];
        final int[] ans = new int[queries.length];
        for(int i=0; i < n; i++) {
            paths[i] = n - 1 - i;
        }
        for(int i=0; i<queries.length; i++) {
            paths[queries[i][0]] = Math.min(paths[queries[i][0]], paths[queries[i][1]] + 1);
            ans[i] = queries[i][0] + paths[queries[i][0]];
        }
        return ans;
    }
}

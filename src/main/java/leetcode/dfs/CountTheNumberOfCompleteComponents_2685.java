package leetcode.dfs;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 22.03.2025
 **/
public class CountTheNumberOfCompleteComponents_2685 {

    public static void main(String[] args) {

    }

    public int countCompleteComponentsBFS(int n, int[][] edges) {
        // Create adjacency list representation of the graph
        List<Integer>[] graph = new ArrayList[n];
        for (int vertex = 0; vertex < n; vertex++) {
            graph[vertex] = new ArrayList<>();
        }

        // Build graph from edges
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] visited = new boolean[n];
        int completeComponents = 0;

        // Process each unvisited vertex
        for (int vertex = 0; vertex < n; vertex++) {
            if (!visited[vertex]) {
                // BFS to find all vertices in the current component
                List<Integer> component = new ArrayList<>();
                Queue<Integer> queue = new LinkedList<>();
                queue.add(vertex);
                visited[vertex] = true;

                while (!queue.isEmpty()) {
                    int current = queue.poll();
                    component.add(current);

                    // Process neighbors
                    for (int neighbor : graph[current]) {
                        if (!visited[neighbor]) {
                            queue.add(neighbor);
                            visited[neighbor] = true;
                        }
                    }
                }

                // Check if component is complete (all vertices have the right number of edges)
                boolean isComplete = true;
                for (int node : component) {
                    if (graph[node].size() != component.size() - 1) {
                        isComplete = false;
                        break;
                    }
                }

                if (isComplete) {
                    completeComponents++;
                }
            }
        }

        return completeComponents;
    }

    public int countCompleteComponentsDFS(int n, int[][] edges) {
        // Adjacency lists for each vertex
        List<Integer>[] graph = new ArrayList[n];

        // Initialize empty adjacency lists
        for (int vertex = 0; vertex < n; vertex++) {
            graph[vertex] = new ArrayList<>();
        }

        // Build adjacency lists from edges
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int completeCount = 0;
        Set<Integer> visited = new HashSet<>();

        // Process each unvisited vertex
        for (int vertex = 0; vertex < n; vertex++) {
            if (visited.contains(vertex)) continue;

            // arr[0] = vertices count, arr[1] = total edges count
            int[] componentInfo = new int[2];
            dfs(vertex, graph, visited, componentInfo);

            // Check if component is complete - edges should be vertices * (vertices-1)
            if (componentInfo[0] * (componentInfo[0] - 1) == componentInfo[1]) {
                completeCount++;
            }
        }
        return completeCount;
    }

    private void dfs(
            int curr,
            List<Integer>[] graph,
            Set<Integer> visited,
            int[] componentInfo
    ) {
        visited.add(curr);
        componentInfo[0]++; // Increment vertex count
        componentInfo[1] += graph[curr].size(); // Add edges from current vertex

        // Explore unvisited neighbors
        for (int next : graph[curr]) {
            if (!visited.contains(next)) {
                dfs(next, graph, visited, componentInfo);
            }
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        // Adjacency lists for each vertex
        final List<Integer>[] graph = new ArrayList[n];
        // Map to store frequency of each unique adjacency list
        final Map<List<Integer>, Integer> componentFreq = new HashMap<>();

        // Initialize adjacency lists with self-loops
        for (int vertex = 0; vertex < n; vertex++) {
            graph[vertex] = new ArrayList<>();
            graph[vertex].add(vertex);
        }

        // Build adjacency lists from edges
        for (final int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        // Count frequency of each unique adjacency pattern
        for (int vertex = 0; vertex < n; vertex++) {
            final List<Integer> neighbors = graph[vertex];
            Collections.sort(neighbors);
            componentFreq.put(
                    neighbors,
                    componentFreq.getOrDefault(neighbors, 0) + 1
            );
        }

        // Count complete components where size equals frequency
        int completeCount = 0;
        for (final Map.Entry<List<Integer>, Integer> entry : componentFreq.entrySet()) {
            if (entry.getKey().size() == entry.getValue()) {
                completeCount++;
            }
        }

        return completeCount;
    }
}

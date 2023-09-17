package leetcode.graphs;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 17.09.2023
 **/
public class ShirtestPathVisitingAllNodes_847 {

    public static void main(String[] args) {

    }


    public static int shortestPathLength(final int[][] graph) {
        final int n = graph.length;
        final Map<Integer, Set<Set<Integer>>> visitedNodes = new HashMap<>();
        final Queue<Node> queue = new LinkedList();

        for (int i=0; i<n; i++) {
            final Set<Integer> initialVisited = new HashSet<>();
            initialVisited.add(i);
            visitedNodes.put(i, new HashSet<>(Arrays.asList(initialVisited)));
            queue.add(new Node(i, 0, initialVisited));
        }

        while(!queue.isEmpty()) {
            final Node current = queue.poll();
            int node = current.node;
            int steps = current.steps;
            final Set<Integer> visited = current.visited;

            if (visited.size() == n) return steps;

            for (int adjNode : graph[node]) {
                final Set<Integer> newVisited = new HashSet<>(visited);
                newVisited.add(adjNode);

                if (!visitedNodes.get(adjNode).contains(newVisited)) {
                    queue.add(new Node(adjNode, steps + 1, newVisited));
                    visitedNodes.computeIfAbsent(adjNode, k -> new HashSet<>()).add(newVisited);
                }
            }
        }

        return -1;
    }

    private static class Node {
        int node;
        int steps;
        Set<Integer> visited;

        public Node(final int node, final int steps, final Set<Integer> visited) {
            this.node = node;
            this.steps = steps;
            this.visited = new HashSet<>(visited);
        }
    }
}

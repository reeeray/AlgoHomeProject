package leetcode.graphs;


import leetcode.structures.Pair;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 28.06.2023
 **/
public class PathWithMaxProbability_1514 {

    public static void main(String[] args) {

    }

    //Time O(n*m) where n number of nodes, m - number of edges. Space O(n + m)
    public double maxProbability(final int n, final int[][] edges, final double[] succProb, final int start, final int end) {
        final Map<Integer, List<Pair<Integer, Double>>> graph = new HashMap<>();
        for(int i=0; i<edges.length; i++) {
            graph.computeIfAbsent(edges[i][0], v-> new ArrayList<>()).add(new Pair<>(edges[i][1], succProb[i]));
            graph.computeIfAbsent(edges[i][1], v-> new ArrayList<>()).add(new Pair<>(edges[i][0], succProb[i]));
        }

        final PriorityQueue<Pair<Integer, Double>> queue = new PriorityQueue<>((a, b) -> -Double.compare(a.getLeft(), b.getLeft()));
        final double[] maxProbability = new double[n];
        maxProbability[start] = 1D;
        queue.add(new Pair<>(start, 1D));
        while(!queue.isEmpty()) {
            final Pair<Integer, Double> curr = queue.poll();
            if(curr.getLeft() == end) {
                return curr.getRight();
            }
            for(final Pair<Integer, Double> neighbor : graph.getOrDefault(curr.getLeft(), new ArrayList<>())) {
                final Double prob = curr.getRight() * neighbor.getRight();
                if(prob > maxProbability[neighbor.getLeft()]) {
                    maxProbability[neighbor.getLeft()] = prob;
                    queue.offer(new Pair<>(neighbor.getLeft(), maxProbability[neighbor.getLeft()]));
                }
            }
        }
        return -.0;
    }

    //Faster solution and optimized but here is magic number of 9
    public double maxProbabilityOpt(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // Create an array to store the maximum probability for each node
        final double[] maxProb = new double[n];
        Arrays.fill(maxProb, 0.0);  // Initialize all probabilities to 0.0
        maxProb[start_node] = 1.0;  // Probability of starting node is 1.0

        // Iterate 9 times (or you can use any number of iterations as needed)
        for (int i = 0; i < 9; ++i) {
            // Traverse all edges
            for (int j = 0; j < edges.length; ++j) {
                int u = edges[j][0];  // First node in the edge
                int v = edges[j][1];  // Second node in the edge
                double prob = succProb[j];  // Success probability for this edge

                // Update maxProb[v] if a better probability is found via u
                if (maxProb[u] * prob > maxProb[v]) {
                    maxProb[v] = maxProb[u] * prob;
                }

                // Update maxProb[u] if a better probability is found via v
                if (maxProb[v] * prob > maxProb[u]) {
                    maxProb[u] = maxProb[v] * prob;
                }
            }
        }

        // Return the maximum probability to reach the end node
        return maxProb[end_node];
}

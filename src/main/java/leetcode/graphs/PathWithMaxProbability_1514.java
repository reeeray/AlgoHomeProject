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
            for(final Pair<Integer, Double> neigbour : graph.getOrDefault(curr.getLeft(), new ArrayList<>())) {
                final Double prob = curr.getRight() * neigbour.getRight();
                if(prob > maxProbability[neigbour.getLeft()]) {
                    maxProbability[neigbour.getLeft()] = prob;
                    queue.offer(new Pair<>(neigbour.getLeft(), maxProbability[neigbour.getLeft()]));
                }
            }
        }
        return -.0;
    }
}

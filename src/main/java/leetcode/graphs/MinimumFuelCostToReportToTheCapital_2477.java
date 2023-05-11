package leetcode.graphs;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 12.02.2023
 **/
public class MinimumFuelCostToReportToTheCapital_2477 {

    long fuel;

    public static void main(String[] args) {
//        final int[][] input = {{3,1},{3,2},{1,0},{0,4},{0,5},{4,6}};
//        System.out.println(minimumFuelCost(input, 2));
    }

    private long dfs(int node, int parent, final Map<Integer, List<Integer>> adj, int seats) {
        // The node itself has one representative.
        int representatives = 1;
        if (!adj.containsKey(node)) {
            return representatives;
        }
        for (int child : adj.get(node)) {
            if (child != parent) {
                // Add count of representatives in each child subtree to the parent subtree.
                representatives += dfs(child, node, adj, seats);
            }
        }
        if (node != 0) {
            // Count the fuel it takes to move to the parent node.
            // Root node does not have any parent so we ignore it.
            fuel += Math.ceil((double) representatives / seats);
        }
        return representatives;
    }

    private long minimumFuelCost(int[][] roads, int seats) {
        final Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] road : roads) {
            adj.computeIfAbsent(road[0], k -> new ArrayList<>()).add(road[1]);
            adj.computeIfAbsent(road[1], k -> new ArrayList<>()).add(road[0]);
        }
        dfs(0, -1, adj, seats);
        return fuel;
    }

//    private static long minimumFuelCost(final int[][] roads, final int seats) {
//        final Map<Integer, List<Integer>> fromTo = new HashMap<>();
//        final List<Integer> depth = new ArrayList<>();
//
//        for(final int[] road : roads) {
//            fromTo.computeIfAbsent(road[0], v -> new ArrayList<>()).add(road[1]);
//            fromTo.computeIfAbsent(road[1], v -> new ArrayList<>()).add(road[0]);
//        }
//        final List<Integer> start = new ArrayList<>(fromTo.get(0));
//        for(final int road : start) {
//            depth.add(dfs(0, road, fromTo, 1));
//        }
//
//        long answer = 0;
//        for(int dep : depth) {
//            int mult = 1;
//            while (dep > 0) {
//                answer += dep > seats ? seats*mult : dep*mult;
//                mult++;
//                dep -=seats;
//            }
//        }
//        return answer;
//    }
//
//    private static int dfs(final int from, final int to, final Map<Integer, List<Integer>> fromTo, final int distance) {
//        fromTo.get(to).remove(Integer.valueOf(from));
//        if(fromTo.get(to).isEmpty()) {
//            return distance;
//        }
//        return dfs(to, fromTo.get(to).get(0), fromTo, distance+1);
//    }
}

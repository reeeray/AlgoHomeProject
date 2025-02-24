package leetcode.trees;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 24.02.2025
 **/
public class MostProfitablePathInATree_2467 {

    public static void main(String[] args) {

    }

    private static Map<Integer, Integer> bobPath;
    static boolean[] visited;
    private static List<List<Integer>> tree;

    //DFS for Bob and BFS for Alice. Time O(n) and Space O(n)
    public static int mostProfitablePath(final int[][] edges, final int bob, final int[] amount) {
        tree = new ArrayList<>();
        bobPath = new HashMap<>();
        visited = new boolean[amount.length];
        for (int i = 0; i < amount.length; i++) {
            tree.add(new ArrayList<>());
        }
        for (final int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        dfsBob(bob, 0);
        visited = new boolean[amount.length];
        final Queue<int[]> nodeQueue = new LinkedList<>();
        nodeQueue.add(new int[]{0, 0, 0});
        int maxIncome = Integer.MIN_VALUE;
        while (!nodeQueue.isEmpty()) {
            final int[] node = nodeQueue.poll();
            int sourceNode = node[0], time = node[1], income = node[2];

            // Alice reaches the node first
            if (!bobPath.containsKey(sourceNode) || time < bobPath.get(sourceNode)) {
                income += amount[sourceNode];
            }// Alice and Bob reach the node at the same time
            else if (time == bobPath.get(sourceNode)) {
                income += amount[sourceNode] / 2;
            }

            // Update max value if current node is a new leaf
            if (tree.get(sourceNode).size() == 1 && sourceNode != 0) {
                maxIncome = Math.max(maxIncome, income);
            }
            // Explore adjacent unvisited vertices
            for (int adjacentNode : tree.get(sourceNode)) {
                if (!visited[adjacentNode]) {
                    nodeQueue.add(new int[] { adjacentNode, time + 1, income });
                }
            }

            // Mark and remove current node
            visited[sourceNode] = true;
        }
        return maxIncome;
    }

    private static boolean dfsBob(final int source, final int time) {
        bobPath.put(source, time);
        visited[source] = true;

        // Destination for Bob is found
        if (source == 0) {
            return true;
        }

        // Traverse through unvisited nodes
        for (int adjacentNode : tree.get(source)) {
            if (!visited[adjacentNode]) {
                if (dfsBob(adjacentNode, time + 1)) {
                    return true;
                }
            }
        }
        bobPath.remove(source);
        return false;
    }
}

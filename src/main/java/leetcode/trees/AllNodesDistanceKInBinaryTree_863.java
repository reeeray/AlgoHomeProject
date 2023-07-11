package leetcode.trees;

import leetcode.structures.TreeNode;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 11.07.2023
 **/
public class AllNodesDistanceKInBinaryTree_863 {

    public static void main(String[] args) {

    }

    public static List<Integer> distanceK(final TreeNode root, final TreeNode target, final int k) {
        final Map<Integer, List<Integer>> routes = new HashMap<>();
        final List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        dfs(root, routes);
//        final Queue<Integer> queue = new LinkedList<>();
//        int level = -1;
//        queue.offer(target.getVal());
//        while(!queue.isEmpty()) {
//            final int node = queue.poll();
//            level++;
//            if(level == k) {
//                res.add(node);
//                continue;
//            }
//            for(final Integer n : routes.getOrDefault(node, new ArrayList<>())) {
//                if(n != node) {
//                    queue.offer(n);
//                }
//            }
//        }
        final Set<Integer> visited = new HashSet<>();
        final Queue<int[]> queue = new LinkedList<>();

        // Add the target node to the queue with a distance of 0
        queue.add(new int[]{target.getVal(), 0});
        visited.add(target.getVal());

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0], distance = cur[1];

            // If the current node is at distance k from target,
            // add it to the answer list and continue to the next node.
            if (distance == k) {
                res.add(node);
                continue;
            }

            // Add all unvisited neighbors of the current node to the queue.
            for (int neighbor : routes.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(new int[]{neighbor, distance + 1});
                }
            }
        }
        return res;
    }


    private static void dfs(final TreeNode node, final Map<Integer, List<Integer>> routes) {
        final TreeNode left = node.left;
        final TreeNode right = node.right;
        if (left != null) {
            routes.putIfAbsent(node.getVal(), new ArrayList<>()).add(left.getVal());
            routes.putIfAbsent(left.getVal(), new ArrayList<>()).add(node.getVal());
            dfs(left, routes);
        }
        if(right != null) {
            routes.putIfAbsent(node.getVal(), new ArrayList<>()).add(right.getVal());
            routes.putIfAbsent(right.getVal(), new ArrayList<>()).add(node.getVal());
            dfs(right, routes);

        }
    }
}

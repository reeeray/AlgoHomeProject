package leetcode.trees;

import leetcode.structures.TreeNode;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 10.01.2024
 **/
public class AmountOfTimeForBinaryTreeToBeInfected_2385 {

    public static void main(String[] args) {

    }

    public static int amountOfTime(final TreeNode root, final int start) {
        final Map<Integer, Set<Integer>> map = new HashMap<>();
        convert(root, 0, map);
        final Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int minute = 0;
        final Set<Integer> visited = new HashSet<>();
        visited.add(start);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            while (levelSize > 0) {
                int current = queue.poll();
                for (int num : map.get(current)) {
                    if (!visited.contains(num)) {
                        visited.add(num);
                        queue.add(num);
                    }
                }
                levelSize--;
            }
            minute++;
        }
        return minute - 1;
    }

    private static void convert(final TreeNode node, final int parent,  final Map<Integer, Set<Integer>> graph) {
        if(node == null) {
            return;
        }

        graph.computeIfAbsent(node.getVal(), v -> new HashSet<>());
        if(parent != 0) {
            graph.get(node.getVal()).add(parent);
        }

        if(node.getLeft() != null) {
            graph.get(node.getVal()).add(node.left.getVal());
        }

        if(node.right != null) {
            graph.get(node.getVal()).add(node.right.getVal());
        }

        convert(node.left, node.getVal(), graph);
        convert(node.right, node.getVal(), graph);
    }
}

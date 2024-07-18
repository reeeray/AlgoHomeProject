package leetcode.trees;

import leetcode.structures.TreeNode;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 18.07.2024
 **/
public class NumberOfGoodLeafsNodesPairs_1530 {

    public static void main(String[] args) {

    }

    //Time O(n^2) and Space O(n)
    public static int countPairs(final TreeNode root, final int distance) {
        final Map<TreeNode, List<TreeNode>> tree = new HashMap<>();
        final Set<TreeNode> leafs = new HashSet<>();
        dfs(null, root, tree, leafs);
        int count = 0;
        for(final TreeNode leaf : leafs) {
            final Queue<TreeNode> bfs = new LinkedList<>();
            final Set<TreeNode> visited = new HashSet<>();
            bfs.add(leaf);
            visited.add(leaf);
            for(int i=0; i<=distance; i++) {
                final int size = bfs.size();
                for(int j=0; j<size; j++) {
                    final TreeNode current = bfs.poll();
                    if(leafs.contains(current) && current != leaf) {
                        count++;
                    }
                    if(tree.containsKey(current)) {
                        for(final TreeNode neighbour : tree.get(current)) {
                            if(!visited.contains(neighbour)) {
                                bfs.add(neighbour);
                                visited.add(neighbour);
                            }
                        }
                    }
                }
            }
        }
        return count / 2;
    }

    private static void dfs(final TreeNode prev, final TreeNode node, final Map<TreeNode, List<TreeNode>> tree, final Set<TreeNode> leafs) {
        if(node == null) {
            return;
        }
        if(node.left == null && node.right == null) {
            leafs.add(node);
        }
        if(prev != null) {
            tree.computeIfAbsent(node, v -> new ArrayList<>());
            tree.get(node).add(prev);
            tree.computeIfAbsent(prev, v -> new ArrayList<>());
            tree.get(prev).add(node);
        }
        dfs(node, node.left, tree, leafs);
        dfs(node, node.right, tree, leafs);
    }

}

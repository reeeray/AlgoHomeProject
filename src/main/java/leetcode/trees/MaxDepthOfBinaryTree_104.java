package leetcode.trees;

import leetcode.structures.TreeNode;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 16.02.2023
 **/
public class MaxDepthOfBinaryTree_104 {

    public static void main(String[] args) {

    }

    private static int maxDepth(final TreeNode node) {
        return dfs(0, node);
    }

    private static int dfs(final int depth, final TreeNode node) {
        return node == null ? depth : Math.max(dfs(depth + 1, node.getLeft()), dfs(depth + 1, node.getRight()));
    }

    private static int maxDepthElegant(final TreeNode node) {
        return node == null ? 0 : 1 + Math.max(maxDepthElegant(node.getLeft()), maxDepthElegant(node.getRight()));
    }


}

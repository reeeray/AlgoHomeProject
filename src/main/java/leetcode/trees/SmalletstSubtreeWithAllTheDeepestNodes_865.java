package leetcode.trees;

import leetcode.structures.TreeNode;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 09.01.2026
 **/
public class SmalletstSubtreeWithAllTheDeepestNodes_865 {

    public static void main(String[] args) {

    }

    public static TreeNode subtreeWithAllDeepest(final TreeNode root) {
        return dfs(root).node;
    }

    private static DeepestNode dfs(final TreeNode node) {
        if(node == null) return new DeepestNode(null, 0);
        final DeepestNode left = dfs(node.left), right = dfs(node.right);
        if(left.deep > right.deep) return new DeepestNode(left.node, left.deep + 1);
        if(left.deep < right.deep) return new DeepestNode(right.node, right.deep + 1);
        return new DeepestNode(node, left.deep + 1);
    }

    private static class DeepestNode {
        TreeNode node;
        int deep;
        public DeepestNode(final TreeNode node, final int deep) {
            this.node = node;
            this.deep = deep;
        }
    }
}

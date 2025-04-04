package leetcode.trees;

import leetcode.structures.Pair;
import leetcode.structures.TreeNode;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 04.04.2025
 **/
public class LowestCommonAncestorOfDeepestLeaves_1123 {

    public static void main(String[] args) {

    }

    public static TreeNode lcaDeapestLeaves(final TreeNode root) {
        return dfs(root).getLeft();
    }

    private static Pair<TreeNode, Integer> dfs(final TreeNode node) {
        if(node == null) {
            return new Pair<>(null, 0);
        }
        final Pair<TreeNode, Integer> left = dfs(node.left);
        final Pair<TreeNode, Integer> right = dfs(node.right);
        if(left.getRight() > right.getRight()) {
            return new Pair<>(left.getLeft(), left.getRight() + 1);
        }
        if(left.getRight() < right.getRight()) {
            return new Pair<>(right.getLeft(), right.getRight() + 1);
        }
        return new Pair<>(node, left.getRight() + 1);
    }
}

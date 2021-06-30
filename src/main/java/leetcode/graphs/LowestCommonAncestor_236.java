package leetcode.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * 236. Lowest Common Ancestor of A Binary Tree.
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q
 * as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * User : Shein G.A.{@reeeray}
 * Date : 30.06.2021
 **/
public class LowestCommonAncestor_236 {

    private static List<TreeNode> path1 = new ArrayList<>();
    private static List<TreeNode> path2 = new ArrayList<>();

    public static void main(String[] args) {
        final TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);

        System.out.println("LCA(4, 5): " + lowestCommonAncestor(tree, tree.left.left, tree.left.right));
        System.out.println("LCA(4, 6): " + lowestCommonAncestor(tree, tree.left.left, tree.right.left));
        System.out.println("LCA(3, 4): " + lowestCommonAncestor(tree, tree.right, tree.left.left));
        System.out.println("LCA(2, 4): " + lowestCommonAncestor(tree, tree.left, tree.left.left));
    }

    public TreeNode quickiestAlternativelowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        path1.clear();
        path2.clear();
        findPath(root, p, path1);
        findPath(root, q, path2);

        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (!path1.get(i).equals(path2.get(i)))
                break;
        }
        return path1.get(i - 1);
    }

    private static boolean findPath(final TreeNode root, final TreeNode node, final List<TreeNode> path) {
        if (root == null)
            return false;

        path.add(root);

        if (root == node)
            return true;

        if (root.left != null && findPath(root.left, node, path))
            return true;
        if (root.right != null && findPath(root.right, node, path))
            return true;

        path.remove(root);
        return false;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}

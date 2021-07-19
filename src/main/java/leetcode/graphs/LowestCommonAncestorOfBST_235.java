package leetcode.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * <p>
 * <p>
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * User : Shein G.A.{@reeeray}
 * Date : 19.07.2021
 **/
public class LowestCommonAncestorOfBST_235 {

    private static List<LowestCommonAncestor_236.TreeNode> path1 = new ArrayList<>();
    private static List<LowestCommonAncestor_236.TreeNode> path2 = new ArrayList<>();

    public static void main(String[] args) {
        final TreeNode tree = new TreeNode(6);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(8);
        tree.left.left = new TreeNode(0);
        tree.left.right = new TreeNode(4);
        tree.right.left = new TreeNode(7);
        tree.right.right = new TreeNode(9);

        System.out.println("LCA(4, 5): " + lowestCommonAncestorOfBST(tree, tree.left, tree.right).val);
    }


    private static TreeNode lowestCommonAncestorOfBST(final TreeNode root, final TreeNode p, final TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        if ((p.val < root.val && root.val < q.val) || (q.val < root.val && root.val < p.val))
            return root;
        if (p.val < root.val) {
            return lowestCommonAncestorOfBST(root.left, p, q);
        }
        return lowestCommonAncestorOfBST(root.right, p, q);
    }

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

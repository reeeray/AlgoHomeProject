package leetcode.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Leetcode issue 107 : Binary Tree Level Order Traversal II
 * <p>
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 * User : Shein G.A.{@reeeray}
 * Date : 02.07.2020
 **/
public class Binary_Tree_Level_Orde_TraversalII_107 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        final List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, res);
        Collections.reverse(res);
        return res;
    }

    private static void dfs(final TreeNode node, final int level, final List<List<Integer>> res) {
        if (node == null)
            return;
        if (res.get(level) == null)
            res.add(level, new ArrayList<>());
        res.get(level).add(node.val);
        dfs(node.left, level + 1, res);
        dfs(node.right, level + 1, res);
    }

    public static void main(String[] args) {
//        levelOrderBottom();
    }

}

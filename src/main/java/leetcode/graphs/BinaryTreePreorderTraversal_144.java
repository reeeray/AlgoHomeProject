package leetcode.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 09.01.2023
 **/
public class BinaryTreePreorderTraversal_144 {


    public static void main(String[] args) {

    }


    private static List<Integer> preorderTraversalWithoutRecursion(final TreeNode root) {
        final Stack<TreeNode> stack = new Stack<>();
        final List<Integer> values = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            final TreeNode node = stack.pop();
            if(node == null) {
                continue;
            }
            values.add(node.val);
            stack.push(node.right);
            stack.push(node.left);
        }
        return values;

    }

    private static List<Integer> preorderTraversalValues(final TreeNode root) {
        final List<Integer> values = new ArrayList<>();
        dfs(values, root);
        return values;
    }

    private static void dfs(final List<Integer> values, final TreeNode node) {
        if(node == null) {
            return;
        }

        values.add(node.val);
        dfs(values, node.left);
        dfs(values, node.right);
    }


//      Definition for a binary tree node.
    public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
}

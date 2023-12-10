package leetcode.trees;

import leetcode.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 09.12.2023
 **/
public class InorderTraversal_94 {

    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversalMorris(TreeNode root) {
        final List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.getVal());
                curr = curr.right; // move to next right node
            } else { // has a left subtree
                pre = curr.left;
                while (pre.right != null) { // find rightmost
                    pre = pre.right;
                }
                pre.right = curr; // put cur after the pre node
                TreeNode temp = curr; // store cur node
                curr = curr.left; // move cur to the top of the new tree
                temp.left = null; // original cur left be null, avoid infinite loops
            }
        }
        return res;
    }

    public static List<Integer> inorderTraversalStack(final TreeNode root) {
        final List<Integer> res = new ArrayList<>();
        final Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.getVal());
            curr = curr.right;
        }
        return res;
     }

    public static List<Integer> inorderTraversal(final TreeNode root) {
        final List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private static void dfs(final TreeNode node, final List<Integer> list) {
        if(node == null) {
            return;
        }

        dfs(node.left, list);
        list.add(node.getVal());
        dfs(node.right, list);
    }
}

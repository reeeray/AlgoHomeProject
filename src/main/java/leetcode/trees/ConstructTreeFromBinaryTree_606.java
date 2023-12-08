package leetcode.trees;

import leetcode.structures.TreeNode;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 08.12.2023
 **/
public class ConstructTreeFromBinaryTree_606 {

    public static void main(String[] args) {

    }

    public static String tree2str(final TreeNode root) {
        if(root == null) {
            return "";
        }
        String res = "" + root.getVal();
        if(root.left != null) {
            res += "(" + tree2str(root.left) + ")";
        }
        if(root.right != null) {
            if(root.left == null) {
                res += "()";
            }
            res += "(" + tree2str(root.right) + ")";
        }
        return res;
    }

    private static String dfs(final TreeNode node) {
        if(node == null) {
            return "";
        }
        String res = "" + node.getVal();
        res += "(" + dfs(node.left) + ")";
        res += "(" + dfs(node.right) + ")";
        return res;
    }

    public String tree2strWithSB(TreeNode root) {
        final StringBuilder res = new StringBuilder();
        dfs(root, res);
        return res.toString();
    }

    public static void dfs(TreeNode t, StringBuilder res) {
        if (t == null)
            return;
        res.append(String.valueOf(t.getVal()));
        if (t.left == null && t.right == null)
            return;
        res.append('(');
        dfs(t.left, res);
        res.append(')');
        if (t.right != null) {
            res.append('(');
            dfs(t.right, res);
            res.append(')');
        }
    }
}

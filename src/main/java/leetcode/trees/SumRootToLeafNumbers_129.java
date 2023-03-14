package leetcode.trees;

import leetcode.structures.TreeNode;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 14.03.2023
 **/
public class SumRootToLeafNumbers_129 {


    public static void main(String[] args) {

    }

    public static int sumNumbers(final TreeNode root) {
//        dfsInt(root, 0);
        return dfs(root, "");
    }

    private static int dfs(final TreeNode node, final String path) {
        if(node == null) {
            return 0;
        }
        if(node.getLeft() == null && node.getRight() == null) {
            return Integer.valueOf(path+node.getVal());
        }
        return dfs(node.getLeft(), path+node.getVal()) + dfs(node.getRight(), path+node.getVal());
    }

    private static int dfsInt(final TreeNode node, final int sum) {
        if(node == null) {
            return 0;
        }
        final int s = sum*10 + node.getVal();
        if(node.getLeft() == null && node.getRight() == null) {
            return s;
        }
        return dfsInt(node.getLeft(), s) + dfsInt(node.getRight(), s);
    }
}

package leetcode.trees;

import leetcode.structures.TreeNode;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 08.01.2024
 **/
public class RnageSumOfBST_938 {

    public static void main(String[] args) {

    }

    public int rangeSumBST(final TreeNode root, final int low, final int high) {
        return dfs(root, low, high);
    }

    private static int dfs(final TreeNode node, final int low, final int high) {
        if(node == null) {
            return 0;
        }
        int s = 0;

        if(node.getVal() >= low && node.getVal() <= high) {
            s += node.getVal();
        }

        if(node.getVal() > low) {
            s += dfs(node.getLeft(), low, high);
        }
        if(node.getVal() < high) {
            s += dfs(node.getRight(), low, high);
        }
        return s;
    }
}

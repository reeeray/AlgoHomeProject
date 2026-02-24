package leetcode.binaryStuff;

import leetcode.structures.TreeNode;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 24.02.2026
 **/
public class SumOfRootToLeafBinaryNumbers_1022 {

    static int res = 0;
    public static void main(String[] args) {

    }

    public static int sumRootToLeaf(final TreeNode root) {
        res = 0;
        dfs(root, 0);
        return  res;
    }

    private static void dfs(final TreeNode node, int val) {
        if(node == null) return;
        final int newVal = val*2 + node.val;
        if(node.left == null && node.right == null) {
            res += newVal;
        } else {
            dfs(node.left, newVal);
            dfs(node.right, newVal);
        }
    }
}

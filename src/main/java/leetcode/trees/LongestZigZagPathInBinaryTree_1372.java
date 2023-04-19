package leetcode.trees;

import leetcode.structures.TreeNode;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 19.04.2023
 **/
public class LongestZigZagPathInBinaryTree_1372 {
    private static int max = 0;

    public static void main(String[] args) {
        longestZigZag(new TreeNode(1));
    }

    private static int longestZigZag(final TreeNode root) {
        max = 0;
        dfs(root.left, 1, false);
        dfs(root.right, 1, true);
        return max;
    }

    private static void dfs(final TreeNode node, final int count, final boolean right) {
        if(node == null) return;

        max = Math.max(max, count);

        if(right) {
            dfs(node.left, count+1, false);
            dfs(node.right, 1, true);
        } else {
            dfs(node.right, count+1, true);
            dfs(node.left, 1, false);
        }
    }
}

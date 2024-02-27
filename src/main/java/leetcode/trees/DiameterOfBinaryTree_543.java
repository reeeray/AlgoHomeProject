package leetcode.trees;

import leetcode.structures.TreeNode;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 27.02.2024
 **/
public class DiameterOfBinaryTree_543 {

    public static void main(String[] args) {

    }

    //Space O(1) and Time is O(n)
    public int diameterOfBinaryTree(final TreeNode node) {
        final int[] storage = new int[1];
        dfs(node, storage);
        return storage[0];
    }

    private static int dfs(final TreeNode node, final int[] storage) {
        if(node == null) return 0;
        int left = dfs(node.left, storage);
        int right = dfs(node.right, storage);
        storage[0] = Math.max(storage[0], left + right);
        return 1 + Math.max(left, right);
    }
}

package leetcode.trees;

import leetcode.structures.TreeNode;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.06.2024
 **/
public class BinarySearchTreeToGreaterSumTree_1038 {

    public static void main(String[] args) {

    }

    //Time complexity O(n) and Space O(n)
    public TreeNode bstToGst(TreeNode root) {
        int[] nodeSum = new int[1];
        bstToGstHelper(root, nodeSum);
        return root;
    }

    private void bstToGstHelper(TreeNode root, int[] nodeSum) {
        // If root is null, make no changes.
        if (root == null) {
            return;
        }

        bstToGstHelper(root.right, nodeSum);
        nodeSum[0] += root.getVal();
        // Update the value of root.
        root.setVal(nodeSum[0]);
        bstToGstHelper(root.left, nodeSum);
    }
}

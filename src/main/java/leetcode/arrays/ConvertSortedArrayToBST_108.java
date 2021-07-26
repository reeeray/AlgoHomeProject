package leetcode.arrays;

import java.util.Arrays;

/**
 * 108. Convert Sorted Array to Binary Search Tree.
 * <p>
 * <p>
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 * <p>
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 * <p>
 * User : Shein G.A.{@reeeray}
 * Date : 26.07.2021
 **/
public class ConvertSortedArrayToBST_108 {

    public static void main(String[] args) {
        final TreeNode answer = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        assert answer.val == 0;
    }

    private static TreeNode sortedArrayToBST(final int[] array) {
        if (array.length == 0)
            return null;
        final int mid = array.length / 2;
        final TreeNode root = new TreeNode(array[mid]);
        root.leftNode = sortedArrayToBST(Arrays.copyOfRange(array, 0, mid));
        root.rightNode = sortedArrayToBST(Arrays.copyOfRange(array, mid + 1, array.length));
        return root;
    }

    private static class TreeNode {
        int val;
        TreeNode leftNode;
        TreeNode rightNode;

        public TreeNode() {
        }

        public TreeNode(final int val) {
            this.val = val;
        }

        public TreeNode(final int val, final TreeNode left, final TreeNode right) {
            this.val = val;
            this.leftNode = left;
            this.rightNode = right;
        }
    }

}

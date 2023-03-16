package leetcode.trees;

import leetcode.structures.TreeNode;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 16.03.2023
 **/
public class ConstructBinaryTreeFromInorderAndPreorderTraversal_106 {

    public static void main(String[] args) {

    }

    public static TreeNode buildTree(final int[] inorder, final int[] postorder) {
        return buildFromOrder(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }

    private static TreeNode buildFromOrder(final int[] inOrder, final int[] postOrder, final int inStart, final int inEnd, final int postStart, final int postEnd) {
        if(inEnd < inStart || postEnd < postStart) {
            return null;
        }
        final TreeNode root = new TreeNode(postOrder[postEnd]);

        int rootIndex = 0;
        for(int i=0; i<inOrder.length; i++) {
            if(inOrder[i] == postOrder[postEnd]) {
                rootIndex = i;
                break;
            }
        }
        final int leftSizeTree = rootIndex - inStart;
        final int rightSizeTree = inEnd - rootIndex;
        root.left = buildFromOrder(inOrder, postOrder, inStart, rootIndex-1, postStart, postStart + leftSizeTree -1);
        root.right = buildFromOrder(inOrder, postOrder, rootIndex+1, inEnd, postEnd-rightSizeTree, postEnd-1);
        return root;
    }
}

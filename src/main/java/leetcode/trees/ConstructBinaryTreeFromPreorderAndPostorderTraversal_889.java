package leetcode.trees;

import leetcode.structures.TreeNode;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 23.02.2025
 **/
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal_889 {

    public static void main(String[] args) {

    }

    //Time O(n^2) and Space O(n)
    public static TreeNode constructFromPrePost(final int[] preorder, final int[] postorder) {
        return constructTree(0, preorder.length - 1, 0, preorder, postorder);
    }

    private static TreeNode constructTree(final int startPreorderIndex, final int endPreorderIndex, final int startPostOrderIndex, final int[] preorder, final int[] postorder) {
        if(startPreorderIndex > endPreorderIndex) {
            return null;
        }

        if(startPreorderIndex == endPreorderIndex) {
            return new TreeNode(preorder[startPreorderIndex]);
        }

        final TreeNode root = new TreeNode(preorder[startPreorderIndex]);
        int leftTreeLength = 1;
        while (postorder[startPostOrderIndex + leftTreeLength - 1] != preorder[startPreorderIndex + 1]) {
            leftTreeLength++;
        }
        root.left = constructTree(startPreorderIndex + 1, startPreorderIndex + leftTreeLength, startPostOrderIndex, preorder, postorder);
        root.right = constructTree(startPreorderIndex + leftTreeLength + 1, endPreorderIndex, startPostOrderIndex + leftTreeLength, preorder, postorder);
        return root;
    }

    //Time optimized because of precalculation : O(n) and Space the same O(n)
    public TreeNode constructFromPrePostIndexing(int[] preorder, int[] postorder) {
        final int numOfNodes = preorder.length;

        // Create the index array for `postorder`
        int[] indexInPostOrder = new int[numOfNodes + 1];
        for (int index = 0; index < numOfNodes; index++) {
            // Store the index of the current element
            indexInPostOrder[postorder[index]] = index;
        }

        return constructTreeWithIndexing(0, numOfNodes - 1, 0, preorder, indexInPostOrder);
    }

    // Helper function to construct the tree recursively
    private TreeNode constructTreeWithIndexing(
            final int preStart,
            final int preEnd,
            final int postStart,
            final int[] preorder,
            final int[] indexInPostOrder
    ) {
        // Base case: If there are no nodes to process, return null
        if (preStart > preEnd) return null;

        // Base case: If only one node is left, return that node
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        // The left child root in preorder traversal (next element after root)
        int leftRoot = preorder[preStart + 1];

        // Calculate the number of nodes in the left subtree by searching in postorder
        int numOfNodesInLeft = indexInPostOrder[leftRoot] - postStart + 1;

        TreeNode root = new TreeNode(preorder[preStart]);

        // Recursively construct the left subtree
        root.left = constructTree(
                preStart + 1,
                preStart + numOfNodesInLeft,
                postStart,
                preorder,
                indexInPostOrder
        );

        // Recursively construct the right subtree
        root.right = constructTree(
                preStart + numOfNodesInLeft + 1,
                preEnd,
                postStart + numOfNodesInLeft,
                preorder,
                indexInPostOrder
        );

        return root;
    }

    private int preIndex = 0;
    private int postIndex = 0;

    //Sophisticated solution, Time O(n) and Space O(n)
    public TreeNode constructFromPrePostRecursion(int[] preorder, int[] postorder) {
        return constructTree(preorder, postorder);
    }

    // Helper function to recursively build the tree
    private TreeNode constructTree(int[] preorder, int[] postorder) {
        // Create a new node with the value at the current preorder index
        TreeNode root = new TreeNode(preorder[preIndex++]);

        // Recursively construct the left subtree if the root is not the last of
        // its subtree
        if (root.val != postorder[postIndex]) {
            root.left = constructTree(preorder, postorder);
        }

        // Recursively construct the right subtree if the root is still not the
        // last of its subtree
        if (root.val != postorder[postIndex]) {
            root.right = constructTree(preorder, postorder);
        }

        // Mark this node and its subtree as fully processed
        postIndex++;
        return root;
    }
}

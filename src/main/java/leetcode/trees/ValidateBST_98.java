package leetcode.trees;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 17.02.2022
 **/
public class ValidateBST_98 {

    public static void main(String[] args) {
        final TreeNode treeNode3 = new TreeNode(3, null, null);
        final TreeNode treeNode7 = new TreeNode(6, null, null);
        final TreeNode treeNode4 = new TreeNode(4, treeNode7, treeNode3);
        final TreeNode treeNode6 = new TreeNode(1, null, null);
        final TreeNode treeNode5 = new TreeNode(5, treeNode6, treeNode4);

        System.out.println(isValidBST(treeNode5));

    }


    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = root.left == null;
        boolean right = root.right == null;
        if (root.left != null && root.left.val < root.val) {
            if (!leftCheckFail(root.left, root.val))
                return false;
            left = isValidBST(root.left);
        }
        if (left && root.right != null && root.right.val > root.val) {
            if (!rightCheckFail(root.right, root.val)) {
                System.out.println(root.val);
                return false;
            }
            right = isValidBST(root.right);
        }

        return left && right;
    }

    private static boolean leftCheckFail(final TreeNode node, final int treshold) {
        if (node == null)
            return true;
        if (node.val >= treshold)
            return false;
        return leftCheckFail(node.left, treshold) && leftCheckFail(node.right, treshold);
    }

    private static boolean rightCheckFail(final TreeNode node, final int treshold) {
        if (node == null)
            return true;
        if (node.val <= treshold)
            return false;
        return rightCheckFail(node.left, treshold) && rightCheckFail(node.right, treshold);
    }

}

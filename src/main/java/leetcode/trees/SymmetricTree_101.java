package leetcode.trees;

import leetcode.structures.TreeNode;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 13.03.2023
 **/
public class SymmetricTree_101 {

    public static void main(String[] args) {

    }

    public static boolean isSymmetric(final TreeNode root) {
        return  root == null ? false : compareLevel(root.getLeft(), root.getRight());
    }

    private static boolean compareLevel(final TreeNode left, final TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null || left.getVal() != right.getVal()) {
            return false;
        }

        final boolean one = compareLevel(left.getLeft(), right.getRight());
        final boolean two = compareLevel(left.getRight(), right.getLeft());
        return one && two;
    }
}

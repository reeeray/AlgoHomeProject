package leetcode.trees;

import leetcode.structures.TreeNode;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.02.2024
 **/
public class SameTree_100 {

    public static void main(String[] args) {

    }

    public static boolean isSameTree(final TreeNode one, final TreeNode two) {
        if(one == null && two == null) return true;
        if(one == null || two == null) return false;
        return one.getVal() == two.getVal() && isSameTree(one.getLeft(), two.getLeft()) && isSameTree(one.getRight(), two.getRight());
    }
}

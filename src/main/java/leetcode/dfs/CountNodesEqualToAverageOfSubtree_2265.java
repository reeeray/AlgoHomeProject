package leetcode.dfs;

import leetcode.structures.Pair;
import leetcode.structures.TreeNode;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 10.09.2026
 **/
public class CountNodesEqualToAverageOfSubtree_2265 {

    private int count = 0;

    public static void main(String[] args) {

    }

    //time O(n) and space O(n)
    public int averageOfSubtree(final TreeNode root) {
        dfs(root);
        return count;
    }

    private Pair<Integer, Integer> dfs(final TreeNode node) {
        if(node == null) return new Pair<>(0, 0);
        final Pair<Integer, Integer> left = dfs(node.left);
        final Pair<Integer, Integer> right = dfs(node.right);
        final int sum = left.getLeft() + right.getLeft() + node.val;
        final int divider = left.getRight() + right.getRight() + 1;
        if(node.val == sum/divider) count++;
        return new Pair<>(sum, divider);
    }
}

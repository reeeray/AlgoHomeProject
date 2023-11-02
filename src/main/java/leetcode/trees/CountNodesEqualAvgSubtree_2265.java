package leetcode.trees;

import leetcode.structures.TreeNode;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 02.11.2023
 **/
public class CountNodesEqualAvgSubtree_2265 {

    private static int count = 0;

    public static void main(String[] args) {

    }

    //post order calculation : Time O(n) and Space O(n)
    public static int averageOfSubtree(final TreeNode root) {
        count = 0;
        dfs(root);
        return count;
    }

    private static Pair dfs(final TreeNode node) {
        if(node == null) {
            return null;
        }

        final int val = node.getVal();
        final Pair left = dfs(node.left);
        final Pair right = dfs(node.right);
        int totalSum = val;
        int totalCount = 1;
        if(left != null) {
            totalCount += left.count;
            totalSum += left.sum;
        }
        if(right != null) {
            totalCount += right.count;
            totalSum += right.sum;
        }

        if (val == totalSum/totalCount) {
            count++;
        }
        return new Pair(totalCount, totalSum);
    }

    private static class Pair {
        public int count;
        public int sum;

        public Pair(final int count, final int sum) {
            this.count = count;
            this.sum = sum;
        }
    }
}

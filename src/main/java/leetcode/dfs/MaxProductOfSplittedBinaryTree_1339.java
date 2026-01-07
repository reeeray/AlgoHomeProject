package leetcode.dfs;

import leetcode.structures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 07.01.2026
 **/
public class MaxProductOfSplittedBinaryTree_1339 {

    public static void main(String[] args) {

    }

    public static int maxProduct(final TreeNode root) {
        final int totalSum = dfs(root);
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        long maxProduct = 0;
        while(!queue.isEmpty()) {
            final TreeNode curr = queue.poll();
            if(curr == null) continue;
            maxProduct = Math.max(maxProduct, (totalSum - curr.val) * curr.val);
            queue.offer(curr.left);
            queue.offer(curr.right);
        }
        return (int)(maxProduct % (1e9 + 7));
    }

    private static int dfs(final TreeNode node) {
        if(node == null) return 0;
        node.val += dfs(node.left) + dfs(node.right);
        return node.val;
    }
}

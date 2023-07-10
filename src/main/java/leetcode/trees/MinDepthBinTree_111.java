package leetcode.trees;

import leetcode.structures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 10.07.2023
 **/
public class MinDepthBinTree_111 {

    public static void main(String[] args) {

    }

    public static int minDepth(final TreeNode root) {
        return root == null ? 0 : dfs(root, 0);
    }

    private static int dfs(final TreeNode node, final int depth) {
        if(node.left == null && node.right == null) {
            return depth + 1;
        }
        final int left = node.left == null ? Integer.MAX_VALUE : dfs(node.left, depth + 1);
        final int right = node.right == null ? Integer.MAX_VALUE : dfs(node.right, depth + 1);
        return Math.min(left, right);
    }

    public int minDepthBFS(TreeNode root) {
        if (root == null) return 0;

        final Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int depth = 1;

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }

}

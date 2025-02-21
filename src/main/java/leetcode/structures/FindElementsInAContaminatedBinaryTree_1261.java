package leetcode.structures;

import leetcode.FindMedianFromDataStream_295;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 21.02.2025
 **/
public class FindElementsInAContaminatedBinaryTree_1261 {

    final Set<Integer> values;

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(n)
    public FindElementsInAContaminatedBinaryTree_1261(final TreeNode root) {
        values = new HashSet<>();
        final Queue<TreeNode> pullOfNodes = new LinkedList<>();
        root.val = 0;
        pullOfNodes.add(root);
        while (!pullOfNodes.isEmpty()) {
            final TreeNode node = pullOfNodes.poll();
            values.add(node.val);
            if(node.left != null) {
                node.left.val = node.val * 2 + 1;
                pullOfNodes.offer(node.left);
            }
            if(node.right != null) {
                node.right.val = node.val * 2 + 2;
                pullOfNodes.offer(node.right);
            }
        }
    }

    //alternative via dfs. Complexity stays the same
    private void dfs(TreeNode currentNode, int currentValue) {
        if (currentNode == null) return;
        // visit current node by adding its value to seen
        values.add(currentValue);
        dfs(currentNode.left, currentValue * 2 + 1);
        dfs(currentNode.right, currentValue * 2 + 2);
    }

    //O(1)
    public boolean find(final int target) {
        return values.contains(target);
    }

}

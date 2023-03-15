package leetcode.trees;

import leetcode.structures.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 15.03.2023
 **/
public class CheckCompletenessOfBinaryTree_958 {

    public static void main(String[] args) {

    }

    public static boolean isCompleteTree(final TreeNode root) {
        final Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            final int size = nodes.size();
            for(int i=0; i<size; i++) {
                final TreeNode node = nodes.poll();
                if(node == null) {
                    while (!nodes.isEmpty()) {
                        if(nodes.poll() != null) {
                            return false;
                        }
                    }
                    return true;
                }
                nodes.offer(node.getLeft());
                nodes.offer(node.getRight());
            }
        }
        return true;
    }

    // Define the isCompleteTree function that takes a TreeNode as input and returns a boolean
    public boolean isCompleteTree(TreeNode root) {
        // Check if the root node is null, if so, return true (an empty tree is complete)
        if (root == null)
            return true;

        // Create a queue to store the nodes of the tree in level order
        Queue<TreeNode> q = new LinkedList<>(Arrays.asList(root);

        // Traverse the tree in level order
        while (q.peek() != null) {
            // Remove the first node from the queue
            TreeNode node = q.poll();
            // Add the left and right child nodes of the current node to the queue
            q.offer(node.getLeft());
            q.offer(node.getRight());
        }

        // Remove any remaining null nodes from the end of the queue
        while (!q.isEmpty() && q.peek() == null)
            q.poll();

        // Check if there are any remaining nodes in the queue
        // If so, the tree is not complete, so return false
        // Otherwise, the tree is complete, so return true
        return q.isEmpty();
    }
}

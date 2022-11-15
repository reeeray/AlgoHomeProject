package leetcode.graphs;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 15.11.2022
 **/
public class CountCompleteTreeNode_222 {

    public static void main(String[] args) {

    }

    private static int countNodes(final TreeNode node) {
        if(node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    private static int countNodeImproved(final TreeNode node) {
        TreeNode current = node;
        int leftDepth = 0;
        int rightDepth = 0;
        while(current != null) {
            current = current.left;
            leftDepth++;
        }
        current = node;
        while(current != null) {
            current = current.right;
            rightDepth++;
        }
        if(leftDepth == rightDepth) {
            return (int)Math.pow(2, leftDepth) - 1;
        }
        return 1 + countNodes(node.right) + countNodes(node.left);
    }


//      Definition for a binary tree node
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
}

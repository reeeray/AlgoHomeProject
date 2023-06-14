package leetcode.trees;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 14.06.2023
 **/
public class MinAbsDiffBST_530 {

    private int min = Integer.MAX_VALUE;

    public static void main(String[] args) {

    }

    public int getMinimumAbsoluteDiff(final ValidateBST_98.TreeNode root) {
        dfs(root);
        return min;
    }

    private void dfs(final ValidateBST_98.TreeNode node) {
        if(node.left != null) {
            dfsRight(node.left, node.val);
            dfs(node.left);
        }
        if(node.right != null) {
            dfsLeft(node.right, node.val);
            dfs(node.right);
        }
    }

    private void dfsLeft(final ValidateBST_98.TreeNode node, final int val) {
        if (node.left == null) {
            min = Math.min(min, Math.abs(val - node.val));
            return;
        }
        dfsLeft(node.left, val);
    }

    private void dfsRight(final ValidateBST_98.TreeNode node, final int val) {
        if(node.right == null) {
            min = Math.min(min, Math.abs(val - node.val));
            return;
        }
        dfsRight(node.right, val);
    }


    //Via inorder traversal O(n) and O(n)
    // List to store the tree nodes in the inorder traversal.
//    List<Integer> inorderNodes = new ArrayList<>();
//
//    void inorderTraversal(TreeNode node) {
//        if (node == null) {
//            return;
//        }
//
//        inorderTraversal(node.left);
//        // Store the nodes in the list.
//        inorderNodes.add(node.val);
//        inorderTraversal(node.right);
//    }
//
//    int getMinimumDifference(TreeNode root) {
//        inorderTraversal(root);
//
//        int minDifference = Integer.MAX_VALUE;
//        // Find the diff between every two consecutive values in the list.
//        for (int i = 1; i < inorderNodes.size(); i++) {
//            minDifference = Math.min(minDifference, inorderNodes.get(i) - inorderNodes.get(i-1));
//        }
//
//        return minDifference;
//    }

    //or via inorder traversal with immediate calc
//    int minDifference = Integer.MAX_VALUE;
//    // Initially, it will be null.
//    TreeNode prevNode;
//
//    void inorderTraversal(TreeNode node) {
//        if (node == null) {
//            return;
//        }
//
//        inorderTraversal(node.left);
//        // Find the difference with the previous value if it is there.
//        if (prevNode != null) {
//            minDifference = Math.min(minDifference, node.val - prevNode.val);
//        }
//        prevNode = node;
//        inorderTraversal(node.right);
//    }
//
//    int getMinimumDifference(TreeNode root) {
//        inorderTraversal(root);
//        return minDifference;
//    }
}

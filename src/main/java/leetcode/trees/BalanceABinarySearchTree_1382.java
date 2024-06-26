package leetcode.trees;

import leetcode.structures.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.06.2024
 **/
public class BalanceABinarySearchTree_1382 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(n). Could be improved with specific algo
    public static TreeNode balanceBST(final TreeNode root) {
        final List<Integer> sortedValues = new ArrayList<>();
        inOrderTraversal(root, sortedValues);
        return build(sortedValues, 0, sortedValues.size()-1);

    }

    private static TreeNode build(final List<Integer> sortedValues, final int left, final int right) {
        if(left > right) {
            return null;
        }
        final int mid = (left + right) / 2;
        final TreeNode leftNode = build(sortedValues, left, mid - 1);
        final TreeNode rightNode = build(sortedValues, mid + 1, right);
        final TreeNode node = new TreeNode(sortedValues.get(mid));
        node.left = leftNode;
        node.right = rightNode;
        return node;
    }

    private static void inOrderTraversal (final TreeNode root, final List<Integer> values) {
        // Perform an inorder traversal to store the elements in sorted order
        if(root == null) {
            return;
        }
        inOrderTraversal(root.left, values);
        values.add(root.getVal());
        inOrderTraversal(root.right, values);
    }
}

package leetcode.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 11.03.2023
 **/
public class SortedListToBST_109 {

    public static void main(String[] args) {

    }

    public static TreeNode sortedListToBST(final ListNode head) {
        final List<Integer> elements = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            elements.add(node.val);
            node = node.next;
        }
        return listToBST(elements, 0, elements.size()-1);
    }

    public static TreeNode listToBST(final List<Integer> elements, final int start, final int end) {
        if(start > end) {
            return null;
        }
        final int mid = (start + end)/2;
        final TreeNode node = new TreeNode(elements.get(mid));
        node.left = listToBST(elements, start, mid-1);
        node.right = listToBST(elements, mid+1, end);
        return node;

    }




    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {}
        public ListNode(final int x) {this.val = x;}
        public ListNode(final int x, final ListNode next) {
            this.val = x;
            this.next = next;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode() {}
        public TreeNode(final int val) {this.val = val;}
        public TreeNode(final int val, final TreeNode left, final TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }
}

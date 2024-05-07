package leetcode.collections;

import leetcode.structures.ListNode;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 07.05.2024
 **/
public class DoubleANumberRepresentedAsALinkedList_2816 {

    public static void main(String[] args) {

    }

    //Time complexity O(2n) and Space is O(1)
    public static ListNode doubleIT(final ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        curr = prev;
        prev = null;
        int leftOver = 0;
        while(curr != null) {
            final int res = curr.val * 2 + leftOver;
            curr.val = res % 10;
            leftOver = res / 10;
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        if(leftOver != 0) {
            curr = new ListNode(leftOver);
            curr.next = prev;
        } else {
            curr = prev;
        }
        return curr;
    }
}

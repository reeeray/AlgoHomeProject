package leetcode.collections;

import java.util.HashSet;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 09.03.2023
 **/
public class LinkedListCycle_142 {

    public static void main(String[] args) {

    }

    private static ListNode detectCycle(final ListNode head) {
        final Set<ListNode> nodes = new HashSet<>();
        ListNode node = head;
        while (node != null) {
            if (nodes.add(node)) {
                node = node.next;
            } else {
                return node;
            }
        }
        return null;
    }

    //Floyd's cycle finding algorithm
    private static ListNode detectCycleEfficient(final ListNode head) {
        if (head == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                slow = head;
                while (slow != fast) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }


    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(final int x) {
            this.val = x;
            this.next = null;
        }
    }
}

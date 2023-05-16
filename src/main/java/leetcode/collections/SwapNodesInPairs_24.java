package leetcode.collections;

import leetcode.structures.ListNode;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 16.05.2023
 **/
public class SwapNodesInPairs_24 {

    public static void main(String[] args) {

    }

    private static ListNode swapPairs(final ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        final ListNode fake = new ListNode();
        fake.next = head;
        ListNode chainStop = fake;
        while(chainStop.next != null && chainStop.next.next != null) {
            final ListNode from = chainStop.next;
            final ListNode to = chainStop.next.next;
            chainStop.next = to;
            from.next = to.next;
            to.next = from;
            chainStop = from;
        }
        return fake.next;
    }
}

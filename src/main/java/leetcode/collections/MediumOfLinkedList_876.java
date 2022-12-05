package leetcode.collections;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 05.12.2022
 **/
public class MediumOfLinkedList_876 {


    public static void main(String[] args) {
        final ListNode head = new ListNode(1);
        ListNode next = head;
        for(int i=2; i<7; i++) {
            final ListNode n = new ListNode(i);
            next.next = n;
            next = next.next;
        }
        assert 4 == middleNode(head).val;
    }

    private static ListNode middleNode(final ListNode head) {
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

      //Definition for singly-linked list.
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
}

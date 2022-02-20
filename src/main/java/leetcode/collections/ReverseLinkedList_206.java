package leetcode.collections;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 13.02.2022
 **/
public class ReverseLinkedList_206 {


    public static void main(String[] args) {
        final ListNode node1 = new ListNode(1);
        final ListNode node2 = new ListNode(2);
        final ListNode node3 = new ListNode(3);
        final ListNode node4 = new ListNode(4);
        final ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(reverseListRecursion(node1).val);
    }


    public static ListNode reverseListRecursion(ListNode head) {
        final ListNode last = head;
        if (head.next != null) {
            head = reverseListRecursion(head.next);
            ListNode iter = head;
            while (iter.next != null) {
                iter = iter.next;
            }
            last.next = null;
            iter.next = last;
        }
        return head;
    }

    public ListNode reverseListIteration(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

package leetcode.collections;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 31.03.2022
 **/
public class AddTwoNumbers_2 {

    public static void main(String[] args) {

    }

    public static ListNode addTwoNumbersImproved(ListNode l1, ListNode l2) {
        final ListNode res = new ListNode();
        ListNode prev = res;
        int remains = 0;
        while (l1 != null || l2 != null || remains != 0) {
            int n1 = 0;
            int n2 = 0;
            if (l1 != null) {
                n1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                n2 = l2.val;
                l2 = l2.next;
            }
            remains = n1 + n2 + remains;
            final ListNode node = new ListNode(remains % 10);
            prev.next = node;
            prev = node;
            remains = remains > 9 ? 1 : 0;
        }
        return res.next == null ? new ListNode(0) : res.next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        final StringBuilder reverseOne = new StringBuilder();
        final StringBuilder reverseTwo = new StringBuilder();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                reverseOne.append(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                reverseTwo.append(l2.val);
                l2 = l2.next;
            }
        }

        long sum = Long.parseLong(reverseOne.reverse().toString()) + Long.parseLong(reverseTwo.reverse().toString());
        ListNode res = new ListNode();
        ListNode prev = res;
        while (sum != 0) {
            ListNode node = new ListNode();
            node.val = (int) sum % 10;
            sum /= 10;
            prev.next = node;
            prev = node;
        }
        if (res.next == null)
            res.val = 0;
        else
            res = res.next;
        return res;

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

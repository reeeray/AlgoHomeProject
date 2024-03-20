package leetcode.collections;

import leetcode.structures.ListNode;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 20.03.2024
 **/
public class MergeInBetweenLinkedLists_1669 {

    public static void main(String[] args) {
        final ListNode left1 = new ListNode(10);
        final ListNode left2 = new ListNode(1);
        final ListNode left3 = new ListNode(13);
        final ListNode left4 = new ListNode(6);
        final ListNode left5 = new ListNode(9);
        final ListNode left6 = new ListNode(5);
        left1.next = left2;
        left2.next = left3;
        left3.next = left4;
        left4.next = left5;
        left5.next = left6;
        final ListNode right1 = new ListNode(1000000);
        final ListNode right2 = new ListNode(1000001);
        final ListNode right3 = new ListNode(1000002);
        right1.next = right2;
        right2.next = right3;
        mergeInBetween(left1, 3, 4, right1);

    }

    public static ListNode mergeInBetween(final ListNode list1, final int a, final int b, final ListNode list2) {
        ListNode curr = list1;
        ListNode fromA = null;
        ListNode toB = null;
        int i = 1;
        while (i <= b) {
            if(i == a) {
                fromA = curr;
            }
            if(i == b) {
                toB = curr.next.next;
            }
            curr = curr.next;
            i++;
        }
        curr = list2;
        while (curr.next != null) {
            curr = curr.next;
        }
        fromA.next = list2;
        curr.next = toB;
        return list1;
    }
}

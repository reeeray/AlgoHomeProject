package leetcode.collections;

import leetcode.structures.ListNode;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 04.07.2024
 **/
public class MergeNodesInBetweenZeros_2181 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(1)
    public static ListNode mergeNodes(final ListNode head) {
        ListNode curr = head;
        ListNode updated = head;
        int sum = 0;
        while (curr != null) {
            if(curr.val == 0 && sum != 0) {
                updated = updated.next;
                updated.val = sum;
                sum = 0;
            }
            sum += curr.val;
            curr = curr.next;
        }
        updated.next = null;
        return head.next;
    }
}

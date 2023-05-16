package leetcode.structures;

import lombok.NoArgsConstructor;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 16.05.2023
 **/

@NoArgsConstructor
public class ListNode {

    public int val;
    public ListNode next;
    public ListNode(final int val) {
        this.val = val;
    }

    public ListNode(final int val, final ListNode node) {
        this.val = val;
        this.next = node;
    }
}

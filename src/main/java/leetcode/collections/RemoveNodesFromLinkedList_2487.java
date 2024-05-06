package leetcode.collections;

import leetcode.structures.ListNode;

import java.util.Stack;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 06.05.2024
 **/
public class RemoveNodesFromLinkedList_2487 {

    public static void main(String[] args) {

    }

    public static ListNode removeNodes(final ListNode head) {
        final Stack<ListNode> iterator = new Stack<>();
        ListNode node = head;
        while (node != null) {
            iterator.add(node);
            node = node.next;
        }
        node = iterator.pop();
        int max = node.val;

        while(!iterator.isEmpty()) {
            ListNode curr = iterator.pop();
            if(curr.val >= max) {
                max = curr.val;
                curr.next = node;
                node = curr;
            }
        }
        return node;
    }
}

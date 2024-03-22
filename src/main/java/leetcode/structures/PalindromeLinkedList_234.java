package leetcode.structures;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 22.03.2024
 **/
public class PalindromeLinkedList_234 {

    public static void main(String[] args) {
        final ListNode node1 = new ListNode(1);
        final ListNode node2 = new ListNode(1);
        final ListNode node3 = new ListNode(2);
        final ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        isPalindrome(node1);
        }

    //Time complexity O(n) and Space O(1)
    public static boolean isPalindrome(final ListNode head) {
//        final StringBuilder sb = new StringBuilder();
//        while(head != null) {
//            sb.append((char)head.val);
//            head = head.next;
//        }
//        return sb.toString().equals(sb.reverse().toString());
        ListNode slow = head, fast = head, prev, temp;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        prev = slow;
        slow = slow.next;
        prev.next = null;
        while (slow != null) {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        fast = head;
        slow = prev;
        while (slow != null) {
            if (fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
}

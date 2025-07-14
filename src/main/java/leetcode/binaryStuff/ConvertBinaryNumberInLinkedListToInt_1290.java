package leetcode.binaryStuff;

import leetcode.structures.ListNode;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 14.07.2025
 **/
public class ConvertBinaryNumberInLinkedListToInt_1290 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(1)
    public static int getDecimalValueSpaceOptimized(ListNode head) {
        int res = head.val;
        while (head.next != null) {
            res = res << 1 | head.next.val;
            head = head.next;
        }
        return res;
    }

    //Time O(n) and Space O(n)
    public static int getDecimalValue(ListNode head) {
        final StringBuilder sb = new StringBuilder();
        while(head != null) {
            sb.append(head.val);
            head = head.next;
        }
        return Integer.valueOf(sb.toString(), 2);
    }
}

package leetcode.collections;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 10.03.2023
 **/
public class LinkedListRandomNode_382 {

    public static void main(String[] args) {
        randInRange(1, 3);
    }

    private static int getRandom(final ListNode head) {
        int count = 0;
        int res = -1;
        ListNode curr = head;
        while (curr != null) {
            count++;

            if(randInRange(1, count) == 1) {
                res = curr.val;
            }
            curr = curr.next;
        }
        return res;
    }

    private static int randInRange(final int min, final int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }


    private static class ListNode {

        int val;
        ListNode next;


        public ListNode(final int x) {
            this.val = x;
            this.next = null;
        }
    }

}

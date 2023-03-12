package leetcode.collections;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 12.03.2023
 **/
public class MergeKSortedLists_23 {

    public static void main(String[] args) {

    }

    public static ListNode mergeKLists(final ListNode[] lists) {
        ListNode last = null;
        ListNode head = null;
        while (true) {
            int currIndex = -1;
            for(int k=0; k<lists.length; k++) {
                if(lists[k] != null) {
                    currIndex = currIndex == -1 ? k : lists[currIndex].val > lists[k].val ? k : currIndex;
                }
            }
            if(currIndex == -1) {
                break;
            }
            final ListNode curr = lists[currIndex];
            lists[currIndex] = curr.next;
            if(head == null) {
                head = curr;
                last = curr;
            } else {
                last.next = curr;
                last = curr;
            }
        }
        return head;
    }

    public ListNode mergeKListsEff(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return helper(lists, 0, lists.length - 1);
    }

    public ListNode helper(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = (start+end) / 2;
        ListNode left = helper(lists, start, mid);
        ListNode right = helper(lists, mid + 1, end);
        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while (left != null && right != null) {
            if (left.val < right.val) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        while (left != null) {
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }
        while (right != null) {
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }
        return head.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {}
        public ListNode(final int val) {this.val = val;}
        public ListNode(final int val, final ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

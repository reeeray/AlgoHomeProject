package leetcode.collections;

import java.util.HashSet;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 06.06.2022
 **/
public class IntersectionOfTwoLinkedLists_160 {


//      Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        final Set<ListNode> unique = new HashSet<>();

        while(headA != null) {
            unique.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if(!unique.add(headB))
                return headB;
            headB = headB.next;
        }
        return null;
    }
}

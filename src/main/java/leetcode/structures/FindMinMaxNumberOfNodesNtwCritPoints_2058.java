package leetcode.structures;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 05.07.2024
 **/
public class FindMinMaxNumberOfNodesNtwCritPoints_2058 {

    public static void main(String[] args) {

    }

    public int[] nodesBetweeCriticalPoints(final ListNode head) {
        final int[] ans = new int[] {-1, -1};
        int firstIndex = -1;
        int lastIndex = -1;
        int prevVal = head.val;
        int index = 1;
        int minDiff = Integer.MAX_VALUE;
        ListNode curr = head.next;
        while(curr != null && curr.next != null) {
            final int currVal = curr.val;
            final int nextVal = curr.next.val;
            if((currVal > prevVal && currVal > nextVal) || (currVal < prevVal && currVal < nextVal)) {
                if(lastIndex != -1 && minDiff > index - lastIndex) {
                    minDiff = index - lastIndex;
                }
                if(firstIndex == - 1) {
                    firstIndex = index;
                }
                lastIndex = index;
            }
            index++;
            prevVal = currVal;
            curr = curr.next;
        }
        if(minDiff != Integer.MAX_VALUE) {
            ans[1] = lastIndex - firstIndex;
            ans[0] = minDiff;
        }
        return ans;
    }
}

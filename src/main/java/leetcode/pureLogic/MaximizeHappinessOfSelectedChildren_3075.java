package leetcode.pureLogic;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 09.05.2024
 **/
public class MaximizeHappinessOfSelectedChildren_3075 {

    public static void main(String[] args) {

    }

    public static long maximumHappinessSum(final int[] happiness, final int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int h : happiness) {
            pq.add(h);
        }
        int turn = 0;
        long maxH = 0;
        for(int i=0; i<k; i++) {
            maxH += Math.max(pq.poll() - turn++, 0);
        }
        return maxH;
    }
}

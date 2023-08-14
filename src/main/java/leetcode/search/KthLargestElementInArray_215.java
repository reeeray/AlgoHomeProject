package leetcode.search;

import java.util.PriorityQueue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 14.08.2023
 **/
public class KthLargestElementInArray_215 {

    public static void main(String[] args) {

    }

    public static int findKthLargest(final int[] nums, final int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : nums) {
            pq.offer(n);
            if(pq.size() > k) {
                pq.remove();
            }
        }
        return pq.peek();
    }
}

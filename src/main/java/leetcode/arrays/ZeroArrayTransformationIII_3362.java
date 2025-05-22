package leetcode.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 22.05.2025
 **/
public class ZeroArrayTransformationIII_3362 {

    public static void main(String[] args) {
        maxRemoval(new int[] {2,0,2}, new int[][] {{0,2},{0,2},{1,1}});
    }

    //Time O(n + mlogm) where n is a length of nums and m length of queries, Space O(n + m)
    public static int maxRemoval(final int[] nums, final int[][] queries) {
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        final PriorityQueue<Integer> heap = new PriorityQueue<>(
                Collections.reverseOrder()
        );
        final int[] ranges = new int[nums.length + 1];
        int operations = 0;

        for (int i = 0, j = 0; i < nums.length; i++) {
            operations += ranges[i];
            while (j < queries.length && queries[j][0] == i) {
                heap.offer(queries[j][1]);
                j++;
            }
            while (operations < nums[i] && !heap.isEmpty() && heap.peek() >= i) {
                operations += 1;
                ranges[heap.poll() + 1] -= 1;
            }
            if (operations < nums[i]) {
                return -1;
            }
        }
        return heap.size();
    }
}

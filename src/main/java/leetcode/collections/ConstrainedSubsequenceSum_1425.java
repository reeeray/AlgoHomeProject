package leetcode.collections;

import java.util.PriorityQueue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 21.10.2023
 **/
public class ConstrainedSubsequenceSum_1425 {

    public static void main(String[] args) {
        final int[] input = new int[] {10, 2, -10, 5, 20};
        constraintSubsetSum(input, 2);
    }

    public static int constraintSubsetSum(final int[] nums, final int k) {
        final PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0]-a[0]);
        heap.add(new int[]{nums[0], 0});
        int ans = nums[0];

        for(int i=1; i<nums.length; i++) {
            while (i - heap.peek()[1] > k) {
                heap.remove();
            }
            final int curr = Math.max(0, heap.peek()[0]) + nums[i];
            ans = Math.max(ans, curr);
            heap.add(new int[]{curr, i});
        }
        return ans;
    }
}

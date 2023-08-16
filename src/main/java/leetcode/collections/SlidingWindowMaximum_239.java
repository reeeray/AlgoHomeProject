package leetcode.collections;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 16.08.2023
 **/
public class SlidingWindowMaximum_239 {

    public static void main(String[] args) {
        final int[] input = {1,3,-1,-3,5,3,6,7};
        maxSlidingindow(input, 3);
        assert Arrays.equals(new int[]{3, 3, 5, 5, 6, 6}, maxSlidingindow(input, 3));
    }

    public static int[] maxSlidingindow(final int[] nums, final int k) {
        final Deque<Integer> dq = new ArrayDeque<>();
        final List<Integer> res = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        res.add(nums[dq.peekFirst()]);

        for (int i = k; i < nums.length; i++) {
            if (dq.peekFirst() == i - k) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }

            dq.offerLast(i);
            res.add(nums[dq.peekFirst()]);
        }
        // Return the result as an array.
        return res.stream().mapToInt(i->i).toArray();
    }
}

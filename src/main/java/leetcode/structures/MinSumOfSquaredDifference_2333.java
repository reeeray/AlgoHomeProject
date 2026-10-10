package leetcode.structures;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 10.10.2026
 **/
public class MinSumOfSquaredDifference_2333 {

    public static void main(String[] args) {

    }

    //Greedy which passes
    public long minSumSquareDiffOpt(final int[] nums1, final int[] nums2, final int k1, final int k2) {
        final int[] diff = new int[100001];
        long k = (long) k1 + k2, sum = 0;
        int max = 0;

        // Step 1: count the differences
        for (int i = 0; i < nums1.length; i++) {
            final int x = Math.abs(nums1[i] - nums2[i]);
            diff[x]++;
            sum += x;
            max = Math.max(max, x);
        }

        // Enough budget -> every difference becomes 0
        if (sum <= k) return 0;

        // Step 2: shave the biggest differences, level by level
        for (int i = max; i > 0 && k > 0; i--) {
            final long move = Math.min(k, diff[i]);
            diff[i] -= move;
            diff[i - 1] += move;
            k -= move;
        }

        // Step 3: add up the squares
        long res = 0;
        for (int i = 0; i <= max; i++)
            res += (long) i * i * diff[i];

        return res;
    }

    //TLE
    public static long minSumSquareDiff(final int[] nums1, final int[] nums2, final int k1, final int k2) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long sum = 0;
        for(int i = 0; i < nums1.length; i++) {
            final int diff = Math.abs(nums1[i] - nums2[i]);
            sum += diff;
            pq.add(diff);
        }
        long k = k1 + k2;
        if(sum <= k) return 0;
        while (k > 0) {
            final int top = pq.poll();
            final int next = pq.peek();
            final int subst = Math.min((int)k, (top - next) + 1);
            k -= subst;
            pq.add(top - subst);
        }
        long res = 0;
        while (!pq.isEmpty()) {
            final int val = pq.poll();
            res += val * 1l * val;
        }
        return res;
    }
}

package leetcode.dfs;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 24.05.2023
 **/
public class MaxSubsequenceScore_2542 {

    private static long result = -1;

    public static void main(String[] args) {
        final int[] nums1 = {1, 3, 3, 2};
        final int[] nums2 = {2, 1, 3, 4};
        System.out.println(maxScoreEff(nums1, nums2, 3));
    }

    public static long maxScore(final int[] nums1, final int[] nums2, final int k) {
        dfs(nums1, nums2, k, 0, 0, 0, Integer.MAX_VALUE);
        return result;
    }

    private static void dfs(final int[] nums1, final int[] nums2, final int limit, final int index, final int count, final long sum, final int minMult) {
        if(count == limit) {
            result = Math.max(result, sum*minMult);
            return;
        }

        for(int i=index; i<=nums1.length-(limit-count); i++) {
            dfs(nums1, nums2, limit, i+1, count+1, sum+nums1[i], Math.min(minMult, nums2[i]));
        }
    }

    public static long maxScoreEff(final int[] nums1, final int[] nums2, final int k) {
        final int n = nums1.length;
        final int[][] pairs = new int[n][2];
        for(int i=0; i<n; i++) { //O(n)
            pairs[i] = new int[] {nums1[i], nums2[i]};
        }
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]); // O(nlogn)

        final PriorityQueue<Integer> heapKelements = new PriorityQueue<>();
        long sumKelements = 0;
        for(int i=0; i<k; i++) {
            heapKelements.add(pairs[i][0]);
            sumKelements += pairs[i][0];
        }
        int min = pairs[k-1][1];
        long res = sumKelements * min;

        for(int i=k; i<n; i++) {
            sumKelements += pairs[i][0] - heapKelements.poll();
            heapKelements.add(pairs[i][0]);
            min = pairs[i][1];
            res = Math.max(res, sumKelements * min);
        }
        return res;
    }
}

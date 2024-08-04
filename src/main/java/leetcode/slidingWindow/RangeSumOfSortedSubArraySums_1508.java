package leetcode.slidingWindow;

import java.util.*;
import java.util.stream.Stream;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 04.08.2024
 **/
public class RangeSumOfSortedSubArraySums_1508 {

    public static void main(String[] args) {
        System.out.println(rangeSum(new int[] {1, 2, 3, 4}, 4, 1, 10));
    }

    //Space O(n^2) and Time O(n^2 log n)
    public static int rangeSum(final int[] sums, final int n, final int left, final int right) {
        final int mod = 1_000_000_007;
        final int nL = n * (n + 1) / 2;
        final int[] sumSequence = new int[nL];
        sumSequence[0] = sums[0];
        for(int i=1;i<n; i++) {
            sumSequence[i] = sumSequence[i - 1] + sums[i];
        }
        int idx = n;
        int l = 1;
        int currL = l;
        int r = n - 1;
        while(idx < nL && l <= r) {
            sumSequence[idx++] = sumSequence[currL] - sumSequence[l - 1];
            if(currL++ == r) {
                currL = ++l;
            }
        }
        Arrays.sort(sumSequence);
        int ans = 0;
        for(int i = left-1; i<right; i++) {
            ans = (ans + sumSequence[i]) % mod;
        }
        return ans;
    }

    //Time is still O(n^2 logn) but space is O(n)
    public int rangeSumPrioQueue(int[] nums, int n, int left, int right) {
        final PriorityQueue<int[]> pq = new PriorityQueue<>(
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[0] - o2[0];
                    }
                }
        );
        for (int i = 0; i < n; i++) {
            pq.offer(new int[] { nums[i], i });
        }

        int ans = 0, mod = 1000000007;
        for (int i = 1; i <= right; i++) {
            final int[] p = pq.poll();
            if (i >= left) ans = (ans + p[0]) % mod;
            if (p[1] < n - 1) {
                p[0] += nums[++p[1]];
                pq.offer(p);
            }
        }
        return ans;
    }

    private static final int MOD = 1000000007;

    //With binary search and sliding window Time becomes O(nlog sum) where sum is total sum of the nums. annd Time O(1)
    public int rangeSumBinarySearchAndSlidingWindow(int[] nums, int n, int left, int right) {
        long result =
                (sumOfFirstK(nums, n, right) - sumOfFirstK(nums, n, left - 1)) %
                        MOD;
        // Ensure non-negative result
        return (int) ((result + MOD) % MOD);
    }

    // Helper function to count subarrays with sum <= target and their total sum.
    private Map.Entry<Integer, Long> countAndSum(final int[] nums, final int n, final int target) {
        int count = 0;
        long currentSum = 0, totalSum = 0, windowSum = 0;
        for (int j = 0, i = 0; j < n; ++j) {
            currentSum += nums[j];
            windowSum += nums[j] * (j - i + 1);
            while (currentSum > target) {
                windowSum -= currentSum;
                currentSum -= nums[i++];
            }
            count += j - i + 1;
            totalSum += windowSum;
        }
        return new AbstractMap.SimpleEntry<>(count, totalSum);
    }

    // Helper function to find the sum of the first k smallest subarray sums.
    private long sumOfFirstK(int[] nums, int n, int k) {
        int minSum = Arrays.stream(nums).min().getAsInt();
        int maxSum = Arrays.stream(nums).sum();
        int left = minSum, right = maxSum;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (countAndSum(nums, n, mid).getKey() >= k) right = mid - 1;
            else left = mid + 1;
        }
        final Map.Entry<Integer, Long> result = countAndSum(nums, n, left);
        // There can be more subarrays with the same sum of left.
        return result.getValue() - left * (result.getKey() - k);
    }
}

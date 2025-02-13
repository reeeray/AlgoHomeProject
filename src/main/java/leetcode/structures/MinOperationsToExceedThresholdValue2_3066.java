package leetcode.structures;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 13.02.2025
 **/
public class MinOperationsToExceedThresholdValue2_3066 {

    public static void main(String[] args) {
        final int[] input = new int[] {2,11,10,1,3};
        minOperations(input, 10);
    }

    //Time O(nlogn) and Space O(n)
    public static int minOperations(final int[] nums, final int k) {
        final PriorityQueue<Long> ordered = new PriorityQueue<>();
        for(final int num : nums) {
            ordered.add(num*1L);
        }
        int numOfOperations = 0;
        while (ordered.size() >= 2 && ordered.peek() < k) {
            final long val1 = ordered.poll();
            final long val2 = ordered.poll();
            ordered.add((Math.min(val1, val2) * 2) + Math.max(val1, val2));
            numOfOperations++;
        }
        return numOfOperations;
    }

    public int minOperationsStreams(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<Long>(
                Arrays.stream(nums)
                        .mapToLong(i -> (long) i)
                        .boxed()
                        .collect(Collectors.toList())
        );
        int numOperations = 0;

        while (minHeap.peek() < k) {
            long x = minHeap.remove();
            long y = minHeap.remove();
            minHeap.add(Math.min(x, y) * 2 + Math.max(x, y));

            numOperations++;
        }
        return numOperations;
    }
}

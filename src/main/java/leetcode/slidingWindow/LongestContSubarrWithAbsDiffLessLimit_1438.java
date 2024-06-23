package leetcode.slidingWindow;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 23.06.2024
 **/
public class LongestContSubarrWithAbsDiffLessLimit_1438 {

    public static void main(String[] args) {

    }

    //Time O(nlog(n) and Space O(n)
    public int longestSubarray(final int[] nums, final int limit) {
        final PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        final PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int left = 0, maxLength = 0;
        // Check if the absolute difference between the maximum and minimum values in the current window exceeds the limit
        for(int right=0; right<nums.length; right++) {
            maxHeap.offer(new int[]{nums[right], right});
            minHeap.offer(new int[]{nums[right], right});

            while (maxHeap.peek()[0] - minHeap.peek()[0] > limit) {
                // Move the left pointer to the right until the condition is satisfied.
                // This ensures we remove the element causing the violation, we want to find the closest min element by index, it could be that we increase min or decrease max depends what closer
                left = Math.min(maxHeap.peek()[1], minHeap.peek()[1]);

                // Remove elements from the heaps that are outside the current window
                while(maxHeap.peek()[1] < left) {
                    maxHeap.poll();
                }
                while (minHeap.peek()[1] < right) {
                    minHeap.poll();
                }
            }
            // Update maxLength with the length of the current valid window
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    //the same but via tree map, complexity stays the same
    public int longestSubarrayViaMap(final int[] nums, final int limit) {
        // TreeMap to maintain the elements within the current window
        final TreeMap<Integer, Integer> window = new TreeMap<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            window.put(nums[right], window.getOrDefault(nums[right], 0) + 1);

            // Check if the absolute difference between the maximum and minimum values in the current window exceeds the limit
            while (window.lastKey() - window.firstKey() > limit) {
                // Remove the element at the left pointer from the TreeMap
                window.put(nums[left], window.get(nums[left]) - 1);
                if (window.get(nums[left]) == 0) {
                    window.remove(nums[left]);
                }
                // Move the left pointer to the right to exclude the element causing the violation
                left++;
            }

            // Update maxLength with the length of the current valid window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    //Approach with two deques as data structure improves time complexity. Time is O(n) and Space is O(n)
    public int longestSubarrayViaTwiDeques(final int[] nums, final int limit) {
        final Deque<Integer> maxDeque = new LinkedList<>();
        final Deque<Integer> minDeque = new LinkedList<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            // Maintain the maxDeque in decreasing order
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(nums[right]);

            // Maintain the minDeque in increasing order
            while (!minDeque.isEmpty() && minDeque.peekLast() > nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(nums[right]);

            // Check if the current window exceeds the limit
            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                // Remove the elements that are out of the current window
                if (maxDeque.peekFirst() == nums[left]) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() == nums[left]) {
                    minDeque.pollFirst();
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

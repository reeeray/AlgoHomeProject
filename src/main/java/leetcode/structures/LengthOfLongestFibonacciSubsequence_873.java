package leetcode.structures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 27.02.2025
 **/
public class LengthOfLongestFibonacciSubsequence_873 {

    public static void main(String[] args) {
        final int[] input = new int[] {2,4,7,8,9,10,14,15,18,23,32,50};
        lenLongestFibSubsequence(input);
    }

    //Bture force Time O(n^2 * log M) and Space O(n^2)
    public static int lenLongestFibSubseq(final int[] arr) {
        // Store array elements in set for O(1) lookup
        final Set<Integer> numSet = new HashSet<>();
        for (int num : arr) {
            numSet.add(num);
        }

        int maxLen = 0;
        // Try all possible first two numbers of sequence
        for (int f = 0; f < arr.length - 2; f++) {
            for (int s = f + 1; s < arr.length - 1; s++) {
                // Start with first two numbers
                int prev = arr[s];
                int curr = arr[f] + arr[s];
                int len = 2;

                // Keep finding next Fibonacci number
                while (numSet.contains(curr)) {
                    // Update values for next iteration
                    int temp = curr;
                    curr += prev;
                    prev = temp;
                    maxLen = Math.max(maxLen, ++len);
                }
            }
        }

        return maxLen;
    }

    //Misunderstanding of task description
    public static int lenLongestFibSubsequence(final int[] arr) {
        if(arr.length < 3) {
            return 0;
        }
        final Map<Integer, int[]> subSeq = new HashMap<>();
        int longest = 2;
        subSeq.put(arr[0] + arr[1], new int[] {arr[1], 2});
        for(int i = 2; i < arr.length; i++) {
            if(subSeq.containsKey(arr[i])) {
                final int newElement = subSeq.get(arr[i])[0] + arr[i];
                final int newLen = subSeq.get(arr[i])[1] + 1;
                subSeq.putIfAbsent(newElement, new int[]{arr[i], newLen});
                longest = Math.max(longest, newLen);
            }
            subSeq.putIfAbsent(arr[i] + arr[i - 1], new int[] {arr[i], 2});
        }
        return longest;
    }
}

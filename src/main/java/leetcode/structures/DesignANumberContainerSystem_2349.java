package leetcode.structures;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 08.02.2025
 **/
public class DesignANumberContainerSystem_2349 {

    public static void main(String[] args) {

    }

    // Map to store number -> min heap of indices
    private Map<Integer, PriorityQueue<Integer>> numberToIndices;
    // Map to store index -> number
    private Map<Integer, Integer> indexToNumbers;

    public DesignANumberContainerSystem_2349() {
        numberToIndices = new HashMap<>();
        indexToNumbers = new HashMap<>();
    }

    public void change(int index, int number) {
        // Update index to number mapping
        indexToNumbers.put(index, number);

        // Add index to the min heap for this number
        numberToIndices
                .computeIfAbsent(number, k -> new PriorityQueue<>())
                .add(index);
    }

    public int find(int number) {
        // If number doesn't exist in our map
        if (!numberToIndices.containsKey(number)) {
            return -1;
        }

        // Get min heap for this number
        PriorityQueue<Integer> minHeap = numberToIndices.get(number);

        // Keep checking top element until we find valid index
        while (!minHeap.isEmpty()) {
            int index = minHeap.peek();

            // If index still maps to our target number, return it
            if (indexToNumbers.get(index) == number) {
                return index;
            }

            // Otherwise remove this stale index
            minHeap.poll();
        }

        return -1;
    }
}

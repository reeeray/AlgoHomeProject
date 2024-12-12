package leetcode.structures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 12.12.2024
 **/
public class TakeGiftsFromTheRichestPile_2558 {

    public static void main(String[] args) {
        pickGiftsOptimized(new int[] {25, 64, 9, 4, 99}, 4);
    }

    //Time O(n + k) and Space O(n)
    public static long pickGiftsOptimized(final int[] gifts, int k) {
        long sum = 0;
        final PriorityQueue<Integer> sortedVals = new PriorityQueue<>(Comparator.reverseOrder());
        for(final int gift : gifts) {
            sum += gift;
            sortedVals.add(gift);
        }

        while(k-- > 0) {
            final int val = sortedVals.poll();
            final int sq = (int)Math.sqrt(val);
            sum -= (val - sq);
            sortedVals.add(sq);
        }
        return sum;
    }

    public long pickGifts(int[] gifts, int k) {
        // Convert int[] to List<Integer> manually for efficient initialization of the heap
        // Negate values to simulate max-heap
        List<Integer> giftsList = new ArrayList<>();
        for (int gift : gifts) {
            giftsList.add(-gift);
        }

        // Initialize giftsHeap from giftsList
        PriorityQueue<Integer> giftsHeap = new PriorityQueue<>(giftsList);
        // Perform the operation 'k' times
        for (int i = 0; i < k; i++) {
            // Get the maximum element from the heap (top element)
            int maxElement = -giftsHeap.poll();

            // Insert the floor of the square root of the maximum element back into the heap
            giftsHeap.offer(-(int) Math.sqrt(maxElement));
        }

        // Accumulate the sum of the elements in the heap
        long numberOfRemainingGifts = 0;
        while (!giftsHeap.isEmpty()) {
            numberOfRemainingGifts -= giftsHeap.poll();
        }

        return numberOfRemainingGifts;
    }
}

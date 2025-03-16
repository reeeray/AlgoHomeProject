package leetcode.arrays.binarySearch;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 16.03.2025
 **/
public class MinTimeToRepairars_2594 {

    public static void main(String[] args) {

    }

    //Time O(nlogm*max_rank)) and Space O(1) where n the size of the ranks and m number of cars and k is max possible rank( 100 in this case)
    public long repairCarsSpaceOptimized(final int[] ranks, final int cars) {
        // The minimum possible time is 1,
        // and the maximum possible time is when the slowest mechanic (highest rank) repairs all cars.
        long low = 1, high = 1L * ranks[0] * cars * cars;

        // Perform binary search to find the minimum time required.
        while (low < high) {
            long mid = (low + high) / 2, carsRepaired = 0;

            // Calculate the number of cars that can be repaired in 'mid' time by all mechanics.
            for (int rank : ranks) carsRepaired += (long) (Math.sqrt(
                    (1.0 * mid) / rank
            ));

            // If the total cars repaired is less than required, increase the time.
            if (carsRepaired < cars) low = mid + 1;
            else high = mid; // Otherwise, try a smaller time.
        }

        return low;
    }

    public long repairCarsOptimized(int[] ranks, int cars) {
        // Count the frequency of each rank
        Map<Integer, Integer> count = new HashMap<>();
        for (int rank : ranks) {
            count.put(rank, count.getOrDefault(rank, 0) + 1);
        }

        // Create a Min-heap storing [time, rank, n, count]
        // - time: time for the next repair
        // - rank: mechanic's rank
        // - n: cars repaired by this mechanic
        // - count: number of mechanics with this rank
        // Initial time = rank (as rank * 1^2 = rank)
        PriorityQueue<long[]> minHeap = new PriorityQueue<>((a, b) ->
                Long.compare(a[0], b[0])
        );

        // Add initial entries to the heap
        for (int rank : count.keySet()) {
            // Elements: [time, rank, cars_repaired, mechanic_count]
            minHeap.offer(new long[] { rank, rank, 1, count.get(rank) });
        }

        long time = 0;
        // Process until all cars are repaired
        while (cars > 0) {
            // Pop the mechanic with the smallest current repair time
            long[] current = minHeap.poll();
            time = current[0];
            int rank = (int) current[1];
            long n = current[2];
            int mechCount = (int) current[3];

            // Deduct the number of cars repaired by this mechanic group
            cars -= mechCount;

            // Increment the number of cars repaired by this mechanic
            n += 1;

            // Push the updated repair time back into the heap
            // The new repair time is rank * n^2 (time increases quadratically with n)
            minHeap.offer(new long[] { rank * n * n, rank, n, mechCount });
        }

        return time;
    }

    public long repairCars(int[] ranks, int cars) {
        int minRank = ranks[0], maxRank = ranks[0];

        // Find min and max rank dynamically
        for (int rank : ranks) {
            minRank = Math.min(minRank, rank);
            maxRank = Math.max(maxRank, rank);
        }
        // Frequency array to count mechanics with each rank
        int[] freq = new int[maxRank + 1];
        for (int rank : ranks) {
            minRank = Math.min(minRank, rank);
            freq[rank]++;
        }

        // Minimum possible time, Maximum possible time
        long low = 1, high = 1L * minRank * cars * cars;

        // Perform binary search to find the minimum time required
        while (low < high) {
            long mid = (low + high) / 2;
            long carsRepaired = 0;

            // Calculate the total number of cars that can be repaired in 'mid' time
            for (int rank = 1; rank <= maxRank; rank++) {
                carsRepaired +=
                        freq[rank] * (long) Math.sqrt(mid / (long) rank);
            }

            // Adjust the search boundaries based on the number of cars repaired
            if (carsRepaired >= cars) {
                high = mid; // Try to find a smaller time
            } else {
                low = mid + 1; // Need more time
            }
        }

        return low;
    }
}

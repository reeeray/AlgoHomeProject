package leetcode;

import leetcode.structures.Pair;

import java.util.*;

/**
 * 787 : Cheapest Flights Within K Stops
 * There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.
 * <p>
 * Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.
 * User : Shein G.A.{@reeeray}
 * Date : 14.06.2020
 **/
public class Cheapest_Flights_Within_K_Stops_787 {

    public static void main(String[] args) {
        System.out.println(findCheapestPrice(5, new int[][]{{1, 2, 10}, {2, 0, 7}, {1, 3, 8}, {4, 0, 10}, {3, 4, 2}, {4, 2, 10}, {0, 3, 3}, {3, 1, 6}, {2, 4, 5}},
                0, 4, 1));
    }


    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[src] = 0;
        for (int i = 0; i <= K; i++) {
            int[] tmp = Arrays.copyOf(costs, n);
            for (int[] flight : flights) {
                int from = flight[0], to = flight[1], price = flight[2];
                if (costs[from] == Integer.MAX_VALUE)
                    continue;
                tmp[to] = Math.min(tmp[to], costs[from] + price);
            }
            costs = tmp;
        }
        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
    }

//    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
//         int[][] priceTable = new int[n][n];
//        for(int[] flight : flights) {
//            priceTable[flight[0]][flight[1]] = flight[2];
//        }
//
//        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0]-b[0]);
//        heap.offer(new int[]{0, src, K + 1});
//
//        while(!heap.isEmpty()) {
//            int[] curr = heap.poll();
//            int price = curr[0], place = curr[1], remainStops = curr[2];
//
//            if(place == dst) return price;
//
//            if(remainStops > 0) {
//                for(int i=0; i<n;i++) {
//                    if(priceTable[place][i] > 0) {
//                        heap.offer(new int[]{price + priceTable[place][i], i, remainStops - 1});
//                    }
//                }
//            }
//        }
//        return -1;
//    }

    public int findCheapestPriceLessEfficient(final int n, final int[][] flights, final int src, final int dst, final int k) {
        final Map<Integer, List<Pair<Integer, Integer>>> directions = new HashMap<>();
        for(final int[] flight : flights) {
            directions.computeIfAbsent(flight[0], v -> new ArrayList()).add(new Pair<>(flight[1], flight[2]));
        }
        final int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        final Queue<Integer> airports = new LinkedList<>();
        airports.add(src);
        costs[src] = 0;
        int changes = k;
        while (changes <= k && !airports.isEmpty()) {
            int nIter = airports.size();
            while (nIter-- > 0) {
                final int airport = airports.poll();
                if(directions.get(airport) == null) {
                    continue;
                }
                for(final Pair<Integer, Integer> neighbor : directions.get(airport)) {
                    if(costs[neighbor.getLeft()] > costs[airport] + neighbor.getRight()) {
                      costs[neighbor.getLeft()] = costs[airport] + neighbor.getRight();
                      airports.add(neighbor.getLeft());
                    }
                }
            }
            changes++;
        }
        return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
    }
}

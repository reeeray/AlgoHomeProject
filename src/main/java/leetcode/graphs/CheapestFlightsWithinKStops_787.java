package leetcode.graphs;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.01.2023
 **/
public class CheapestFlightsWithinKStops_787 {


    public static void main(String[] args) {
        final int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        findCheapestPrice(4, flights,0, 3, 1);

    }

    private static int findCheapestPrice(final int n, final int[][] flights, final int src, final int dst, final int k) {
        final Map<Integer, List<Pair>> directions = new HashMap<>();

        for(final int[] flight : flights) {
            directions.computeIfAbsent(flight[0], v -> new ArrayList<>());
            final Pair pair = new Pair(flight[1], flight[2]);
            directions.get(flight[0]).add(pair);
        }
        final int answer = dfs(directions, src, dst, k);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    //TLE
    private static int dfs(final Map<Integer, List<Pair>> directions, final int from, final int to, final int limit) {
        if(from == to) {
            return 0;
        }
        if(limit == -1 || directions.get(from) == null) {
            return Integer.MAX_VALUE;
        }
        final Optional<Pair> fastest = directions.get(from).stream().filter(p -> p.getKey() == to).findFirst();
        if(fastest.isPresent()) {
            return fastest.get().getValue();
        }
        int minPrice = Integer.MAX_VALUE;
        for(final Pair p : directions.get(from)) {
            final int price = dfs(directions, p.key, to, limit-1);
            if(price == Integer.MAX_VALUE) {
                continue;
            }
            minPrice = Math.min(minPrice, p.getValue() + price);
        }
        return minPrice;
    }

    //could be solved via Bellman-Ford or Deijkstra
    private static int bfs(final int n, final int[][] flights, final int src, final int dst, final int k) {
        final Map<Integer, List<Pair>> directions = new HashMap<>();
        for(final int[] flight : flights) {
            directions.computeIfAbsent(flight[0], v -> new ArrayList<>()).add(new Pair(flight[1], flight[2]));
        }

        final int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        final Queue<Pair> queue = new LinkedList<>();
        //curr node and curr price
        queue.offer(new Pair(src, 0));

        int stops = 0;

        while(stops <= k && !queue.isEmpty()) {
            int currSize = queue.size();
            //iterate on current level
            while(currSize-- > 0) {
                final Pair curr = queue.poll();

                if (directions.get(curr.getKey()) == null) {
                    continue;
                }

                for (final Pair neighbour : directions.get(curr.getKey())) {
                    if(prices[neighbour.getKey()] > curr.getValue() + neighbour.getValue()) {
                        prices[neighbour.getKey()] = curr.getValue() + neighbour.getValue();
                        queue.offer(new Pair(neighbour.getKey(), prices[neighbour.getKey()]));
                    }
                }
            }
            stops++;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }


    private static class Pair{
        private int key;
        private int value;

        public Pair(final int key, final int value) {
            this.key = key;
            this.value = value;
        }
        public int getKey() {
            return this.key;
        }

        public int getValue() {
            return this.value;
        }
    }
}

package leetcode.pureLogic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 18.08.2023
 **/
public class MaxNetworkRank_1615 {

    public static void main(String[] args) {

    }

    public int maximalNetworkRank(final int n, final int[][] roads) {
        final Map<Integer, Set<Integer>> topology = new HashMap<>();
        for(int[] road : roads) {
            topology.computeIfAbsent(road[0], v -> new HashSet<>()).add(road[1]);
            topology.computeIfAbsent(road[1], v -> new HashSet<>()).add(road[0]);
        }
        int max = Integer.MIN_VALUE;
        for(int city1 = 0; city1 < n-1; city1++) {
            for(int city2 = city1 + 1; city2 < n; city2++) {
                int curr = topology.getOrDefault(city1, new HashSet<>()).size() + topology.getOrDefault(city2, new HashSet<>()).size();
                if(topology.getOrDefault(city1, new HashSet<>()).contains(city2)) {
                    curr--;
                }
                max = Math.max(max, curr);
            }
        }
        return max;
    }
}

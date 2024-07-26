package leetcode.dfs;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.07.2024
 **/
public class FindTheCityWithTheSmallestNumberOfNeighboarsAtAThresholdDistance_1334 {

    public static void main(String[] args) {
//        System.out.println(findTheCity(6, new int[][] {{0,1,10},{0,2,1},{2,3,1},{1,3,1},{1,4,1},{4,5,10}}, 20));
        System.out.println(findTheCity(4, new int[][] {{0,1,3},{1,2,1},{1,3,4},{2,3,1}}, 4));
    }

    //my own algo!!!
    public static int findTheCity(final int n, final int[][] edges, final int distanceThreshold) {
        final Map<Integer, List<int[]>> neighbours = new HashMap<>();
        for(final int[] edge : edges) {
            neighbours.computeIfAbsent(edge[0], v -> new ArrayList<>());
            neighbours.computeIfAbsent(edge[1], v -> new ArrayList<>());
            neighbours.get(edge[0]).add(new int[] {edge[1], edge[2]});
            neighbours.get(edge[1]).add(new int[] {edge[0], edge[2]});
        }
        int min = Integer.MAX_VALUE;
        int ans = -1;
        for(int i=0; i<n; i++) {
            final Map<Integer, Integer> visited = new HashMap<>();
            final Queue<int[]> neighbourhood = new LinkedList<>();
            neighbourhood.add(new int[]{i, 0});
            visited.put(i, 0);
            while (!neighbourhood.isEmpty()) {
                final int[] city = neighbourhood.poll();
                if(neighbours.get(city[0]) != null) {
                    for(final int[] sosed : neighbours.get(city[0])) {
                        if((!visited.containsKey(sosed[0]) || visited.get(sosed[0]) > city[1] + sosed[1]) && city[1] + sosed[1] <= distanceThreshold) {
                            visited.put(sosed[0], city[1] + sosed[1]);
                            neighbourhood.add(new int[] {sosed[0], city[1] + sosed[1]});
                        }
                    }
                }
            }
            if( min >= visited.size() - 1) {
                ans = i;
                min = visited.size() - 1;
            }
        }
        return ans;
    }

    //Floyd-Washall algorithm Time O(n^3) and Space O(n^2)
    public int findTheCityEditorial(int n, int[][] edges, int distanceThreshold) {
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
            distance[i][i] = 0;  // distance to itself is 0
        }

        // The distance between nodes which are connected temporary distance between them
        for (int[] edge : edges) {
            int node1 = edge[0], node2 = edge[1], dist = edge[2];
            distance[node1][node2] = dist;
            distance[node2][node1] = dist;
        }

        for (int midle = 0; midle < n; midle++) {
            for (int source = 0; source < n; source++) {
                for (int destination = 0; destination < n; destination++) {
                    if (distance[source][midle] < Integer.MAX_VALUE && distance[midle][destination] < Integer.MAX_VALUE) {
                        distance[source][destination] = Math.min(
                                distance[source][destination], distance[source][midle] + distance[midle][destination]
                        );  // the minimum distance is either current value or new value with path that goes through midle
                    }
                }
            }
        }

        int minimum_number = n;
        int res = -1;

        for (int source = 0; source < n; source++) {
            int source_count = 0;
            for (int destination = 0; destination < n; destination++) {
                if (distance[source][destination] <= distanceThreshold) {
                    source_count++;
                }
            }

            if (source_count <= minimum_number) {  // as in dijkstra when number equal we choose greater node
                minimum_number = source_count;
                res = source;
            }
        }

        return res;
    }
}

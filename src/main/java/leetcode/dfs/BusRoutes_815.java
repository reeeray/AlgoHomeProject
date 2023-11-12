package leetcode.dfs;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 12.11.2023
 **/
public class BusRoutes_815 {

    public static void main(String[] args) {

    }

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        final HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        // Create a map from the bus stop to all the routes that include this stop.
        for (int r = 0; r < routes.length; r++) {
            for (int stop : routes[r]) {
                // Add all the routes that have this stop.
                final List<Integer> route = adjList.getOrDefault(stop, new ArrayList<>());
                route.add(r);
                adjList.put(stop, route);
            }
        }

        final Queue<Integer> queue = new LinkedList<>();
        final Set<Integer> vis = new HashSet<Integer>(routes.length);
        // Insert all the routes in the queue that have the source stop.
        for (int route : adjList.get(source)) {
            queue.add(route);
            vis.add(route);
        }

        int busCount = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int route = queue.remove();

                // Iterate over the stops in the current route.
                for (int stop: routes[route]) {
                    // Return the current count if the target is found.
                    if (stop == target) {
                        return busCount;
                    }

                    // Iterate over the next possible routes from the current stop.
                    for (int nextRoute : adjList.get(stop)) {
                        if (!vis.contains(nextRoute)) {
                            vis.add(nextRoute);
                            queue.add(nextRoute);
                        }
                    }
                }
            }
            busCount++;
        }
        return -1;
    }
}

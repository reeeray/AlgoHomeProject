package leetcode.bfs;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.01.2025
 **/
public class MaxEmployeesToBeInvitedToAMeeting_2127 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(n)
    public static int maximumInvitations(int[] favorite) {
        final int numPeople = favorite.length;
        final List<List<Integer>> reversedGraph = new ArrayList<>(numPeople);
        // Build the reversed graph where each node points to its admirers
        for (int i = 0; i < numPeople; i++) {
            reversedGraph.add(new ArrayList<>());
        }
        for (int person = 0; person < numPeople; person++) {
            reversedGraph.get(favorite[person]).add(person);
        }

        int longestCycle = 0;
        int twoCycleInvitations = 0;
        boolean[] visited = new boolean[numPeople];

        // Find all cycles in the graph
        for (int person = 0; person < numPeople; person++) {
            if (!visited[person]) {
                // Track visited persons and their distances
                final Map<Integer, Integer> visitedPersons = new HashMap<>();
                int currentPerson = person;
                int distance = 0;
                while (true) {
                    if (visited[currentPerson]) break;
                    visited[currentPerson] = true;
                    visitedPersons.put(currentPerson, distance++);
                    int nextPerson = favorite[currentPerson];

                    // Cycle detected
                    if (visitedPersons.containsKey(nextPerson)) {
                        int cycleLength =
                                distance - visitedPersons.get(nextPerson);
                        longestCycle = Math.max(longestCycle, cycleLength);

                        // Handle cycles of length 2
                        if (cycleLength == 2) {
                            Set<Integer> visitedNodes = new HashSet<>();
                            visitedNodes.add(currentPerson);
                            visitedNodes.add(nextPerson);
                            twoCycleInvitations +=
                                    2 +
                                            bfs(nextPerson, visitedNodes, reversedGraph) +
                                            bfs(currentPerson, visitedNodes, reversedGraph);
                        }
                        break;
                    }
                    currentPerson = nextPerson;
                }
            }
        }
        return Math.max(longestCycle, twoCycleInvitations);
    }

    // Calculate the maximum distance from a given start node
    private static int bfs(final int startNode, final Set<Integer> visitedNodes, final List<List<Integer>> reversedGraph) {
        // Queue to store nodes and their distances
        final Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { startNode, 0 });
        int maxDistance = 0;
        while (!queue.isEmpty()) {
            final int[] current = queue.poll();
            final int currentNode = current[0];
            final int currentDistance = current[1];
            for (int neighbor : reversedGraph.get(currentNode)) {
                if (visitedNodes.contains(neighbor)) continue; // Skip already visited nodes
                visitedNodes.add(neighbor);
                queue.offer(new int[] { neighbor, currentDistance + 1 });
                maxDistance = Math.max(maxDistance, currentDistance + 1);
            }
        }
        return maxDistance;
    }
}

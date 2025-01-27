package leetcode.bfs;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 27.01.2025
 **/
public class CourseSchedule4_1462 {

    public static void main(String[] args) {

    }

    //Time O(qn^2) where n the number of courses and q is the size of queries, Space O(n^2)
    public static List<Boolean> checkIfPrerequisiteOpt(final int numCourses, final int[][] prerequisites, final int[][] queries) {
        final Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (final int[] edge : prerequisites) {
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        }
        final List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            // Reset the visited array for each query
            boolean[] visited = new boolean[numCourses];
            result.add(isPrerequisite(adjList, visited, queries[i][0], queries[i][1]));
        }

        return result;
    }

    // Performs DFS and returns true if there's a path between src and target
    // and false otherwise.
    private static boolean isPrerequisite(final Map<Integer, List<Integer>> adjList, final boolean[] visited, final int src, final int target) {
        visited[src] = true;
        if (src == target) {
            return true;
        }
        boolean answer = false;
        final List<Integer> neighbors = adjList.getOrDefault(src, new ArrayList<>());
        for (int adj : neighbors) {
            if (!visited[adj]) {
                answer = answer || isPrerequisite(adjList, visited, adj, target);
            }
        }
        return answer;
    }

    //TLE
    public static List<Boolean> checkIfPrerequisite(final int numCourses, final int[][] prerequisites, final int[][] queries) {
        final Map<Integer, List<Integer>> fromPrereq = new HashMap<>();
        for(final int[] prereq : prerequisites) {
            fromPrereq.computeIfAbsent(prereq[0], v -> new ArrayList<>());
            fromPrereq.get(prereq[0]).add(prereq[1]);
        }
        final List<Boolean> answer = new ArrayList<>();
        for(final int[] query : queries) {
            final Queue<Integer> q = new LinkedList<>();
            q.offer(query[0]);
            boolean flag = false;
            while (!q.isEmpty()) {
                final int size = q.size();
                for(int i=0; i<size; i++) {
                    final int pr = q.poll();
                    if(fromPrereq.get(pr) == null) {
                        continue;
                    }
                    for(int course : fromPrereq.get(pr)) {
                        if(course == query[1]) {
                            flag = true;
                            break;
                        }
                        q.offer(course);
                    }
                    if(flag) {
                        break;
                    }
                }
                if(flag) {
                    break;
                }
            }
            answer.add(flag);
        }
        return answer;
    }
}

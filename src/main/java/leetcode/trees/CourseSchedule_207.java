package leetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 13.07.2023
 **/
public class CourseSchedule_207 {

    public static void main(String[] args) {

    }

    public static boolean canFinish(final int numCourses, final int[][] prerequisites) {
        final List<List<Integer>> neighbours = new ArrayList<>();
        final int[] level = new int[numCourses];
        for(int i=0; i<numCourses; i++) {
            neighbours.add(new ArrayList<>());
        }

        for(int[] p : prerequisites) {
            neighbours.get(p[1]).add(p[0]);
            level[p[0]]++;
        }

        final Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if(level[i] == 0) {
                queue.offer(i);
            }
        }
        int courseAchieved = 0;
        while(!queue.isEmpty()) {
            final int curr = queue.poll();
            courseAchieved++;
            for(int n : neighbours.get(curr)) {
                level[n]--;
                if(level[n] == 0) {
                    queue.offer(n);
                }
            }
        }
        return courseAchieved == numCourses;
    }

    public boolean dfs(int node, List<List<Integer>> adj, boolean[] visit, boolean[] inStack) {
        // If the node is already in the stack, we have a cycle.
        if (inStack[node]) {
            return true;
        }
        if (visit[node]) {
            return false;
        }
        // Mark the current node as visited and part of current recursion stack.
        visit[node] = true;
        inStack[node] = true;
        for (int neighbor : adj.get(node)) {
            if (dfs(neighbor, adj, visit, inStack)) {
                return true;
            }
        }
        // Remove the node from the stack.
        inStack[node] = false;
        return false;
    }

    public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }

        boolean[] visit = new boolean[numCourses];
        boolean[] inStack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, adj, visit, inStack)) {
                return false;
            }
        }
        return true;
    }
}

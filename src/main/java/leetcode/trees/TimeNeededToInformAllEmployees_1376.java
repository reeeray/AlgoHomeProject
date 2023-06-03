package leetcode.trees;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 03.06.2023
 **/
public class TimeNeededToInformAllEmployees_1376 {

    private int res = 0;

    public static void main(String[] args) {
        final int[] managers = new int[] {5,9,6,10,-1,8,9,1,9,3,4};
        final int[] informTime = new int[] {0,213,0,253,686,170,975,0,261,309,337};
        numOfMinutes(11, 4, managers, informTime);
    }

    //DFS
    public int numOfMinutesDFS(final int n, final int headID, final int[] manager, final int[] informTime) {
        final Map<Integer, List<Integer>> subordinates = new HashMap<>();

        for(int i=0; i<manager.length; i++) {
            if(manager[i] == -1) {
                continue;
            }
            subordinates.computeIfAbsent(manager[i], v -> new ArrayList<>());
            subordinates.get(manager[i]).add(i);
        }

        dfs(subordinates, headID, informTime, 0);
        return res;
    }

    private void dfs(final Map<Integer, List<Integer>> subordinates, final int node, final int[] informTime, final int time) {
        if(subordinates.get(node) == null ) {
            res = Math.max(res, time);
            return;
        }

        for(int index : subordinates.get(node)) {
            dfs(subordinates, index, informTime, time + informTime[node]);
        }
    }

    //wrong assumption BFS
    public static int numOfMinutes(final int n, final int headID, final int[] manager, final int[] informTime) {
        final Map<Integer, List<Integer>> subordinates = new HashMap<>();

        for(int i=0; i<manager.length; i++) {
            if(manager[i] == -1) {
                continue;
            }
            subordinates.computeIfAbsent(manager[i], v -> new ArrayList<>());
            subordinates.get(manager[i]).add(i);
        }

        final Queue<Integer> bfs = new LinkedList<>();
        bfs.offer(headID);
        int res = 0;

        while(!bfs.isEmpty()) {
            final int size = bfs.size();
            int max = Integer.MIN_VALUE;
            for(int i=0; i<size; i++) {
                final int index = bfs.poll();
                max = Math.max(max, informTime[index]);
                if(subordinates.get(index) != null ) {
                    for (int sub : subordinates.get(index)) {
                        bfs.offer(sub);
                    }
                }
            }
            res += max;
        }
        return res;
    }
}

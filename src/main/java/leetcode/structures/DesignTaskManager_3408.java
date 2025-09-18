package leetcode.structures;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 18.09.2025
 **/
public class DesignTaskManager_3408 {

    public static void main(String[] args) {
        final TaskManager testee = new TaskManager(List.of(
                List.of(1,101,10),
                List.of(2,102,20),
                List.of(3,103,15)
        ));
        testee.add(4,104,5);
        testee.edit(102,8);
        testee.execTop();
        testee.rmv(101);
        testee.add(5,105,15);
        testee.execTop();
    }

    private static class TaskManager {

        final Map<Integer, int[]> taskPriority;
        final PriorityQueue<int[]> pq;


        public TaskManager(final List<List<Integer>> tasks) {
            taskPriority = new HashMap<>();
            pq = new PriorityQueue<>((a, b) -> {
                final int compRes = Integer.compare(b[2], a[2]);
                if(compRes == 0) {
                    return Integer.compare(b[1], a[1]);
                }
                return compRes;
            });
            for(final List<Integer> task : tasks) {
                taskPriority.put(task.get(1), new int[]{task.get(0), task.get(1), task.get(2)});
                pq.offer(new int[]{task.get(0), task.get(1), task.get(2)});
            }
        }

        public void add(final int userId, final int taskId, final int priority) {
            taskPriority.put(taskId, new int[]{userId, taskId, priority});
            pq.offer(new int[]{userId, taskId, priority});
        }

        public void edit(final int taskId, final int newPriority) {
            taskPriority.get(taskId)[2] = newPriority;
            pq.offer(new int[]{taskPriority.get(taskId)[0], taskId, newPriority});
        }

        public void rmv(final int taskId) {
            taskPriority.remove(taskId);
        }

        public int execTop() {
            while(!pq.isEmpty()) {
                final int[] top = pq.poll();
                final int[] mapEntiry = taskPriority.get(top[1]);
                if(taskPriority.get(top[1]) != null && top[0] == mapEntiry[0] && top[2] == mapEntiry[2]) {
                    taskPriority.remove(top[1]);
                    return top[0];
                }
            }
            return -1;
        }
    }
}

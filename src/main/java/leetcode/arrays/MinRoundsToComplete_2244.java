package leetcode.arrays;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 04.01.2023
 **/
public class MinRoundsToComplete_2244 {

    public static void main(String[] args) {
        final int[] input = {2, 2, 3, 3, 2 ,4, 4, 4, 4, 4};
        assert 4 == minimumRounds(input);
    }

    private static int minimumRounds(final int[] tasks) {
        final Map<Integer, Integer> tasksNumber = new HashMap<>();
        int count = 0;
        for(final int task : tasks) {
            tasksNumber.put(task, tasksNumber.getOrDefault(task, 0) + 1);
        }

        for(final int n : tasksNumber.values()) {
            if(n == 1) {
                return -1;
            }
            if(n % 3 == 0) {
                count += n / 3;
            }
            else {
                count += n / 3 + 1; // here are two possible cases : if n % 3 == 2 -> n/3 + 1 and n % 3 == 1(n > 3) -> n/3 -1 + 2 which is also n/3 + 1
            }
        }
          return count;
    }

//    private static int process(final int taskNumber) {
//        if(taskNumber == 1)
//            return -1;
//        if(taskNumber % 3 == 0) {
//            return taskNumber / 3;
//        } else if (taskNumber % 3 == 2) {
//            return taskNumber/3 + 1;
//        }else {
//            return taskNumber / 3 + 1;
//        }
//    }
}

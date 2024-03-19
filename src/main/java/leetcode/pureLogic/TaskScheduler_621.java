package leetcode.pureLogic;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 19.03.2024
 **/
public class TaskScheduler_621 {

    public static void main(String[] args) {
        final char[] input = new char[] {'A', 'A', 'A', 'B', 'B', 'B'};
        leastInterval(input, 2);
    }

    //Time O(n) and Space O(1)
    public static int leastInterval(final char[] tasks, final int n) {
        final int[] count = new int[26];
        for(final char c : tasks) {
            count[c - 'A']++;
        }
        Arrays.sort(count);
        final int chunk = count[25] - 1;
        int idle = chunk * n;
        for(int i=24; i>= 0; i--) {
            idle -= Math.min(chunk, count[i]);
        }
        return idle < 0 ? tasks.length : tasks.length + idle;
    }
}

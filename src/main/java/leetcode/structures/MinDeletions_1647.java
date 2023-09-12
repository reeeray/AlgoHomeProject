package leetcode.structures;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 12.09.2023
 **/
public class MinDeletions_1647 {

    public static void main(String[] args) {

    }

    public static int minDeletions(final String s) {
        final Map<Character, Integer> frequency = new HashMap<>();
        for(final char c : s.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        final PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); //decreasing order
        pq.addAll(frequency.values());

        int count = 0;

        while(pq.size() > 1) {
            final int top = pq.poll();

            if(top != 0 && top == pq.peek()) {
                count++;
                pq.add(top - 1);
            }
        }
        return count;
    }
}

package leetcode.structures;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 13.12.2024
 **/
public class FindScoreOfAnArrayAfterMarkingAllElements_2593 {

    public static void main(String[] args) {

    }

    //Time O(nlogn) and Space O(Sn)
    public static long findScore(final int[] nums) {
        final List<int[]> sorted = new ArrayList<>();
        final boolean[] marks = new boolean[nums.length];
        for(int i=0; i<nums.length; i++) {
            sorted.add(new int[] {nums[i], i});
        }
        sorted.sort(Comparator.comparingInt(a -> a[0]));
        long ans = 0;
        for(final int[] index : sorted) {
            if(marks[index[1]]) {
                continue;
            }
            if(index[1] > 0) {
                marks[index[1] - 1] = true;
            }
            if(index[1] < nums.length - 1) {
                marks[index[1] + 1] = true;
            }
            marks[index[1]] = true;
            ans += index[0];
        }
        return ans;
    }

    //Time O(nlogn) and Space O(n)
    public long findScoreMemOpt(int[] nums) {
        long ans = 0;
        boolean[] marked = new boolean[nums.length];

        final PriorityQueue<int[]> heap = new PriorityQueue<>((arr1, arr2) -> {
            if (arr1[0] != arr2[0]) return arr1[0] - arr2[0];
            return arr1[1] - arr2[1];
        });

        for (int i = 0; i < nums.length; i++) {
            heap.add(new int[] { nums[i], i });
        }

        while (!heap.isEmpty()) {
            int[] element = heap.remove();
            int number = element[0];
            int index = element[1];
            if (!marked[index]) {
                ans += number;
                marked[index] = true;
                // mark adjacent elements if they exist
                if (index - 1 >= 0) {
                    marked[index - 1] = true;
                }
                if (index + 1 < nums.length) {
                    marked[index + 1] = true;
                }
            }
        }

        return ans;
    }
}

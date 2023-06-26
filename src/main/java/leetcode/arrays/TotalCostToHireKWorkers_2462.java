package leetcode.arrays;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.06.2023
 **/
public class TotalCostToHireKWorkers_2462 {
    public static void main(String[] args) {
        final int[] input = {17,12,10,2,7,2,11,20,8};
        System.out.println(totalCost(input, 3, 4));

    }

    //TLE
    public static long totalCost(final int[] cost, final int k, final int candidates) {
        final List<Integer> leftList = new ArrayList<>();
        final List<Integer> rightList = new ArrayList<>();

        for(int i=0; i<candidates; i++) {
            leftList.add(cost[i]);
        }
        for(int i=Math.max(candidates, cost.length - candidates); i<cost.length; i++) {
            rightList.add(cost[i]);
        }
        Collections.sort(leftList);
        Collections.sort(rightList);
        int leftIndex = candidates;
        int rightIndex = cost.length - 1 - candidates;
        long res = 0;
        for(int i=0; i<k; i++) {
            if(rightList.isEmpty() || !leftList.isEmpty() && leftList.get(0)<= rightList.get(0)) {
                res += leftList.get(0);
                leftList.remove(0);
                if(leftIndex <= rightIndex) {
                    leftList.add(cost[leftIndex++]);
                    Collections.sort(leftList);
                }
            } else {
                res += rightList.get(0);
                rightList.remove(0);
                if(leftIndex <= rightIndex) {
                    rightList.add(cost[rightIndex--]);
                    Collections.sort(rightList);
                }
            }
        }
        return res;
    }

    public static long totalCostPQ(final int[] cost, final int k, final int candidates) {
        final PriorityQueue<Integer> leftList = new PriorityQueue<>();
        final PriorityQueue<Integer> rightList = new PriorityQueue<>();

        for(int i=0; i<candidates; i++) {
            leftList.offer(cost[i]);
        }
        for(int i=Math.max(candidates, cost.length - candidates); i<cost.length; i++) {
            rightList.offer(cost[i]);
        }
        int leftIndex = candidates;
        int rightIndex = cost.length - 1 - candidates;
        long res = 0;
        for(int i=0; i<k; i++) {
            if(rightList.isEmpty() || !leftList.isEmpty() && leftList.peek()<= rightList.peek()) {
                res += leftList.poll();
                if(leftIndex <= rightIndex) {
                    leftList.offer(cost[leftIndex++]);
                }
            } else {
                res += rightList.poll();
                if(leftIndex <= rightIndex) {
                    rightList.offer(cost[rightIndex--]);
                }
            }
        }
        return res;
    }
}

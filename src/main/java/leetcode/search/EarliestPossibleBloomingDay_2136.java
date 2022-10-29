package leetcode.search;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 29.10.2022
 **/
public class EarliestPossibleBloomingDay_2136 {

    public static void main(String[] args) {
        final int[] plantTime = {1, 4, 3};
        final int[] growTime = {2, 3, 1};
        earliestFullBloom(plantTime, growTime);

        assert earliestFullBloom(plantTime, growTime) == 9;
    }

    private static int earliestFullBloom(int[] plantTime, int[] growTime) {
        final int n = plantTime.length;
        final Pair[] flowerTime = new Pair[n];
        for (int i = 0; i < n; i++) {
            flowerTime[i] = new Pair(plantTime[i], growTime[i]);
        }
        Arrays.sort(flowerTime, (a, b) -> b.growTime - a.growTime);
        int plantingDays = 0;
        int totalDays = 0;
        for (Pair current : flowerTime) {
            totalDays = Math.max(totalDays, plantingDays + current.plantTime + current.growTime);
            plantingDays += current.plantTime;
        }
        return totalDays;
    }

    static class Pair {
        public int plantTime;
        public int growTime;

        Pair(int plantTime, int growTime) {
            this.plantTime = plantTime;
            this.growTime = growTime;
        }
    }
}

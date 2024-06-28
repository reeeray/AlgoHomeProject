package leetcode.structures;

import java.util.Arrays;
import java.util.Comparator;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 28.06.2024
 **/
public class MaxTotalImportanceOfRoads_2285 {

    public static void main(String[] args) {
        final int[][] input = new int[][]{{0, 1}, {1, 2}, {2, 3}, {0, 2} , {1, 3}, {2, 4}};
        maxImportance(5, input);
    }

    //Time O(nLogn) and Space O(n)
    public static long maxImportance(final int n, final int[][] roads) {
        final int[][] sortedRoads = new int[n][2];
        for(final int[] road : roads) {
            sortedRoads[road[0]][0] = road[0];
            sortedRoads[road[0]][1] = sortedRoads[road[0]][1] + 1;
            sortedRoads[road[1]][0] = road[1];
            sortedRoads[road[1]][1] = sortedRoads[road[1]][1] + 1;
        }
        Arrays.sort(sortedRoads, Comparator.comparingInt(a -> a[1]));

        long sum = 0;
        for(int i=1; i<= n; i++) {
            sum += ((long)i) * sortedRoads[i-1][1];
        }

        return sum;
    }

    //improved speed and memory but estimations stay the same
    public static long maxImportanceOpt(final int n, final int[][] roads) {
        final int[] weight = new int[n];
        for(final int[] road : roads) {
            weight[road[0]]++;
            weight[road[1]]++;
        }
        Arrays.sort(weight);
        long sum = 0;
        for(int i=1; i<=n; i++) {
            sum += weight[i - 1] * (long)i;
        }
        return sum;
    }
}

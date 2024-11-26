package leetcode.pureLogic;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.11.2024
 **/
public class FindChampion2_2924 {

    public static void main(String[] args) {
        final int[][] input = new int[][] {{0, 1}, {1, 2}};
        findChampion(3, input);

    }

    //Space O(n) and Time O(n + m)
    public static int findChampion(final int n, final int[][]edges) {
        final int[] champ = new int[n];
        Arrays.fill(champ, -1);
        for(final int[] edge : edges) {
            champ[edge[1]] = edge[0];
        }
        int answer = -1;
        for(int i=0; i<n; i++) {
            if(champ[i] == -1) {
                if (answer != -1) {
                    return -1;
                } else {
                    answer = i;
                }
            }
        }
        return answer;
    }
}

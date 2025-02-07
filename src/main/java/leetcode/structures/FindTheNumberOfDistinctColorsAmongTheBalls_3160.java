package leetcode.structures;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 07.02.2025
 **/
public class FindTheNumberOfDistinctColorsAmongTheBalls_3160 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(n)
    public static int[] queryResult(final int limit, final int[][] queries) {
        final Map<Integer, Integer> colorMap = new HashMap<>();
        final Map<Integer, Integer> ballMap = new HashMap<>();
        final int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            final int ball = queries[i][0];
            if(ballMap.containsKey(ball)) {
                if (colorMap.get(ballMap.get(ball)) == 1) {
                    colorMap.remove(ballMap.get(ball));
                } else {
                    colorMap.put(ballMap.get(ball), colorMap.get(ballMap.get(ball)) - 1);
                }
            }
            ballMap.put(ball, queries[i][1]);
            colorMap.put(queries[i][1], colorMap.getOrDefault(queries[i][1], 0) + 1);
            ans[i] = colorMap.size();
        }
        return ans;
    }
}

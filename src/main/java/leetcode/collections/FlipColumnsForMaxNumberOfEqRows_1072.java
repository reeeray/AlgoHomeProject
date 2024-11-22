package leetcode.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 22.11.2024
 **/
public class FlipColumnsForMaxNumberOfEqRows_1072 {

    public static void main(String[] args) {

    }

    public static int maxEqRowsAfterFlips(final int[][] matrix) {
        final Map<String, Integer> patternFreqMap = new HashMap<>();
        for(final int[] row : matrix) {
            final StringBuilder sb = new StringBuilder();
            for(int i=0; i<row.length; i++) {
                if(row[0] == row[i]) {
                    sb.append('a');
                } else {
                    sb.append('b');
                }
            }
            final String str = sb.toString();
            patternFreqMap.put(str, patternFreqMap.getOrDefault(str, 0) + 1);
        }
        return patternFreqMap.values().stream().max((Integer::compareTo)).get();
    }
}

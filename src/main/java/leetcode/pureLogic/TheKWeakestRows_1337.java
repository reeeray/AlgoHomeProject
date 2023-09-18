package leetcode.pureLogic;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 18.09.2023
 **/
public class TheKWeakestRows_1337 {

    public static void main(String[] args) {

    }

    public static int[] kWeakestRows(final int[][] matrix, int k) {
        final Map<Integer, List<Integer>> hash = new TreeMap<>();
        for(int i=0; i<matrix.length; i++) {
            int count = 0;
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j] == 1) {
                    count++;
                } else {
                    break;
                }
            }
            hash.computeIfAbsent(count, a -> new ArrayList<>()).add(i);
        }
        final int[] answer = new int[k];
        for(List<Integer> nums : hash.values()) {
            for(int n : nums) {
                answer[answer.length - k] = n;
                k--;
                if(k == 0) {
                    return answer;
                }
            }
        }
        return null;
    }
}

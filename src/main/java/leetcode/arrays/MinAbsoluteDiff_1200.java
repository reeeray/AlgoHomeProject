package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.01.2026
 **/
public class MinAbsoluteDiff_1200 {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> minimumAbsDiff(final int[] arr) {
        final List<List<Integer>> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i = 1; i < arr.length; i++) {
            min = Math.min(min, Math.abs(arr[i] - arr[i - 1]));
        }

        for(int i = 1; i < arr.length; i++) {
            if(Math.abs(arr[i] - arr[i - 1]) == min) {
                res.add(List.of(arr[i - 1], arr[i]));
            }
        }
        return res;
    }

    public List<List<Integer>> minimumAbsDifferenceOneTraversal(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            int diff = A[i] - A[i - 1];
            if (diff < minDiff) {
                minDiff = diff;
                res = new ArrayList<>();
                res.add(Arrays.asList(A[i - 1], A[i]));
            } else if (diff == minDiff) {
                res.add(Arrays.asList(A[i - 1], A[i]));
            }
        }

        return res;
    }
}

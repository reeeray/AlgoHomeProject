package leetcode.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 378. Kth Smallest Element in a Sorted Matrix
 * <p>
 * Given an n x n matrix where each of the rows and columns are sorted in ascending order, return the kth smallest element in the matrix.
 * <p>
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * <p>
 * User : Shein G.A.{@reeeray}
 * Date : 07.07.2021
 **/
public class KthSmallestElementInSortedMatrix_378 {

    public static void main(String[] args) {
        System.out.println(kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8));
    }

    private static int kthSmallest(final int[][] matrix, final int k) {
        final List<Integer> scope = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                scope.add(matrix[i][j]);
            }
        }
        Collections.sort(scope);
        return scope.get(k - 1);
    }
}

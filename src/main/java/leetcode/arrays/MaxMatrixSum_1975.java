package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 24.11.2024
 **/
public class MaxMatrixSum_1975 {

    public static void main(String[] args) {

    }

    //Time O(mn) and Space O(1)
    public static long matrixMaxSub(final int[][] matrix) {
        long matrixSum = 0;
        int minAbs = Integer.MAX_VALUE;
        int countNegative = 0;
        for(final int[] row : matrix) {
            for(final int i : row) {
                final int abs = Math.abs(i);
                matrixSum += abs;
                minAbs = Math.min(abs, minAbs);
                if(i < 0) {
                    countNegative++;
                }
            }
        }
        if(countNegative % 2 != 0) {
            matrixSum -= 2 * minAbs;
        }
        return matrixSum;
    }
}

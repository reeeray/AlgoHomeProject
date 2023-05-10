package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 10.05.2023
 **/
public class SpiralMatrix2_59 {

    public static void main(String[] args) {
        generateMatrix(3);
    }

    public static int[][] generateMatrix(final int n) {
        final int[][] matrix = new int[n][n];
        int rightLimit = n-1;
        int leftLimit = 0;
        int topLimit = 0;
        int bottomLimit = n-1;
        int idx=1;
        while(idx <= n*n) {
            for(int i=leftLimit; i<=rightLimit; i++) {
                matrix[topLimit][i] = idx++;
            }
            topLimit++;
            for(int i=topLimit;  i<=bottomLimit; i++) {
                matrix[i][rightLimit] = idx++;
            }
            rightLimit--;
            for(int i=rightLimit; i>=leftLimit; i--) {
                matrix[bottomLimit][i] = idx++;
            }
            bottomLimit--;
            for(int i=bottomLimit; i>= topLimit; i--) {
                matrix[i][leftLimit] = idx++;
            }
            leftLimit++;
        }
        return matrix;
    }
}

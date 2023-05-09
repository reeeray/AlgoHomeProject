package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 09.05.2023
 **/
public class SpiralMatrix_54 {

    public static void main(String[] args) {
        final int[][] input = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        spiralOrder(input);
    }

    private static List<Integer> spiralOrder (final int[][] matrix) {
        int rightLimit = matrix[0].length-1;
        int leftLimit = 0;
        int topLimit = 0;
        int bottomLimit = matrix.length-1;
        final int size = matrix.length * matrix[0].length;
        final List<Integer> res = new ArrayList<>();
        while(res.size() < size) {
            for(int i=leftLimit; i<=rightLimit; i++) {
                res.add(matrix[topLimit][i]);
            }
            topLimit++;
            if(res.size() == size) return res;
            for(int i=topLimit;  i<=bottomLimit; i++) {
                res.add(matrix[i][rightLimit]);
            }
            rightLimit--;
            if(res.size() == size) return res;
            for(int i=rightLimit; i>=leftLimit; i--) {
                res.add(matrix[bottomLimit][i]);
            }
            bottomLimit--;
            if(res.size() == size) return res;
            for(int i=bottomLimit; i>= topLimit; i--) {
                res.add(matrix[i][leftLimit]);
            }
            leftLimit++;
        }
        return res;
    }
}

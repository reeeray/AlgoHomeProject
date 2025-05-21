package leetcode.structures;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 21.05.2025
 **/
public class SetMatrixZeroes_73 {

    public static void main(String[] args) {

    }

    //Time O(2nm) and Space O(1)
    public void setZeroesOpt(int[][] matrix) {
        boolean zeroinFirstCol = false;
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] == 0) zeroinFirstCol = true;
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        for (int row = matrix.length - 1; row >= 0; row--) {
            for (int col = matrix[0].length - 1; col >= 1; col--) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
            if (zeroinFirstCol) {
                matrix[row][0] = 0;
            }
        }
    }

    //Space O(nm) and Time O(nm*nm)
    public static void setZeroes(final int[][] matrix) {
        final List<int[]> storage = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    storage.add(new int[]{i, j});
                }
            }
        }
        for(final int[] indexes : storage) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][indexes[1]] = 0;
            }
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[indexes[0]][j] = 0;
            }
        }
    }
}

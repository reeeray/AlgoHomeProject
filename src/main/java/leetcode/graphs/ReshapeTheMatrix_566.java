package leetcode.graphs;

import java.util.Arrays;

/**
 * 566. Reshape the Matrix
 * <p>
 * In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.
 * <p>
 * You are given an m x n matrix mat and two integers r and c representing the row number and column number of the wanted reshaped matrix.
 * <p>
 * The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.
 * <p>
 * If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
 * User : Shein G.A.{@reeeray}
 * Date : 06.07.2021
 **/
public class ReshapeTheMatrix_566 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4)));
    }

    private static int[][] matrixReshape(final int[][] mat, final int r, final int c) {
        final int row = mat.length;
        final int col = mat[0].length;
        final int[][] answ = new int[r][c];
        int rCounter = 0;
        int cCounter = 0;
        if (row * col != r * c)
            return mat;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (cCounter < col) {
                    answ[i][j] = mat[rCounter][cCounter++];
                    if (cCounter == col) {
                        cCounter = 0;
                        rCounter++;
                    }
                }
                if (rCounter == row)
                    break;
            }
        }
        return answ;
    }
}

package leetcode.arrays;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 01.09.2024
 **/
public class Conver1DArrayInto2DArray_2022 {

    public static void main(String[] args) {

    }

    //Time O(m*n) and Space O(1)
    public static int[][] construct2Darray(final int[] original, final int m, final int n) {
        final int[][] answer = new int[m][n];
        if(m*n < original.length) {
            return new int[][]{};
        }
//        for(int i=0; i<original.length; i++) {
//            answer[i / n][i % n] = original[i];
//        }
        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                answer[row][col] = original[row*n + col];
            }
        }
        return answer;
    }

    public int[][] construct2DArrayOpt(int[] original, int m, int n) {
        if(m*n != original.length){
            return new int[0][0];
        }
        int[][] arr = new int[m][];

        for(int i=0; i<m; i++){
            arr[i] = Arrays.copyOfRange(original, i*n, i*n+n);
        }
        return arr;
    }
}

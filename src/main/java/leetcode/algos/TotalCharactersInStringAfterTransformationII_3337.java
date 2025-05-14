package leetcode.algos;

import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 14.05.2025
 **/
public class TotalCharactersInStringAfterTransformationII_3337 {

    private static final int MOD = (int)(1e9 + 7);

    public static void main(String[] args) {

    }

    public int lengthAfterTransformations(final String s, final int t, final List<Integer> nums) {
        final int[][] T = getTransformationMatrix(nums);
        final int[][] poweredT = matrixPow(T, t);
        final int[] count = new int[26];
        final int[] lengths = new int[26];

        for (final char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                lengths[j] = (int)((lengths[j] + 1L * count[i] * poweredT[i][j]) % MOD);
            }
        }

        int total = 0;
        for (int len : lengths) {
            total = (total + len) % MOD;
        }

        return total;
    }

    private static int[][] getTransformationMatrix(final List<Integer> nums) {
        final int[][] T = new int[26][26];
        for (int i = 0; i < nums.size(); i++) {
            for (int step = 1; step <= nums.get(i); step++) {
                T[i][(i + step) % 26]++;
            }
        }
        return T;
    }

    private static int[][] matrixPow(final int[][] M, final int n) {
        if (n == 0) return getIdentityMatrix(M.length);
        if (n % 2 == 1) return matrixMult(M, matrixPow(M, n - 1));
        final int[][] half = matrixPow(M, n / 2);
        return matrixMult(half, half);
    }

    private static int[][] getIdentityMatrix(final int size) {
        final int[][] I = new int[size][size];
        for (int i = 0; i < size; i++) {
            I[i][i] = 1;
        }
        return I;
    }

    private static int[][] matrixMult(final int[][] A, final int[][] B) {
        final int size = A.length;
        final int[][] C = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                long sum = 0;
                for (int k = 0; k < size; k++) {
                    sum = (sum + 1L * A[i][k] * B[k][j]) % MOD;
                }
                C[i][j] = (int)sum;
            }
        }
        return C;
    }


}

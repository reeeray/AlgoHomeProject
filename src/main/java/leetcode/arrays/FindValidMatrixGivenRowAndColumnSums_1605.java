package leetcode.arrays;

import java.util.Map;
import java.util.TreeMap;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 20.07.2024
 **/
public class FindValidMatrixGivenRowAndColumnSums_1605 {

    public static void main(String[] args) {

    }

    //Space O(n + m) and Time O(nm)
    public int[][] restoreMatrixGreedy(final int[] rowSum, final int[] colSum) {
        final int n = rowSum.length;
        final int m = colSum.length;

        final int[] currRowSum = new int[n];
        final int[] currColSum = new int[m];

        final int[][] restored = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                restored[i][j] = Math.min(
                        rowSum[i] - currRowSum[i],
                        colSum[j] - currColSum[j]
                );

                currRowSum[i] += restored[i][j];
                currColSum[j] += restored[i][j];
            }
        }
        return restored;
    }

    //Space O(1) and Time O(n*m)
    public int[][] restoreMatrixSpaceOpt(final int[] rowSum, final int[] colSum) {
        final int n = rowSum.length;
        final int m = colSum.length;
        final int[][] restored = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                restored[i][j] = Math.min(rowSum[i], colSum[j]);

                rowSum[i] -= restored[i][j];
                colSum[j] -= restored[i][j];
            }
        }

        return restored;
    }


    //Time and Space optimized Time O(nm) and Space O(1)
    public int[][] restoreMatrixOptimum(int[] rowSum, int[] colSum) {
        int N = rowSum.length;
        int M = colSum.length;

        int[][] origMatrix = new int[N][M];
        int i = 0, j = 0;

        while (i < N && j < M) {
            origMatrix[i][j] = Math.min(rowSum[i], colSum[j]);

            rowSum[i] -= origMatrix[i][j];
            colSum[j] -= origMatrix[i][j];

            if (rowSum[i] == 0) {
                i++;
            } else {
                j++;
            }
        }

        return origMatrix;
    }
    //bullshit
    public static int[][] restoreMatrix(final int[] rowSum, final int[] colSum) {
        final int n = rowSum.length;
        final int m = colSum.length;
        final int[][] restored = new int[n][m];
        final TreeMap<Integer, Integer> rowSums = new TreeMap<>();
        final TreeMap<Integer, Integer> colsSums = new TreeMap<>();
        for(int i = 0; i<n; i++) {
            rowSums.put(rowSum[i], i);
        }

        for(int j=0; j<m; j++) {
            colsSums.put(colSum[j], j);
        }

        while(!rowSums.isEmpty() || !colsSums.isEmpty()) {
            final Map.Entry<Integer, Integer> row = rowSums.firstEntry();
            rowSums.remove(row.getKey());
            final Map.Entry<Integer, Integer> col = colsSums.firstEntry();
            colsSums.remove(col.getKey());
            if(col.getValue() > row.getValue()) {
                restored[row.getValue()][col.getValue()] = row.getKey();
                restored[row.getValue() + 1][col.getValue()] = col.getValue() - row.getValue();
                //
            } else {

            }
        }
        return restored;
    }
}

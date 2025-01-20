package leetcode.dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 20.01.2025
 **/
public class FirstCompletelyPaintedRowOrColumn_2661 {

    public static void main(String[] args) {

    }

    public static int firstCompleteIndexBruteForceOptimized(final int[] arr, final int[][] mat) {
        final Map<Integer, int[]> valueByIndex = new HashMap<>();
        final int[] countRow = new int[mat.length];
        final int[] countCol = new int[mat[0].length];
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                valueByIndex.put(mat[i][j], new int[] {i, j});
            }
        }
        for(int i=0; i<arr.length; i++) {
            final int[] index = valueByIndex.get(arr[i]);
            countRow[index[0]]++;
            countCol[index[1]]++;
            if(countRow[index[0]] == mat.length || countCol[index[1]] == mat[0].length) {
                return i;
            }
        }
        return -1;
    }

    //Space O(k==mn) and Time O(m*n)
    public int firstCompleteIndexReverseMapping(int[] arr, int[][] mat) {
        // Map to store the index of each number in the arr
        Map<Integer, Integer> numToIndex = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            numToIndex.put(arr[i], i);
        }

        int result = Integer.MAX_VALUE;
        int numRows = mat.length;
        int numCols = mat[0].length;

        // Check for the earliest row to be completely painted
        for (int row = 0; row < numRows; row++) {
            // Tracks the greatest index in this row
            int lastElementIndex = Integer.MIN_VALUE;
            for (int col = 0; col < numCols; col++) {
                int indexVal = numToIndex.get(mat[row][col]);
                lastElementIndex = Math.max(lastElementIndex, indexVal);
            }
            // Update result with the minimum index where this row is fully painted
            result = Math.min(result, lastElementIndex);
        }

        // Check for the earliest column to be completely painted
        for (int col = 0; col < numCols; col++) {
            int lastElementIndex = Integer.MIN_VALUE;
            for (int row = 0; row < numRows; row++) {
                int indexVal = numToIndex.get(mat[row][col]);
                lastElementIndex = Math.max(lastElementIndex, indexVal);
            }
            // Update result with the minimum index where this column is fully painted
            result = Math.min(result, lastElementIndex);
        }

        return result;
    }

    //Brute force approach Space O(m*n) and Time O(m*n + k*(m+n)) where k is the length of the arr (which is m*n)
    public static int firstCompleteIndex(final int[] arr, final int[][] mat) {
        final Map<Integer, int[]> valueByIndex = new HashMap<>();
        final boolean[][] visited = new boolean[mat.length][mat[0].length];
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                valueByIndex.put(mat[i][j], new int[] {i, j});
            }
        }
        for(int i=0; i<arr.length; i++) {
            final int[] index = valueByIndex.get(arr[i]);
            visited[index[0]][index[1]] = true;
            if(check(index[0], index[1], visited)) {
                return i;
            }
        }
        return arr.length - 1;
    }

    private static boolean check(final int row, final int col, final boolean[][] visited) {
        int counter = 0;
        for(int r = 0; r <visited.length; r++) {
            if(!visited[r][col]) {
                break;
            } else {
                counter++;
            }
        }
        if(counter == visited.length) {
            return true;
        }
        counter = 0;
        for(int c = 0; c < visited[0].length; c++) {
            if(!visited[row][c]) {
                break;
            } else {
                counter++;
            }
        }
        return counter == visited[0].length;
    }
}

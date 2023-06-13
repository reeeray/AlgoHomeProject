package leetcode.structures;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 13.06.2023
 **/
public class EqualRowAndColumnPair_2352 {

    public static void main(String[] args) {
        final int[][] grid = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
        equalPairs(grid);
    }

    public static int equalPairs(final int[][] grid) {
//        final int n = grid.length;
//        final Map<String, Integer> hashedRows = new HashMap<>();
//        final Map<String, Integer> hashedCols = new HashMap<>();
//        for(int i=0; i<n; i++) {
//            final StringBuilder sbRow = new StringBuilder();
//            final StringBuilder sbCol = new StringBuilder();
//            for(int j=0; j<n; j++) {
//                sbRow.append(grid[i][j]);
//                sbRow.append("_");
//                sbCol.append(grid[j][i]);
//                sbCol.append("_");
//            }
//            final String row = sbRow.toString();
//            final String col = sbCol.toString();
//            hashedRows.put(row, hashedRows.getOrDefault(row, 0) + 1);
//            hashedCols.put(col, hashedCols.getOrDefault(col, 0) + 1);
//        }
//
//        int res = 0;
//        for(final String hash : hashedCols.keySet()) {
//            res += hashedRows.getOrDefault(hash, 0) * hashedCols.get(hash);
//        }
//        return res;

        int res = 0;
        int size = grid.length;
        final Map<String, Integer> hashRow = new HashMap<>();
        for (int[] row : grid) {
            final String rowString = Arrays.toString(row);
            hashRow.put(rowString, hashRow.getOrDefault(rowString, 0) + 1);
        }
        for (int c = 0; c < size; c++) {
            final int[] colArray = new int[size];
            for (int r = 0; r < size; r++) {
                colArray[r]= grid[r][c];
            }
            res += hashRow.getOrDefault(Arrays.toString(colArray),0);
        }
        return res;
    }

    public static int equalPair(final int[][] grid) {
        int count=0;
        int n=grid.length;
        int[][] transponed=new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                transponed[j][i]=grid[i][j];
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(Arrays.equals(grid[i],transponed[j])) count++;
            }
        }
        return count;
    }
}

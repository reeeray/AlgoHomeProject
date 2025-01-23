package leetcode.pureLogic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 23.01.2025
 **/
public class CountServersThatCommunicate_1267 {

    public static void main(String[] args) {

    }

    public static int countServers(final int[][] grids) {
        final Set<Integer> serverIds = new HashSet<>();
        int id = 2;
        for(int row = 0; row < grids.length; row++) {
            final List<Integer> serversOnLine = new ArrayList<>();
            for(int col = 0; col < grids[0].length; col++) {
                if(grids[row][col] == 1) {
                    grids[row][col] = id++;
                }
                if(grids[row][col] > 1) {
                    serversOnLine.add(grids[row][col]);
                }
            }
            if(serversOnLine.size() > 1) {
                serverIds.addAll(serversOnLine);
            }
        }

        for(int col = 0; col < grids[0].length; col++) {
            final List<Integer> serversOnLine = new ArrayList<>();
            for(int row = 0; row < grids.length; row++) {
                if(grids[row][col] == 1) {
                    grids[row][col] = id++;
                }
                if(grids[row][col] > 1) {
                    serversOnLine.add(grids[row][col]);
                }
            }
            if(serversOnLine.size() > 1) {
                serverIds.addAll(serversOnLine);
            }
        }
        return serverIds.size();
    }

    //Time O(mn) and Space O(m + n)
    public int countServersTimeOpt(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        final int[] rowCounts = new int[grid[0].length];
        final int[] colCounts = new int[grid.length];

        // Count servers in each row and each column
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    rowCounts[col]++;
                    colCounts[row]++;
                }
            }
        }

        int communicableServersCount = 0;

        // Count servers that can communicate (in the same row or column)
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    if (rowCounts[col] > 1 || colCounts[row] > 1) {
                        communicableServersCount++;
                    }
                }
            }
        }

        return communicableServersCount;
    }
}

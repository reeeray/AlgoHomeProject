package leetcode.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 22.01.2025
 **/
public class MapOfHighestPeak_1765 {

    public static void main(String[] args) {

    }


    //Space O(mn) and Time O(mn)
    public static int[][] highestPeak(final int[][] isWater) {
        final int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        final int[][] heightMap = new int[isWater.length][isWater[0].length];

        final Queue<int[]> levels = new LinkedList<>();

        for(int row = 0; row < isWater.length; row++) {
            for(int col = 0; col < isWater[0].length; col++) {
                if(directions[row][col] == 1) {
                    heightMap[row][col] = 0;
                    levels.offer(new int[] {row, col});
                } else {
                    heightMap[row][col] = -1;
                }
            }
        }

        int currentLevelHeight = 1;
        while (!levels.isEmpty()) {
            final int currentLevelSize = levels.size();
            for(int i=0; i < currentLevelSize; i++) {
                final int[] indexes = levels.poll();
                for(final int[] dir : directions) {
                    final int newRow = indexes[0] + dir[0];
                    final int newCol = indexes[1] + dir[1];
                    if(newRow >= 0 && newRow < isWater.length && newCol >= 0 && newCol < isWater[0].length
                    && heightMap[newRow][newCol] == -1) {
                        heightMap[newRow][newCol] = currentLevelHeight;
                        levels.offer(new int[] {newRow, newCol});
                    }
                }
            }
            currentLevelHeight++;
        }
        return heightMap;
    }
}

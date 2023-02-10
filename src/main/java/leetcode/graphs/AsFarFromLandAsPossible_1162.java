package leetcode.graphs;


import java.util.LinkedList;
import java.util.Queue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 10.02.2023
 **/
public class AsFarFromLandAsPossible_1162 {

    public static void main(String[] args) {

    }

    private static int maxDistance(final int[][] grid) {
        final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        final int[][] visisted = new int[grid.length][grid[0].length];
        final Queue<Pair> landInQueue = new LinkedList<>();

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    landInQueue.offer(new Pair(i, j));
                }
                visisted[i][j] = grid[i][j];
            }
        }


        int distance = -1;
        while (!landInQueue.isEmpty()) {
            int iterQSize = landInQueue.size();
            while (iterQSize-- > 0) {
                final Pair p = ((LinkedList<Pair>) landInQueue).pop();
                for(final int[] direction : directions) {
                    final int x = p.left + direction[0];
                    final int y = p.right + direction[1];

                    if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && visisted[x][y] == 0) {
                        landInQueue.offer(new Pair(x, y));
                        visisted[x][y] = 1;
                    }
                }
            }
            distance++;
        }

        return distance == 0 ? -1 : distance;
    }


    private static class Pair {
        private int left;
        private int right;

        public Pair(final int left, final int right) {
            this.left = left;
            this.right = right;
        }
    }
}

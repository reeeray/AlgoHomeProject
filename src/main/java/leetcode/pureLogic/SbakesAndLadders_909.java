package leetcode.pureLogic;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 24.01.2023
 **/
public class SbakesAndLadders_909 {

    private static int minMovements = Integer.MAX_VALUE;

    public static void main(String[] args) {

    }

    private static int snakesAndLadeers(final int[][] board) {
        final int n = board.length;
//        dfs(board, 1, 0, true, n);
//
//        return minMovements == Integer.MAX_VALUE ? -1 : minMovements;

        //broad-first search. BFS
        final Pair[] cells = new Pair[n * n + 1];
        int label = 1;
            final Integer[] columns = new Integer[n];//needed Wrapper for reversal
        for (int i = 0; i < n; i++) {
            columns[i] = i;
        }
        for (int row = n - 1; row >= 0; row--) {
            for (int column : columns) {
                cells[label++] = new Pair(row, column);
            }
            Collections.reverse(Arrays.asList(columns));
        }
        int[] dist = new int[n * n + 1];
        Arrays.fill(dist, -1);
        final Queue<Integer> q = new LinkedList<Integer>();
        dist[1] = 0;
        q.add(1);
        while (!q.isEmpty()) {
            int curr = q.remove();
            for (int next = curr + 1; next <= Math.min(curr + 6, n * n); next++) {
                int row = cells[next].getKey(), column = cells[next].getValue();
                int destination = board[row][column] != -1 ? board[row][column] : next;
                if (dist[destination] == -1) {
                    dist[destination] = dist[curr] + 1;
                    q.add(destination);
                }
            }
        }
        return dist[n * n];
    }

    private static void dfs(final int[][] board, final int curr, final int mov, final boolean bonuses, final int n) {
        if(curr == n*n) {
            minMovements = Math.min(minMovements, mov);
            return;
        }
        int row;
        int col;
        if(((curr-1) / n) % 2 == 0) {
            row = n - 1 - (curr-1)/n;
            col = (curr-1) % n;
        } else {
            row = n - 1 - (curr-1)/n;
            col = n - 1 - (curr-1) % n;

        }
        if(board[row][col] != -1 && bonuses) {
            dfs(board, board[row][col], mov+1, false, n);
        } else {
            for(int i=curr+1; i<= Math.min(n*n, curr+6); i++) {
                dfs(board, i, mov+1, true, n);
            }
        }
    }

    private static class Pair {
        private final Integer key;
        private final Integer value;

        public Pair(final Integer key, final Integer value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return this.key;
        }

        public Integer getValue() {
            return this.value;
        }
    }
}

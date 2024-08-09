package leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 09.08.2024
 **/
public class MagicSquaresInGrid_840 {

    public static void main(String[] args) {
        final int[][] input = new int[][] {{1,8,6},{10,5,0},{4,2,9}};
        numMagicSquaresInside(input);
    }

    //Time O(nm) and space O(1)
    public static int numMagicSquaresInside(final int[][] grid) {
        final int rows = grid.length;
        final int cols = grid[0].length;

        int sum = 0;
        for(int i=0; i+2 < rows; i++) {
            for(int j=0; j+2<cols; j++) {
                if(isMagic(i, j, grid)) {
                    sum++;
                }
            }
        }

        return sum;
    }

    private static boolean isMagic(final int row, final int col, final int[][] grid) {
        final int q1 = grid[row][col];
        final int q2 = grid[row][col + 1];
        final int q3 = grid[row][col + 2];
        final int q4 = grid[row + 1][col];
        final int q5 = grid[row + 1][col + 1];
        final int q6 = grid[row + 1][col + 2];
        final int q7 = grid[row + 2][col];
        final int q8 = grid[row + 2][col + 1];
        final int q9 = grid[row + 2][col + 2];
        final int reference = q1 + q2 + q3;
        final int l1 = q4 + q5 + q6;
        final int l2 = q7 + q8 + q9;
        if( l1 != reference)
            return false;
        if( l2 != reference)
            return false;
        if(q1 + q4 + q7 != reference)
            return false;
        if(q2 + q5 + q8 != reference)
            return false;
        if(q3 + q6 + q9 != reference)
            return false;
        if(q1 + q5 + q9 != reference)
            return false;
        if(q3 + q5 + q7 != reference)
            return false;
        if(reference + l1 + l2 != 45)
            return false;
        final Set<Integer> digits = new HashSet<>();
        digits.add(q1);
        digits.add(q2);
        digits.add(q3);
        digits.add(q4);
        digits.add(q5);
        digits.add(q6);
        digits.add(q7);
        digits.add(q8);
        digits.add(q9);
        if(digits.size() != 9) {
            return false;
        }
        for(int i=1; i<10; i++) {
            if(!digits.contains(i)) {
                return false;
            }
        }

        return true;
    }

    //Time O(m*n) and Space O(1)
    public int numMagicSquaresInsideOptimized(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int row = 0; row + 2 < m; row++) {
            for (int col = 0; col + 2 < n; col++) {
                if (isMagicSquare(grid, row, col)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean isMagicSquare(int[][] grid, int row, int col) {
        // The sequences are each repeated twice to account for
        // the different possible starting points of the sequence
        // in the magic square
        final String sequence = "2943816792438167";
        final String sequenceReversed = "7618349276183492";

        final StringBuilder border = new StringBuilder();
        // Flattened indices for bordering elements of 3x3 grid
        int[] borderIndices = new int[] { 0, 1, 2, 5, 8, 7, 6, 3 };
        for (int i : borderIndices) {
            int num = grid[row + i / 3][col + (i % 3)];
            border.append(num);
        }

        String borderConverted = border.toString();

        // Make sure the sequence starts at one of the corners
        return (
                grid[row][col] % 2 == 0 &&
                        (sequence.contains(borderConverted) ||
                                sequenceReversed.contains(borderConverted)) &&
                        grid[row + 1][col + 1] == 5
        );
    }
}

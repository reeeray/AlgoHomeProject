package coursera.slider_puzzle;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 01.06.2020
 **/
public class Board {

    private final int[][] board;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
        board = clone(tiles);
    }

    // string representation of this board
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(dimension());
        sb.append(System.lineSeparator());
        for (int i = 0; i < dimension(); i++) {
            for (int j = 0; j < dimension(); j++) {
                sb.append(String.format("%2d ", board[i][j]));
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    // board dimension n
    public int dimension() {
        return board.length;
    }

    // number of tiles out of place
    public int hamming() {
        int hamming = 0;
        for (int i = 0; i < dimension(); i++) {
            for (int j = 0; j < dimension(); j++) {
                //(i == 0 && board[i][j] != j + 1) || (i != 0 && board[i][j] != (i + 1)*(j + 1))
                if (board[i][j] != 0 && board[i][j] != j + 1 + i * dimension()) hamming++;
            }
        }
        return hamming;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        int manhattan = 0;
        for (int i = 0; i < dimension(); i++) {
            for (int j = 0; j < dimension(); j++) {
                if (board[i][j] != 0 && board[i][j] != j + 1 + i * dimension())
                    manhattan += numberOfSteps(i, j);
            }
        }
        return manhattan;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return hamming() == 0;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (this == y) return true;
        if (y == null) return false;
        if (this.getClass() != y.getClass()) return false;
        final Board that = (Board) y;
        return Arrays.deepEquals(this.board, that.board);
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        final ArrayList<Board> boards = new ArrayList<>();
        final int zeroPos = getZeroPos();
        int i = zeroPos / dimension();
        int j = zeroPos % dimension();

        if (j > 0)
            boards.add(new Board(swap(i, j, i, j - 1)));
        if (j < dimension() - 1)
            boards.add(new Board(swap(i, j, i, j + 1)));
        if (i > 0)
            boards.add(new Board(swap(i, j, i - 1, j)));
        if (i < dimension() - 1)
            boards.add(new Board(swap(i, j, i + 1, j)));
        return boards;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        final int[][] twin = clone(this.board);

        if (twin[1][1] != 0 && twin[0][1] != 0)
            return new Board(swap(1, 1, 0, 1));
        else
            return new Board(swap(0, 0, 1, 0));

    }

    /**
     * Calculate number of steps for square to proper position on the board
     *
     * @param i - row position
     * @param j - columns position
     * @return number of steps
     */
    private int numberOfSteps(final int i, final int j) {
        final int value = board[i][j] - 1;

        final int vertSteps = Math.abs(i - value / dimension());
        final int horSteps = Math.abs(j - value % dimension());
        return vertSteps + horSteps;
    }

    /**
     * Find blank position on the board
     *
     * @return square of blank position
     */
    private int getZeroPos() {
        for (int i = 0; i < dimension(); i++) {
            for (int j = 0; j < dimension(); j++) {
                if (board[i][j] == 0)
                    return j + i * dimension();
            }
        }
        return -1;
    }

    /**
     * Return clone of the input array
     *
     * @param array toClone
     * @return cloneOf
     */
    private int[][] clone(final int[][] array) {
        final int rows = array.length;
        final int columns = array[0].length;
        final int[][] clone = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                clone[i][j] = array[i][j];
            }
        }
        return clone;
    }

    /**
     * Returns a clone of the input array with swapped two elements(squares)
     *
     * @param rowPos1 row position of square 1
     * @param colPos1 column position of square 1
     * @param rowPos2 row position of square 2
     * @param colPos2 columns position of square 2
     * @return cloned array with swapped elements
     */
    private int[][] swap(final int rowPos1, final int colPos1, final int rowPos2, final int colPos2) {
        final int[][] clone = clone(board);
        final int temp = clone[rowPos1][colPos1];
        clone[rowPos1][colPos1] = clone[rowPos2][colPos2];
        clone[rowPos2][colPos2] = temp;
        return clone;
    }

    // unit testing (not graded)
    public static void main(String[] args) {
        final Board board = new Board(new int[][]{{1, 2, 3}, {4, 0, 6}, {7, 8, 5}});
        System.out.println(board.toString());
        for (Board board1 : board.neighbors()) {
            System.out.println(board1);
        }
    }
}

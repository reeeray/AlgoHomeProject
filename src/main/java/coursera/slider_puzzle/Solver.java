package coursera.slider_puzzle;

import edu.princeton.cs.algs4.MinPQ;

import java.util.Stack;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 01.06.2020
 **/
public class Solver {

    private final Stack<Board> solutionBoards;
    private boolean isSolvable;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null) throw new NullPointerException("Initial board must not be null");
        isSolvable = false;
        solutionBoards = new Stack<>();
        MinPQ<SearchNode> searchNodes = new MinPQ<>();

        searchNodes.insert(new SearchNode(initial, null));
        searchNodes.insert(new SearchNode(initial.twin(), null));

        while (!searchNodes.min().board.isGoal()) {
            final SearchNode searchNode = searchNodes.delMin();
            for (Board board : searchNode.board.neighbors())
                if (searchNode.prev == null || searchNode.prev != null && !searchNode.prev.board.equals(board))
                    searchNodes.insert(new SearchNode(board, searchNode));
        }

        SearchNode current = searchNodes.min();
        while (current.prev != null) {
            solutionBoards.push(current.board);
            current = current.prev;
        }
        solutionBoards.push(current.board);

        if (current.board.equals(initial)) isSolvable = true;
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        return isSolvable;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        if (!isSolvable) return -1;
        return solutionBoards.size() - 1;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        return solutionBoards;
    }

    // test client (see below)
    public static void main(String[] args) {

    }

    private class SearchNode implements Comparable<SearchNode> {
        private final Board board;
        private final SearchNode prev;
        private int moves;
        private int manhatten;

        public SearchNode(final Board board, final SearchNode prev) {
            this.board = board;
            this.prev = prev;
            this.manhatten = board.manhattan();
            if (prev != null) moves = prev.moves + 1;
            else moves = 0;
        }

        @Override
        public int compareTo(final SearchNode that) {
            final int priorityDiff = (this.manhatten + this.moves) - (that.manhatten + that.moves);
            return priorityDiff == 0 ? this.manhatten - that.manhatten : priorityDiff;
        }
    }
}

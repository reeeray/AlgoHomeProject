package coursera.projects_part1.Percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by Shein G.A. at 10.05.20
 **/
public class Percolation {

    private boolean[][] openedBlocks;
    private int openedSites;
    private int virtualTopNode; //top virtual node out of the cube
    private int virtualBottomNode; //bottom virtual node out of the cube
    private int size; //size of the cube
    private WeightedQuickUnionUF unionFined;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        openedSites = 0;
        openedBlocks = new boolean[n][n];
        virtualTopNode = 0;
        virtualBottomNode = n * n + 1;
        size = n;
        unionFined = new WeightedQuickUnionUF(n * n + 2);

    }

    // test client (optional)
    public static void main(String[] args) {

    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        openedSites++;
        openedBlocks[row - 1][col - 1] = true;
        if (row == 1) {
            unionFined.union(getPointIndex(row, col), virtualTopNode);
        }
        if (row == size) {
            unionFined.union(getPointIndex(row, col), virtualBottomNode);
        }

        if (row > 1 && isOpen(row - 1, col)) {
            unionFined.union(getPointIndex(row, col), getPointIndex(row - 1, col));
        }
        if (row < size && isOpen(row + 1, col)) {
            unionFined.union(getPointIndex(row, col), getPointIndex(row + 1, col));
        }

        if (col > 1 && isOpen(row, col - 1)) {
            unionFined.union(getPointIndex(row, col), getPointIndex(row, col - 1));
        }
        if (col < size && isOpen(row, col + 1)) {
            unionFined.union(getPointIndex(row, col), getPointIndex(row, col + 1));
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return openedBlocks[row - 1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row > 0 && row <= size && col > 0 && col <= size) {
            return unionFined.find(virtualTopNode) == unionFined.find(getPointIndex(row, col));
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    private int getPointIndex(int row, int col) {
        return (row - 1) * size + col; //not col -1 because it exists virtual top element
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openedSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return unionFined.find(virtualTopNode) ==  unionFined.find(virtualBottomNode);
    }
}

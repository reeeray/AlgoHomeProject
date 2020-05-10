package coursera.Percolation;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * Created by Shein G.A. at 10.05.20
 **/
public class PercolationStats {

    private int trialsNumber;
    private Percolation percolation;
    private double[] fractions;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if(n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("n and number of trials should be >= 0");
        }
        trialsNumber = trials;
        fractions = new double[trialsNumber];
        for (int i=0; i<trialsNumber; i++) { //number of experiments
            percolation = new Percolation(n);
            while (!percolation.percolates()) {
                int row = StdRandom.uniform(1, n + 1);
                int col = StdRandom.uniform(1, n + 1);
                if (!percolation.isOpen(row, col))
                    percolation.open(row, col);
            }
            double fraction = (double) percolation.numberOfOpenSites() / (n * n);
            fractions[i] = fraction;
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(fractions);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(fractions);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - ((1.96*stddev()) / Math.sqrt(trialsNumber));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + ((1.96*stddev()) / Math.sqrt(trialsNumber));
    }

    // test client (see below)
    public static void main(String[] args) {
        final int n = Integer.parseInt(args[0]);
        final int trials = Integer.parseInt(args[1]);
        PercolationStats pcStats = new PercolationStats(n, trials);

        StdOut.println("mean                = " + pcStats.mean());
        StdOut.println("stddev                = " + pcStats.stddev());
        StdOut.println("95% confidence interval   = [" + pcStats.confidenceLo() + ", " + pcStats.confidenceHi() + "]");
    }
}

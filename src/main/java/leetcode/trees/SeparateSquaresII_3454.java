package leetcode.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 14.01.2026
 **/
public class SeparateSquaresII_3454 {

    public static void main(String[] args) {

    }

    public double separateSquares(final int[][] squares) {
        // save events: (y-coordinate, type, left boundary, right boundary)
        final List<int[]> events = new ArrayList<>();
        final Set<Integer> xsSet = new TreeSet<>();

        for (final int[] sq : squares) {
            int x = sq[0];
            int y = sq[1];
            int l = sq[2];
            int xr = x + l;
            events.add(new int[] { y, 1, x, xr });
            events.add(new int[] { y + l, -1, x, xr });
            xsSet.add(x);
            xsSet.add(xr);
        }

        // sort events by y-coordinate
        events.sort((a, b) -> Integer.compare(a[0], b[0]));
        // discrete coordinates
        final int[] xs = xsSet.stream().mapToInt(i -> i).toArray();
        // initialize the segment tree
        final SegmentTree segTree = new SegmentTree(xs);

        final List<Long> psum = new ArrayList<>();
        final List<Integer> widths = new ArrayList<>();
        Long totalArea = 0L;
        int prev = events.get(0)[0];

        // scan: calculate total area and record intermediate states
        for (final int[] event : events) {
            int y = event[0];
            int delta = event[1];
            int xl = event[2];
            int xr = event[3];
            int len = segTree.query();
            totalArea += (long) len * (y - prev);
            segTree.update(xl, xr, delta);
            // record prefix sums and widths
            psum.add(totalArea);
            widths.add(segTree.query());
            prev = y;
        }

        // calculate the target area (half rounded up)
        long target = (long) (totalArea + 1) / 2;
        // binary search
        final int i = binarySearch(psum, target);
        double area = psum.get(i);
        // get the corresponding area, width, and height
        int width = widths.get(i);
        int height = events.get(i)[0];

        return height + (totalArea - area * 2) / (width * 2.0);
    }

    private int binarySearch(final List<Long> list, final long target) {
        int left = 0;
        int right = list.size() - 1;
        int result = 0;

        while (left <= right) {
            final int mid = (right + left) / 2;
            if (list.get(mid) < target) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private static class SegmentTree {

        private int[] count;
        private int[] covered;
        private int[] xs;
        private int n;

        public SegmentTree(final int[] xs) {
            this.xs = xs;
            this.n = xs.length - 1;
            this.count = new int[n * 4];
            this.covered = new int[n * 4];
        }

        private void modify(final int qleft, final int qright, final int qval, final int left, final int right, final int pos) {
            if (xs[right + 1] <= qleft || xs[left] >= qright) {
                return;
            }
            if (qleft <= xs[left] && xs[right + 1] <= qright) {
                count[pos] += qval;
            } else {
                int mid = (left + right) / 2;
                modify(qleft, qright, qval, left, mid, pos * 2 + 1);
                modify(qleft, qright, qval, mid + 1, right, pos * 2 + 2);
            }

            if (count[pos] > 0) {
                covered[pos] = xs[right + 1] - xs[left];
            } else {
                if (left == right) {
                    covered[pos] = 0;
                } else {
                    covered[pos] = covered[pos * 2 + 1] + covered[pos * 2 + 2];
                }
            }
        }

        public void update(final int qleft, final int qright, final int qval) {
            modify(qleft, qright, qval, 0, n - 1, 0);
        }

        public int query() {
            return covered[0];
        }
    }
}

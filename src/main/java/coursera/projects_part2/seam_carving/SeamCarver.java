package coursera.projects_part2.seam_carving;

import edu.princeton.cs.algs4.Picture;

import java.awt.*;

/**
 * Seam-carving is a content-aware image resizing technique where the image is reduced in size by one pixel
 * of height (or width) at a time.
 * User : Shein G.A.{@reeeray}
 * Date : 28.06.2020
 **/
public class SeamCarver {

    private static final double BORDER_PIXEL_ENERGY = 1000.D;
    private static final boolean VERTICAL = true, HORIZONTAL = false;
    private Picture pic;
    private double[] distTo;
    private int[][] edgeTo;

    /**
     * Create a seam carver object based on the given picture
     *
     * @param picture
     */
    public SeamCarver(final Picture picture) {
        if (picture == null)
            throw new IllegalArgumentException("Picture must be not null");
        this.pic = new Picture(picture);
    }

    /**
     * current picture
     *
     * @return current Picture
     */
    public Picture picture() {
        return new Picture(pic);
    }

    // width of current picture
    public int width() {
        return pic.width();
    }

    // height of current picture
    public int height() {
        return pic.height();
    }

    /**
     * Energy of pixel at column x and row y
     * You will use the dual-gradient energy function: The energy of pixel (x,y) is
     * Δ2x(x,y)+Δ2y(x,y)‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾√, where the square of the x-gradient Δ2x(x,y)=Rx(x,y)2+Gx(x,y)2+Bx(x,y)2,
     * and where the central differences Rx(x,y), Gx(x,y), and Bx(x,y) are the differences in the red, green, and
     * blue components between pixel (x + 1, y) and pixel (x − 1, y), respectively.
     *
     * @param x
     * @param y
     * @return
     */
    public double energy(int x, int y) {
        validatePixel(x, y);
        if (x == 0 || y == 0 || x == pic.width() - 1 || y == pic.height() - 1)
            return BORDER_PIXEL_ENERGY;

        double
                rx = pic.get(x + 1, y).getRed() - pic.get(x - 1, y).getRed(),
                gx = pic.get(x + 1, y).getGreen() - pic.get(x - 1, y).getGreen(),
                bx = pic.get(x + 1, y).getBlue() - pic.get(x - 1, y).getBlue(),
                ry = pic.get(x, y + 1).getRed() - pic.get(x, y - 1).getRed(),
                gy = pic.get(x, y + 1).getGreen() - pic.get(x, y - 1).getGreen(),
                by = pic.get(x, y + 1).getBlue() - pic.get(x, y - 1).getBlue();
        return Math.sqrt(rx * rx + ry * ry + bx * bx + by * by + gx * gx + gy * gy);
    }

    // sequence of indices for horizontal seam
    public int[] findHorizontalSeam() {
        return seam(HORIZONTAL);
    }

    // sequence of indices for vertical seam
    public int[] findVerticalSeam() {
        return seam(VERTICAL);
    }

    // remove horizontal seam from current picture
    public void removeHorizontalSeam(int[] seam) {
        if (seam == null || this.height() <= 1 || seam.length != this.width()) {
            throw new IllegalArgumentException();
        }

        final Picture newPicture = new Picture(this.width(), this.height() - 1);

        int prevSeam = seam[0];

        for (int x = 0; x < this.width(); x++) {
            if (Math.abs(seam[x] - prevSeam) > 1 || seam[x] < 0 || seam[x] >= this.height()) {
                throw new IllegalArgumentException();
            }
            prevSeam = seam[x];

            for (int y = 0; y < this.height(); y++) {
                if (seam[x] == y) continue;

                final Color color = pic.get(x, y);
                newPicture.set(x, seam[x] > y ? y : y - 1, color);
            }
        }

        pic = newPicture;

    }

    // remove vertical seam from current picture
    public void removeVerticalSeam(int[] seam) {
        if (seam == null || this.width() <= 1 || seam.length != this.height()) {
            throw new IllegalArgumentException();
        }

        final Picture newPicture = new Picture(this.width() - 1, this.height());

        int prevSeam = seam[0];

        for (int y = 0; y < this.height(); y++) {
            if (Math.abs(seam[y] - prevSeam) > 1 || seam[y] < 0 || seam[y] >= this.width()) {
                throw new IllegalArgumentException();
            }
            prevSeam = seam[y];

            for (int x = 0; x < this.width(); x++) {
                if (seam[y] == x) continue;

                final Color color = pic.get(x, y);
                newPicture.set(seam[y] > x ? x : x - 1, y, color);
            }
        }

        pic = newPicture;
    }

    private void validatePixel(final int x, int y) {
        if (x < 0 || x > pic.width() || y < 0 || y > pic.height())
            throw new IllegalArgumentException("Invalid pixel : x + " + x + ", y " + y);
    }

    private int[] seam(final boolean direction) {
        this.distTo = direction == VERTICAL ? new double[pic.width()] : new double[pic.height()];
        this.edgeTo = new int[pic.width()][pic.height()];

        for (int i = 0; i < distTo.length; i++)
            distTo[i] = BORDER_PIXEL_ENERGY;

        int maxI = direction == VERTICAL ? pic.height() : pic.width();
        int maxJ = direction == VERTICAL ? pic.width() : pic.height();

        for (int i = 1; i < maxI; i++) {
            double[] lastDistTo = distTo.clone();
            for (int v = 0; v < distTo.length; v++)
                distTo[v] = Double.POSITIVE_INFINITY;

            for (int j = 1; j < maxJ; j++) {
                int x = direction == VERTICAL ? j : i;
                int y = direction == VERTICAL ? i : j;

                final double energy = energy(x, y);

                relax(j - 1, x, y, energy, lastDistTo, direction);
                relax(j, x, y, energy, lastDistTo, direction);
                relax(j + 1, x, y, energy, lastDistTo, direction);
            }
        }

        double minWeight = Double.POSITIVE_INFINITY;
        int min = 0;

        for (int i = 0; i < distTo.length; i++) {
            final double weight = distTo[i];
            if (weight < minWeight) {
                minWeight = weight;
                min = i;
            }
        }

        final int[] seam = direction == VERTICAL ? new int[pic.height()] : new int[pic.width()];

        if (direction == VERTICAL) {
            for (int y = pic.height() - 1; y > -1; y--) {
                seam[y] = min;
                min = edgeTo[min][y];
            }
        } else {
            for (int x = pic.width() - 1; x > -1; x--) {
                seam[x] = min;
                min = edgeTo[x][min];
            }

        }
        return seam;
    }

    private void relax(final int prev, final int x, final int y, final double energy,
                       final double[] lastDistTo, final boolean direction) {
        if (prev < 0 || prev >= lastDistTo.length)
            return;
        final double weight = lastDistTo[prev];
        final int index = direction == VERTICAL ? x : y;
        if (distTo[index] > weight + energy) {
            distTo[index] = weight + energy;
            edgeTo[x][y] = prev;
        }

    }

    //  unit testing (optional)
    public static void main(String[] args) {

    }
}

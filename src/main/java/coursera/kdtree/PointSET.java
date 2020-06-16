package coursera.kdtree;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;


/**
 * User : Shein G.A.{@reeeray}
 * Date : 07.06.2020
 **/
public class PointSET {

    private final TreeSet<Point2D> points;

    /**
     * construct an empty set of points
     */
    public PointSET() {
        points = new TreeSet<>();
    }

    /**
     * is the set empty?
     *
     * @return
     */
    public boolean isEmpty() {
        return points.isEmpty();
    }

    /**
     * number of points in the set
     *
     * @return
     */
    public int size() {
        return points.size();
    }

    /**
     * add the point to the set (if it is not already in the set)
     *
     * @param p
     */
    public void insert(Point2D p) {
        if (p == null) throw new IllegalArgumentException();
        points.add(p);
    }

    /**
     * does the set contain point p?
     *
     * @param p
     * @return
     */
    public boolean contains(Point2D p) {
        if (p == null) throw new IllegalArgumentException();
        return points.contains(p);
    }

    /**
     * draw all points to standard draw
     */
    public void draw() {
        points.forEach(Point2D::draw);
    }

    /**
     * all points that are inside the rectangle (or on the boundary)
     *
     * @param rect
     * @return
     */
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) throw new IllegalArgumentException();
        final List<Point2D> internal = new ArrayList<>();

        points.forEach(p -> {
            if (rect.contains(p))
                internal.add(p);
        });
        return internal;
    }

    /**
     * a nearest neighbor in the set to point p; null if the set is empty
     *
     * @param p
     * @return
     */
    public Point2D nearest(Point2D p) {
        if (p == null) throw new IllegalArgumentException();
        Point2D nearest = points.iterator().next();
        double minDistance = nearest.distanceTo(p);
        for (Point2D point : points) {
            final double distance = point.distanceTo(p);
            if (distance < minDistance) {
                nearest = point;
                minDistance = distance;
            }
        }
        return nearest;
    }

    /**
     * unit testing of the methods (optional)
     *
     * @param args
     */
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int xsize = Integer.parseInt(args[1]);
        int ysize = Integer.parseInt(args[2]);

        long seed = System.currentTimeMillis();
        StdRandom.setSeed(seed);

        PointSET pointSet = new PointSET();

        for (int i = 0; i < N; i++) {
            pointSet.insert(new Point2D(StdRandom.uniform(xsize),
                    StdRandom.uniform(ysize)));
        }

        StdDraw.setCanvasSize(xsize, ysize);
        StdDraw.setXscale(0, xsize);
        StdDraw.setYscale(0, ysize);
        StdDraw.setPenRadius(0.01);
        System.out.println(pointSet.size());
        pointSet.draw();

        Point2D o = new Point2D(50, 50);
        Point2D n = pointSet.nearest(o);
        StdDraw.setPenColor(StdDraw.GREEN);
        n.draw();
        StdDraw.setPenColor(StdDraw.RED);
        o.draw();
    }
}

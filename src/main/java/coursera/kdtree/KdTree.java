package coursera.kdtree;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 07.06.2020
 **/
public class KdTree {

    private static final boolean VERTICAL = true;
    private static final RectHV CONTAINER = new RectHV(0, 0, 1, 1);

    private Node root;
    private int size;

    /**
     * Construct an empty KdTree
     */
    public KdTree() {
        this.root = null;
        this.size = 0;
    }

    /**
     * Is the tree empty ?
     * @return true if it's empty
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Number of points in the tree.
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * Insert the point in the tree (if it is not already there)
     * @param point
     */
    public void insert(final Point2D point) {
        root = insert(root, point, VERTICAL);
    }

    /**
     * Insert the point into the subtree rooted at node
     * @param node
     * @param point
     * @param vertical
     * @return
     */
    private Node insert(final Node node, final Point2D point, final boolean vertical) {

        //if node is not exists
        if (node == null) {
            size++;
            return new Node(point, vertical);
        }
        //if we found node
        if (node.point.x() == point.x() && node.point.y() == point.y())
            return node;

        //insert it where corresponds (left or right)
        if ((node.vertical && node.point.x() > point.x()) || (!node.vertical && node.point.y() > point.y()))
            node.left = insert(node.left, point, !vertical);
        else
            node.right = insert(node.right, point, !vertical);
        return node;
    }

    /**
     * If the tree contains the point
     * @param point
     * @return
     */
    public boolean contains(final Point2D point) {
        return contains(root, point);
    }

    /**
     * If the subtree rooted at node contains point
     * @param node
     * @param point
     * @return
     */
    private boolean contains(final Node node, final Point2D point) {
        if (node == null) return false;

        if (node.point.x() == point.x() && node.point.y() == point.y())
            return true;

        if ((node.vertical && node.point.x() > point.x()) || (!node.vertical && node.point.y() > point.y()))
            return contains(node.left, point);
        else
            return contains(node.right, point);
    }

    /**
     * Draw all the points
     */
    public void draw() {
        StdDraw.setScale(0, 1);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius();
        CONTAINER.draw();

        draw(root, CONTAINER);
    }

    /**
     * Draw node point and it's division line
     *
     * @param node
     * @param rect
     */
    private void draw(final Node node, final RectHV rect) {
        if (node == null) return;

        //draw the point
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.setPenRadius(0.01);
        node.point.draw();

        //calculate min and max points of the division line
        Point2D min, max;
        if (node.vertical) {
            min = new Point2D(node.point.x(), rect.ymin());
            max = new Point2D(node.point.x(), rect.ymax());
        }else {
            min = new Point2D(rect.xmin(), node.point.y());
            max = new Point2D(rect.ymax(), node.point.y());
        }

        //draw division line
        StdDraw.setPenRadius();
        min.drawTo(max);

        //recursively draw children
        draw(node.left, leftRect(node, rect));
        draw(node.right, rightRect(node, rect));
    }

    /**
     * get the left rectangle of the node's rectangle
     *
     * @param node
     * @param rect
     * @return
     */
    private RectHV leftRect(final Node node, final RectHV rect) {
        if (node.vertical) {
            return new RectHV(rect.xmin(), rect.ymin(), node.point.x(), rect.ymax());
        }else
            return new RectHV(rect.xmin(), rect.ymin(), rect.xmax(), node.point.y());
    }

    /**
     * get the right rectangle of the node's rectangle
     *
     * @param node
     * @param rect
     * @return
     */
    private RectHV rightRect(final Node node, final RectHV rect) {
        if (node.vertical) {
            return new RectHV(node.point.x(), rect.ymin(), rect.xmax(), rect.ymax());
        } else
            return new RectHV(rect.xmin(), node.point.y(), rect.xmax(), rect.ymax());
    }

    /**
     * All points of the three which are inside of the rectangle
     * @param rect
     * @return
     */
    public Iterable<Point2D> range(final RectHV rect) {
        final Queue<Point2D> queue = new Queue<>();
        range(root, CONTAINER, rect, queue);
        return queue;
    }

    /**
     * Points in subtree rooted at node which are inside the rectangle
     * @param node
     * @param rect
     * @param required
     * @param queue
     */
    private void range(final Node node, final RectHV rect, final RectHV required, final Queue queue) {
        if (node == null) return;

        if (required.intersects(rect)) {
            if (required.contains(node.point)) queue.enqueue(node.point);
            range(node.left, leftRect(node, rect), required, queue);
            range(node.right, rightRect(node, rect), required, queue);
        }
    }

    /**
     * Nearest neighbour in the tree to the input point
     * @param point
     * @return
     */
    public Point2D nearest(final Point2D point) {
        return nearest(root, CONTAINER, point, null);
    }

    /**
     * Nearest candidate in subtree rooted at node
     * @param node
     * @param rect
     * @param sample
     * @param candidate
     * @return
     */
    private Point2D nearest(final Node node, final RectHV rect, final Point2D sample, final Point2D candidate) {
        if (node == null) return candidate;

        double dqn = 0.D;
        double drq = 0.D;
        RectHV left = null;
        RectHV right = null;
        Point2D nearest = candidate;

        if (nearest != null) {
            dqn = sample.distanceSquaredTo(nearest);
            drq = rect.distanceSquaredTo(nearest);
        }

        if (nearest == null || dqn > drq) {
            final Point2D point = new Point2D(node.point.x(), node.point.y());
            if (nearest == null || dqn > sample.distanceSquaredTo(point))
                nearest = point;
            if(node.vertical) {
                left = new RectHV(rect.xmin(), rect.ymin(), node.point.x(), rect.ymax());
                right = new RectHV(node.point.x(), rect.ymin(), rect.xmax(), rect.ymax());

                if (sample.x() < node.point.x()) {
                    nearest = nearest(node.left, left, sample, nearest);
                    nearest = nearest(node.right, right, sample, nearest);
                } else {
                    nearest = nearest(node.right, right, sample, nearest);
                    nearest = nearest(node.left, left, sample, nearest);
                }
            } else {
                left = new RectHV(rect.xmin(), rect.ymin(), rect.xmax(), node.point.y());
                right = new RectHV(rect.xmin(), node.point.y(), rect.xmax(), rect.ymax());

                if (sample.y() < node.point.y()) {
                    nearest = nearest(node.left, left, sample, nearest);
                    nearest = nearest(node.right, right, sample, nearest);
                } else {
                    nearest = nearest(node.right, right, sample, nearest);
                    nearest = nearest(node.left, left, sample, nearest);
                }

            }
        }
        return nearest;
    }


    private static class Node {

        private Point2D point;
        private boolean vertical;
        private Node left, right;

        public Node(final Point2D point, final boolean vert) {
            this.point = point;
            this.vertical = vert;
        }
    }
}

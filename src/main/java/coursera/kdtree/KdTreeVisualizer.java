package coursera.kdtree;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 16.06.2020
 **/
public class KdTreeVisualizer {
//    public static void main(String[] args) {
//        StdDraw.show(0);
//        KdTree kdtree = new KdTree();
//
//        while (true) {
//            if (StdDraw.mousePressed()) {
//                double x = StdDraw.mouseX();
//                double y = StdDraw.mouseY();
//                System.out.printf("%8.6f %8.6f\n", x, y);
//                Point2D p = new Point2D(x, y);
//                kdtree.insert(p);
//                StdDraw.clear();
//                kdtree.draw();
//            }
//
//            StdDraw.show(50);
//        }
//    }

    public static void main(String[] args) {
        RectHV rect = new RectHV(0.0, 0.0, 1.0, 1.0);
        StdDraw.enableDoubleBuffering();
        KdTree kdtree = new KdTree();
        while (true) {
            if (StdDraw.isMousePressed()) {
                double x = StdDraw.mouseX();
                double y = StdDraw.mouseY();
                StdOut.printf("%8.6f %8.6f\n", x, y);
                Point2D p = new Point2D(x, y);
                if (rect.contains(p)) {
                    StdOut.printf("%8.6f %8.6f\n", x, y);
                    kdtree.insert(p);
                    StdDraw.clear();
                    kdtree.draw();
                    StdDraw.show();
                }
            }
            StdDraw.pause(20);
        }

    }
}

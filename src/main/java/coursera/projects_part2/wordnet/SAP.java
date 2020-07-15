package coursera.projects_part2.wordnet;


import edu.princeton.cs.algs4.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 21.06.2020
 **/
public class SAP {

    private static final int INFINITY = Integer.MAX_VALUE;
    private final Digraph digraph;

    /**
     * Constructor takes a digraph (not necessarily a DAG)
     *
     * @param digraph
     */
    public SAP(final Digraph digraph) {
        checkValidity(digraph == null);
        this.digraph = digraph;
    }

    /**
     * Length of shortest ancestral path between v and w; -1 if no such path
     *
     * @param v
     * @param w
     * @return
     */
    public int length(final int v, final int w) {
        checkValidity(v < 0 || v >= digraph.V());
        checkValidity(w < 0 || w >= digraph.V());

        final BreadthFirstDirectedPaths bfsV = new BreadthFirstDirectedPaths(digraph, v);
        final BreadthFirstDirectedPaths bfsW = new BreadthFirstDirectedPaths(digraph, w);

        int length = INFINITY;
        for (int vertex = 0; vertex < digraph.V(); vertex++) {
            if (bfsV.hasPathTo(vertex) && bfsW.hasPathTo(vertex)) {
                final int l = bfsV.distTo(vertex) + bfsW.distTo(vertex);
                if (l < length)
                    length = l;
            }
        }
        return length == INFINITY ? -1 : length;
    }

    /**
     * A common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
     *
     * @param v
     * @param w
     * @return
     */
    public int ancestor(final int v, final int w) {
        checkValidity(v < 0 || v >= digraph.V());
        checkValidity(w < 0 || w >= digraph.V());

        final BreadthFirstDirectedPaths bfsV = new BreadthFirstDirectedPaths(digraph, v);
        final BreadthFirstDirectedPaths bfsW = new BreadthFirstDirectedPaths(digraph, w);

        int length = INFINITY;
        int ancestor = -1;
        for (int vertex = 0; vertex < digraph.V(); vertex++) {
            if (bfsV.hasPathTo(vertex) && bfsW.hasPathTo(vertex)) {
                final int l = bfsV.distTo(vertex) + bfsW.distTo(vertex);
                if (l < length) {
                    length = l;
                    ancestor = vertex;
                }
            }
        }
        return ancestor;
    }

    /**
     * Length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
     *
     * @param v
     * @param w
     * @return
     */
    public int length(final Iterable<Integer> v, final Iterable<Integer> w) {
        checkValidity(v == null || w == null);
        v.forEach(vertex -> checkValidity(vertex < 0 || vertex >= digraph.V()));
        w.forEach(vertex -> checkValidity(vertex < 0 || vertex >= digraph.V()));

        int length = INFINITY;

        for (int vertex : v) {
            for (int wertex : w) {
                int l = length(v, w);
                if (l != -1 && l < length)
                    length = l;
            }
        }
        return length == INFINITY ? -1 : length;
    }

    /**
     * A common ancestor that participates in shortest ancestral path; -1 if no such path
     *
     * @param v
     * @param w
     * @return
     */
    public int ancestor(final Iterable<Integer> v, final Iterable<Integer> w) {
        checkValidity(v == null || w == null);
        v.forEach(vertex -> checkValidity(vertex < 0 || vertex >= digraph.V()));
        w.forEach(vertex -> checkValidity(vertex < 0 || vertex >= digraph.V()));

        int length = INFINITY;
        int ancestor = -1;

        for (int vertex : v) {
            for (int wertex : w) {
                int l = length(v, w);
                if (l != -1 && l < length) {
                    length = l;
                    ancestor = ancestor(vertex, wertex);
                }
            }
        }
        return ancestor;
    }

    private void checkValidity(final boolean condition) {
        if (condition)
            throw new IllegalArgumentException("Argument must be valid");
    }

    /**
     * do unit testing of this class
     *
     * @param args
     */
    public static void main(String[] args) {
        StdOut.println(args[0]);
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        SAP sap = new SAP(G);
        while (!StdIn.isEmpty()) {
            int v = StdIn.readInt();
            int w = StdIn.readInt();
            int length = sap.length(v, w);
            int ancestor = sap.ancestor(v, w);
            StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
        }
    }


}

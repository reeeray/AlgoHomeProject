package coursera.data_structures.graph.directed.shortest_path;

import coursera.data_structures.graph.directed.DirectedEdge;
import coursera.data_structures.graph.directed.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.Stack;

/**
 * Generic Algorithm (to compute SPT from s):
 * Initialize distTo[s] = 0 and and distTo[v] = Infinite for all other vertices.
 * Repeat until optimality conditions(for each vertex (v1) : distTo[v1] <= distTo[v0] + e1.weight) are satisfied :
 * - Relax any edge;
 * User : Shein G.A.{@reeeray}
 * Date : 26.06.2020
 **/
public class ShortestPath {

    private final double[] distTo;
    private final DirectedEdge[] edgeTo;

    public ShortestPath(final EdgeWeightedDigraph graph) {
        this.distTo = new double[graph.getV()];
        this.edgeTo = (DirectedEdge[]) new Object[graph.getV()];
    }

    public double distTo(final int v) {
        return distTo[v];
    }

    public Iterable<DirectedEdge> pathTo(final int v) {
        final Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
            path.push(e);
        return path;
    }

    public void relax(final DirectedEdge e) {
        final int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.getWeight()) {
            distTo[w] = distTo[v] + e.getWeight();
            edgeTo[w] = e;
        }
    }

}

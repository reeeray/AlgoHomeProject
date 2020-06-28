package coursera.data_structures.graph.undirected.mst;

import coursera.data_structures.graph.undirected.Edge;
import coursera.data_structures.graph.undirected.EdgeWeightedGraph;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

;

/**
 * Prim's algorithm of finding mst int a graph.
 * Running time : E*Log(E) in worst case.
 * Extra space ~E
 * <p>
 * Starts with 0 edge and adding one edge through the step to the tree which is the shortest to the builded part of the tree.
 * User : Shein G.A.{@reeeray}
 * Date : 26.06.2020
 **/
public class LazyPrimsMST {

    private final boolean[] marked; //MST vertices
    private final Queue<Edge> mst; //MST edges
    private final MinPQ<Edge> pq; //Priority Queue of edges

    public LazyPrimsMST(final EdgeWeightedGraph graph) {
        marked = new boolean[graph.getV()];
        mst = new Queue<>();
        pq = new MinPQ<>();

        visit(graph, 0); //assume graph connected

        while (!pq.isEmpty()) {
            final Edge e = pq.delMin();//repeatedly delete the min weight edge e=v-w from PQ
            int v = e.either(), w = e.other(v);
            if (marked[v] && marked[w]) continue; //ignore if both endpoints in tree
            mst.enqueue(e); // add edge e to tree
            if (!marked[v]) visit(graph, v); //add v or w to tree
            if (!marked[w]) visit(graph, w);
        }
    }

    private void visit(final EdgeWeightedGraph graph, final int vertex) {
        marked[vertex] = true;
        for (Edge e : graph.adj(vertex)) {
            if (!marked[e.other(vertex)])
                pq.insert(e);
        }
    }

    public Iterable<Edge> mst() {
        return mst;
    }

}

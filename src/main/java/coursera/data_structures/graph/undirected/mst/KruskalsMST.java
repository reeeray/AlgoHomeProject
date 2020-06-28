package coursera.data_structures.graph.undirected.mst;

import coursera.data_structures.graph.undirected.Edge;
import coursera.data_structures.graph.undirected.EdgeWeightedGraph;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.06.2020
 **/
public class KruskalsMST {

    private final Queue<Edge> mst = new Queue<>();

    //Kruskal graph. Time : ElogE (E -number of Edg es)
    public KruskalsMST(final EdgeWeightedGraph graph) {
        final MinPQ<Edge> pq = new MinPQ<>();//build priority queue
        //элегантный способ отсортировать веса ребер по возрастанию

        for (Edge edge : graph.edges()) {
            pq.insert(edge);
        }

        final UF uf = new UF(graph.getV());

        while (!pq.isEmpty() || mst.size() < graph.getV() - 1) { //greedily add edges to MST
            final Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            if (!uf.connected(v, w)) { //check if v and w verticies doesn't create an cycle
                uf.union(v, w);
                mst.enqueue(e);

            }
        }
    }

    public Iterable<Edge> edgesMST() {
        return mst;
    }
}

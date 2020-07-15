package coursera.data_structures.graph.directed.shortest_path;

import coursera.data_structures.graph.directed.DirectedEdge;
import coursera.data_structures.graph.directed.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.IndexMinPQ;

/**
 * Dijkstra(btw he is from Netherlands)  Shortest Path Algorithm :
 * Applicable only  for graphs with non negative edge weights
 * based on binary heap :
 * Time : ElogV. Extra Space : V
 * User : Shein G.A.{@reeeray}
 * Date : 26.06.2020
 **/
public class DijkstraSP {

    private final double[] distTo;
    private final DirectedEdge[] edgeTo;
    private final IndexMinPQ<Double> pq;

    public DijkstraSP(final EdgeWeightedDigraph graph, final int s) {
        this.distTo = new double[graph.getV()];
        this.edgeTo = (DirectedEdge[]) new Object[graph.getV()];
        this.pq = new IndexMinPQ<>(graph.getV());

        for (int v = 0; v < graph.getV(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0D;

        pq.insert(s, 0.0);

        while (!pq.isEmpty()) {
            final int vertex = pq.delMin();
            for (DirectedEdge e : graph.adj(vertex))
                relax(e);
        }
    }

    private void relax(final DirectedEdge edge) {
        final int v = edge.from(), w = edge.to();
        if (distTo[w] > distTo[v] + edge.getWeight()) {
            distTo[w] = distTo[v] + edge.getWeight();
            edgeTo[w] = edge;
            if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
            else pq.insert(w, distTo[w]);

        }
    }
}

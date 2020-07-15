package coursera.data_structures.graph.directed.shortest_path;

import coursera.data_structures.graph.directed.DirectedEdge;
import coursera.data_structures.graph.directed.EdgeWeightedDigraph;
import coursera.data_structures.graph.directed.OrderedDFS;

/**
 * Algorithm of finding shortest path in acyclic weighted digraph ( weights can be negative).
 * This case is simpler because it is base on the topological order. We need to relax each edge only once.
 * Computes the shortest-path tree for V + E
 * Extra space : V
 * <p>
 * !!!NOTE : It's the same algorithm to find longest path problem : all what we need to do - just change all values * (-1)
 * <p>
 * User : Shein G.A.{@reeeray}
 * Date : 28.06.2020
 **/
public class AcyclicSP {

    private final DirectedEdge[] edgeTo;
    private final double[] distTo;

    public AcyclicSP(final EdgeWeightedDigraph graph, final int s) {
        edgeTo = new DirectedEdge[graph.getV()];
        distTo = new double[graph.getV()];

        for (int i = 0; i < graph.getV(); i++)
            distTo[i] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0;

        //final Topological order = new Topological(graph);
        final OrderedDFS topological = new OrderedDFS(graph);
        for (Integer vertex : topological.reversePost()) {
            for (DirectedEdge edge : graph.adj(vertex))
                relax(edge);
        }
    }

    public void relax(final DirectedEdge edge) {
        final int v = edge.from(), w = edge.to();

        if (distTo[w] > distTo[v] + edge.getWeight()) {
            distTo[w] = distTo[v] + edge.getWeight();
            edgeTo[w] = edge;
        }
    }
}

package coursera.data_structures.graph.directed;

import edu.princeton.cs.algs4.Bag;
import lombok.Getter;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.06.2020
 **/
public class EdgeWeightedDigraph {

    @Getter
    private final int V;
    private final Bag<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(final int V) {
        this.V = V;
        this.adj = (Bag<DirectedEdge>[]) new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }

    public void addEdge(final DirectedEdge edge) {
        adj[edge.from()].add(edge);
    }

    public Iterable<DirectedEdge> adj(final int v) {
        return adj[v];
    }
}

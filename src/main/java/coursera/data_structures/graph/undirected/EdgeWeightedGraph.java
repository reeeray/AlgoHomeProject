package coursera.data_structures.graph.undirected;

import edu.princeton.cs.algs4.Bag;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 22.06.2020
 **/
public class EdgeWeightedGraph {

    @Getter
    private final int V;
    private final Bag<Edge>[] adj;

    public EdgeWeightedGraph(final int vertices) {
        this.V = vertices;
        this.adj = (Bag<Edge>[]) new Bag[vertices];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }

    public void addEdge(final Edge e) {
        final int v = e.either(), w = e.other(v);

        adj[v].add(e);
        adj[w].add(e);
    }

    /**
     * Returns all edges in this edge-weighted graph.
     * To iterate over the edges in this edge-weighted graph, use foreach notation:
     * {@code for (Edge e : G.edges())}.
     *
     * @return all edges in this edge-weighted graph, as an iterable
     */
    public Iterable<Edge> edges() {
        final List<Edge> list = new ArrayList<>();
        for (int v = 0; v < V; v++) {
            int selfLoops = 0;
            for (Edge e : adj(v)) {
                if (e.other(v) > v) {
                    list.add(e);
                }
                // add only one copy of each self loop (self loops will be consecutive)
                else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0) list.add(e);
                    selfLoops++;
                }
            }
        }
        return list;
    }

    public Iterable<Edge> adj(final int v) {
        return adj[v];
    }
}

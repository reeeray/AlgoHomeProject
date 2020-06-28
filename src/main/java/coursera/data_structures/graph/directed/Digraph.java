package coursera.data_structures.graph.directed;

import edu.princeton.cs.algs4.Bag;
import lombok.Getter;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 21.06.2020
 **/
public class Digraph {
    @Getter
    private final int V;
    private final Bag<Integer>[] adj;

    public Digraph(final int vertices) {
        this.V = vertices;
        this.adj = (Bag<Integer>[]) new Bag[V];
        for (Bag<Integer> item : adj)
            item = new Bag<>();
    }

    public void addEdge(final int v, final int w) {
        //Direction gRAPH V -> W
        adj[v].add(w);
    }

    public Iterable<Integer> adj(final int v) {
        return adj[v];
    }

    /**
     * Reverse all edges in the graph
     *
     * @return
     */
    public Digraph reverse() {
        return null;
    }

}

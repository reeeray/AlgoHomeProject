package coursera.data_structures.graph;

import edu.princeton.cs.algs4.Bag;
import lombok.Getter;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 01.07.2020
 **/
public class FlowNetwork {

    @Getter
    private final int V;
    private final Bag<FlowEdge>[] adj;

    public FlowNetwork(final int V) {
        this.V = V;
        adj = (Bag<FlowEdge>[]) new Bag[V];

        for (int v = 0; v < V; v++)
            adj[v] = new Bag<>();
    }

    public void addEdge(final FlowEdge e) {
        int v = e.from();
        int w = e.to();
        adj[v].add(e); //add forward edge
        adj[w].add(e); //add backward edge
    }

    public Iterable<FlowEdge> adj(final int v) {
        return adj[v];
    }
}

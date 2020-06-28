package coursera.data_structures.graph.undirected;

import edu.princeton.cs.algs4.Bag;

/**
 * Undirected graph
 * User : Shein G.A.{@reeeray}
 * Date : 21.06.2020
 **/
public class Graph {
    private final int V;
    private final Bag<Integer>[] adj; //adjacency lists

    public Graph(final int vertices) {
        //create an empty graph with V vertices
        this.V = vertices;
        adj = (Bag<Integer>[]) new Bag[vertices];

        for (Bag<Integer> item : adj) {
            item = new Bag<Integer>();
        }
    }

    public void addEdge(final int v, final int w) { //add edge v-w
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(final int v) { //iterator to vertices adjacent to v
        return adj[v];
    }


}

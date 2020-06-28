package coursera.data_structures.graph.directed;

/**
 * Depth first search for directed graph
 * User : Shein G.A.{@reeeray}
 * Date : 21.06.2020
 **/
public class DigraphDFS {

    private boolean[] marked; //true if path from s
    private int[] edgeTo;

    public DigraphDFS(final Digraph digraph, final int s) {
        marked = new boolean[digraph.getV()];
        dfs(digraph, s);
    }

    private void dfs(final Digraph graph, final int v) {
        marked[v] = true;
        for (int vertex : graph.adj(v)) {
            if (!marked[vertex])
                dfs(graph, vertex);
        }
    }

    public boolean visited(final int vertex) {
        return marked[vertex];
    }
}

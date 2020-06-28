package coursera.data_structures.graph.directed;

import java.util.Stack;

/**
 * Depth First Search Order. When we are solving the problem with ordered vertices (for example which courses
 * we needed to take before another one).
 * User : Shein G.A.{@reeeray}
 * Date : 21.06.2020
 **/
public class OrderedDFS {

    private boolean[] marked;
    private Stack<Integer> reversePost;

    public OrderedDFS(final Digraph graph) {
        marked = new boolean[graph.getV()];
        reversePost = new Stack<>();

        for (int v = 0; v < graph.getV(); v++)
            if (!marked[v])
                dfs(graph, v);
    }

    private void dfs(final Digraph digraph, final int vertex) {
        marked[vertex] = true;
        for (int v : digraph.adj(vertex))
            if (!marked[v])
                dfs(digraph, v);
        reversePost.push(vertex);
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }
}

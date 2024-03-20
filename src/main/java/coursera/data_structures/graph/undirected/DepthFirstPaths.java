package coursera.data_structures.graph.undirected;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Stack;

/**
 * DFS(Depth First Paths) поиск в глубину
 * <p>
 * User : Shein G.A.{@reeeray}
 * Date : 20.06.2020
 **/
public class DepthFirstPaths {

    private boolean[] marked; // marked[v] = true if v connected to s
    private int[] edgeTo; //edgeTo[v] = previous vertex on path from s to v
    private int s;

    public DepthFirstPaths(final Graph graph, final int s) {
        //initialize Graph_2642
        dfs(graph, s); //find vertices connected to s
    }

    public boolean hasPathTo(final int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(final int vertex) {
        if (!hasPathTo(vertex)) return null;
        final Stack<Integer> stack = new Stack<>();
        for (int v = vertex; v != s; v = edgeTo[v])
            stack.push(v);
        stack.push(s);
        return stack;
    }

    public void dfs(final Graph graph, final int vertex) {
        marked[vertex] = true;
        Iterable<Integer> connectedVertices = graph.adj(vertex);
        for (Integer v : connectedVertices) {
            if (!marked[v]) {
                marked[v] = true;
                dfs(graph, v);
                edgeTo[v] = vertex;
            }
        }
    }
}

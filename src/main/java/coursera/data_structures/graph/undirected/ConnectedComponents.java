package coursera.data_structures.graph.undirected;

import edu.princeton.cs.algs4.Graph;

/**
 * Data Structure which helping to find out connected components on the graph.
 * Constant time
 * User : Shein G.A.{@reeeray}
 * Date : 20.06.2020
 **/
public class ConnectedComponents {

    private boolean[] marked;
    private int[] id; //id[v] = id of component containing v
    private int count; // number of components

    public ConnectedComponents(final Graph graph) {
        marked = new boolean[graph.V()];
        id = new int[graph.V()];
        for (int v = 0; v < graph.V(); v++) {
            if (!marked[v]) {
                marked[v] = true;
                dfs(graph, v); //run DFS from one vertex in each component
                count++;
            }
        }
    }

    public int count() {
        return count;
    }

    public int id(final int vertex) {
        return id[vertex];
    }

    private void dfs(final Graph graph, final int v) {
        marked[v] = true;
        id[v] = count;
        for (Integer vertex : graph.adj(v)) {
            if (!marked[vertex])
                dfs(graph, vertex);
        }
    }
}

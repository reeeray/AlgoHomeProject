package coursera.data_structures.graph.directed;

/**
 * Kosaraju-Sharir algorithm to compute Strong Connected Components on the Digraph.
 * Component is strongly connected if every vertex is reachable from every other vertex.
 * <p>
 * Algorithm :
 * 1) Make reverse graph
 * 2) run DFS on reverse graph to compute reverse postorder
 * 3) run DFS on original graph considering vertices in order given by first DFS.
 * User : Shein G.A.{@reeeray}
 * Date : 21.06.2020
 **/
public class ConnectedComponent {

    private boolean[] marked;
    private int[] id;
    private int count;

    public ConnectedComponent(final Digraph graph) {
        marked = new boolean[graph.getV()];
        id = new int[graph.getV()];
        final OrderedDFS dfs = new OrderedDFS(graph.reverse());
        for (int v : dfs.reversePost()) {
            if (!marked[v]) {
                dfs(graph, v);
                count++;
            }
        }
    }

    private void dfs(final Digraph graph, final int s) {

    }

    public boolean stronglyConnected(final int v, final int w) {
        return id[v] == id[w];
    }
}

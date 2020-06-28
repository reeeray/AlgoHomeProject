package coursera.data_structures.graph.undirected;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Queue;

/**
 * BFS(Breadth First Paths) поиск в ширину.
 * It solves the problem of the shortest path from node s.
 * User : Shein G.A.{@reeeray}
 * Date : 20.06.2020
 **/
public class BreadthFirstPath {

    private boolean[] marked;
    private int[] edgeTo;

    private void bfs(final Graph graph, final int s) {
        final Queue<Integer> vertices = new Queue<>();
        vertices.enqueue(s);
        marked[s] = true;
        while (!vertices.isEmpty()) {
            final int start = vertices.dequeue();
            for (Integer v : graph.adj(start)) {
                if (!marked[v]) {
                    marked[v] = true;
                    vertices.enqueue(v);
                    edgeTo[v] = start;
                }
            }
        }
    }
}

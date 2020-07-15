package coursera.data_structures.graph;

import edu.princeton.cs.algs4.Queue;

/**
 * Algorithm for compute max flow and min cut issues
 * User : Shein G.A.{@reeeray}
 * Date : 01.07.2020
 **/
public class FordFulkersonAlgorithm {

    private boolean[] marked;  //true if s->v path in residual network
    private FlowEdge[] edgeTo; // last edge on s-> v path
    private double value; //value of flow

    public FordFulkersonAlgorithm(final FlowNetwork graph, final int s, final int t) {
        value = 0.0;
        while (hasAugmentingPath(graph, s, t)) {
            double bottle = Double.POSITIVE_INFINITY;
            for (int v = t; v != s; v = edgeTo[v].other(v)) //compute bottleneck capacity
                bottle = Math.min(bottle, edgeTo[v].residualCapacityTo(v));

            for (int v = t; v != s; v = edgeTo[v].other(v)) //augment flow
                edgeTo[v].addResidualFlowTo(v, bottle);

            value += bottle;
        }
    }

    //Finding a shortest augmenting path (breadth-first search)
    private boolean hasAugmentingPath(final FlowNetwork graph, final int s, final int t) {
        edgeTo = new FlowEdge[graph.getV()];
        marked = new boolean[graph.getV()];

        final Queue<Integer> q = new Queue<>();
        q.enqueue(s);
        marked[s] = true;
        while (!q.isEmpty()) {
            final int v = q.dequeue();

            for (FlowEdge edge : graph.adj(v)) {
                final int w = edge.other(v);
                if (edge.residualCapacityTo(w) > 0 && !marked[w]) { //found path from s to w in the residual network?
                    edgeTo[w] = edge; // save the last edge on path to w;
                    marked[w] = true; // mark w
                    q.enqueue(w); //add w to queue
                }
            }
        }
        return marked[t]; //is t reachable from s in residual network
    }

    public double value() {
        return value;
    }

    public boolean inCut(final int vertex) { //is v reachable from s in residual network?
        return marked[vertex];
    }
}

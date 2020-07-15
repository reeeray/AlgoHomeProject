package coursera.data_structures.graph.directed.shortest_path;

/**
 * Bell-Ford Algorithm for finding shortest path in graph with negative weights BUT without negative cycles!
 * <p>
 * Go V times through the each of the V vertices and relax each edge
 * <p>
 * Time : EV Space : V
 * based on queue : Best case : E + V. Worst : EV. Space : V.
 * <p>
 * How to understand if there is negative cycle : (Negative cycle detection problem)
 * run the Bellman-Ford algorithm and if some vertex get updated the last time through - there is a negative cycle.
 * User : Shein G.A.{@reeeray}
 * Date : 28.06.2020
 **/
public class BellFordSP {
}

package coursera.data_structures.graph.undirected;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 22.06.2020
 **/
public class Edge implements Comparable<Edge> {

    private final int v, w;
    private final double weight;

    public Edge(final int v, final int w, final int weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either() {
        return this.v;
    }

    public int other(final int vertex) {
        if (vertex == v) return w;
        return v;
    }


    @Override
    public int compareTo(Edge other) {
        if (this.weight < other.weight) return -1;
        else if (this.weight > other.weight) return 1;
        else return 0;
    }
}

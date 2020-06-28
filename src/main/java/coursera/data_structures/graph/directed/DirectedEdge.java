package coursera.data_structures.graph.directed;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.06.2020
 **/
public class DirectedEdge {

    private final double weight;
    private final int v, w;

    public DirectedEdge(final int v, final int w, final double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int from() {
        return this.v;
    }

    public int to() {
        return this.w;
    }

    public double getWeight() {
        return weight;
    }
}

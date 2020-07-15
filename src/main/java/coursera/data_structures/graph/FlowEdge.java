package coursera.data_structures.graph;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 01.07.2020
 **/
public class FlowEdge {

    private final int v, w;
    private final double capacity;
    private double flow;

    public FlowEdge(final int v, final int w, final double capacity) {
        this.v = v;
        this.w = w;
        this.capacity = capacity;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getFlow() {
        return flow;
    }

    public int other(final int vertex) {
        if (v == vertex) return w;
        else if (w == vertex) return v;
        else throw new RuntimeException("Wrong vertex at this edge");
    }

    public double residualCapacityTo(final int vertex) {
        if (v == vertex) return flow; //backward edge
        else if (w == vertex) return capacity - flow; // forward edge
        else throw new RuntimeException("Wrong vertex at this edge");
    }

    public void addResidualFlowTo(final int vertex, final double value) {
        if (v == vertex) flow -= value;
        else if (w == flow) flow += value;
        else throw new RuntimeException("Wrong vertex at this edge");
    }
}

package coursera;

/**
 * Eager algorithm for solving connectivity problem
 * Number of array accesses
 *                     initialize   union   find
 *  quick-union find        N         N       1
 *
 *  Problem : takes N^2 accesses to process sequence of N union commands of N objects
 *  It is not accessible because quadratic algorithms is not scalable with technologies.
 * Created by Shein G.A. at 10.05.20
 **/
public class QuickFind {

    private int[] id;

    //N array accesses
    public QuickFind(final int N) {
        id = new int[N];
        for(int i=0; i<N; i++) {
            id[i] = i;
        }
    }

    //2 array accesses
    public boolean connected(final int node1, final int node2) {
        return id[node1] == id[node2];
    }

    //2N+2 array accesses at most
    public void union(final int node1, final int node2) {
        final int node1Id = id[node1];
        final int node2Id = id[node2];

        for(int i=0; i<id.length; i++) {
            if(id[i] == node1Id)
                id[i] = node2Id;
        }
    }
}

package coursera.find_algorithms;

/**
 * Laze approach
 *  * Number of array accesses
 *  *                     initialize   union   find
 *  *  quick-union find        N         N       N
 *  *
 *  TRees can get tall. Find(connected) too expensive, can be N.
 *  Improvements :
 *      - Weighted quick-union : joining root of the smallest tree to the root of biggest one.
 *          Benefit : depth will be maximum lg(N) = a -> 2^a = N.
 *          Cons: we need to maintain additional array
 *                      initialize  union   find
 *                          N        lg(N)   lg(N)
 *      - Path compression : after computing the root of p, set the i of each examined node to point to that root. We are flattening the tree.
 *
 *
 * Created by Shein G.A. at 10.05.20
 **/
//lazy
public class QuickUnion {

    private int[] id;
    private int[] size;

    public QuickUnion(final int N) {
        id = new int[N];
        size = new int[N];
        for(int i=0; i<N; i++) {
            id[i] = i;
        }
    }

    private int root (int node) {
        while(node != id[node]) {
            id[node] = id[id[node]];
            node = id[node];
        }
        return node;
    }
    //might be N
    public boolean connected(final int node1, final int node2) {
        return root(node1) == root(node2);
    }

    public void union(final int node1, final int node2) {
        final int root1 = root(node1);
        final int root2 = root(node2);
       /* if(root1 == root2) return;
        if(size[root1] > size[root2]) {
            id[root2] = root1;
            size[root1] += size[root2];
        }else {
            id[root1] = root2;
            size[root2] += size[root1];
        }*/
        id[root1] = root2;
    }
}

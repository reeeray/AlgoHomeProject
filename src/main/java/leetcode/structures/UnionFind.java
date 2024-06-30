package leetcode.structures;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 30.06.2024
 **/
public class UnionFind {

    private int[] edges;
    private int components;

    public UnionFind(final int n) {
        components = 1;
        edges = new int[n+1];
        //initial initialization where each node it's own parent
        for(int i = 0; i <= n; i++) {
            edges[i] = i;
        }
    }

    //method which return parent of the n-th node
    public int find(final int n) {
        int index = n;
        while ( index != edges[index]) {
            index = edges[index];
        }
        return index;
    }

    //it union two edges between each other, assign parent of one to parent of the other and vice versa
    public int union(final int a, final int b) {
        final int rootA = find(a);
        final int rootB = find(b);

        if(rootA == rootB) {
            return 0;
        }
        edges[rootA] = rootB;
        components--;

        return 1;
    }

    public boolean isConntected() {
        return components == 1;
    }
}

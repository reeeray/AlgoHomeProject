package leetcode.graphs;

import leetcode.structures.UnionFind;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 30.06.2024
 **/
public class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable_1579 {

    public static void main(String[] args) {
        final int[][] input = new int[][] {{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}};
        assert maxNumberEdgesToRemove(4, input) == 2;

    }

    //typical issue for Union Find algorithm/data structure
    //Space complexity O(n) and time is O(e) where e is number of edges
    public static int maxNumberEdgesToRemove(final int n, final int[][] edges) {
        final UnionFind alice = new UnionFind(n);
        final UnionFind bob = new UnionFind(n);
        int redundant = 0;
        for(final int[] edge : edges) {
            if(edge[0] == 3) {
                if(alice.union(edge[1], edge[2]) != 1 & bob.union(edge[1], edge[2]) != 1) {
                    redundant++;
                }
            }
        }

        for(final int[] edge : edges) {
            if(edge[0] == 1 && alice.union(edge[1], edge[2]) != 1) {
                redundant++;
            } else if (edge[0] == 2 && bob.union(edge[1], edge[2]) != 1) {
                    redundant++;
            }
        }

        //if we will compare all of them - TLE
//        final int uniqueRootAlice = alice.find(1);
//        final int uniqueRootBob = bob.find(1);
//        for(int i=1; i<n; i++) {
//            if(alice.find(i) != uniqueRootAlice || bob.find(i) != uniqueRootBob) {
//                return -1;
//            }
//        }
        if(alice.isConntected() && bob.isConntected()) {
            return redundant;
        }

        return -1;
    }
}

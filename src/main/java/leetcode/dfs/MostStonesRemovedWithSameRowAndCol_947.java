package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 29.08.2024
 **/
public class MostStonesRemovedWithSameRowAndCol_947 {

    public static void main(String[] args) {
        final int[][] input = new int[][]{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        removeStones(input);
    }

    //Time O(n*n) and space O(n*n)
    public static int removeStones(final int[][] stones) {
        final int n = stones.length;
        final List<Integer>[] neighbors = new List[n];
        for(int i=0; i<n; i++) {
            neighbors[i] = new ArrayList<>();
        }

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    neighbors[i].add(j);
                    neighbors[j].add(i);
                }
            }
        }

        int nOfConnectedComponents = 0;
        final boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(neighbors, visited, i);
                nOfConnectedComponents++;
            }
        }
        return n - nOfConnectedComponents;
    }

    private static void dfs(final List<Integer>[] neighbors, final boolean[] visited, final int idx) {
        visited[idx] = true;
        for(int i : neighbors[idx]) {
            if(!visited[i]) {
                dfs(neighbors, visited, i);
            }
        }
    }
}

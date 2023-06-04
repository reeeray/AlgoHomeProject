package leetcode.dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 04.06.2023
 **/
public class NumberOfProvinces_547 {

    public static void main(String[] args) {
        final int[][] input = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(findCircleNum(input));

    }

    //DFS applicable
    private static int findCircleNum(final int[][] isConnected) {
        final int n = isConnected.length;
        final boolean[] visited = new boolean[n];
        int count = 0;
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(isConnected, visited, i, i + 1);
                count++;
            }
        }

        return count;
    }

    private static void dfs(final int[][] isConnected, final boolean[] visited, final int index, final int circle) {
        if(visited[index]) {
            return;
        }
        visited[index] = true;

        for(int i=0; i<isConnected.length; i++) {
            if(isConnected[index][i] == 1) {
                dfs(isConnected, visited, i, circle);
            }
        }
    }

    public int findCircleNumBDFS(int[][] isConnected) {
        boolean vis[]=new boolean[isConnected.length];
        int c = 0;
        for(int i=0;i<isConnected.length;i++){
            if(!vis[i]){
                bfs(i,isConnected,vis);
                c++;
            }
        }
        return c;
    }
    public void bfs(int s, int grid[][], boolean vis[]){
        vis[s] = true;
        final Queue<Integer> curr = new LinkedList<>();
        curr.add(s);
        while(!curr.isEmpty()){
            int cur = curr.poll();
            for(int i =0;i<grid.length;i++){
                if(!vis[i] && grid[cur][i]==1){
                    vis[i] = true;
                    curr.add(i);
                }
            }
        }
    }

//    //DFS applicable
//    private static int findCircleNum(final int[][] isConnected) {
//        final int n = isConnected.length;
//        final int[] visited = new int[n];
//        for(int i=0; i<n; i++) {
//            dfs(isConnected, visited, i, i+1);
//        }
//
//        return (int)Arrays.stream(visited).distinct().count();
//    }
//
//    private static void dfs(final int[][] isConnected, final int[] visited, final int index, final int circle) {
//        if(visited[index] != 0) {
//            return;
//        }
//        visited[index] = circle;
//
//        for(int i=0; i<isConnected.length; i++) {
//            if(isConnected[index][i] == 1) {
//                dfs(isConnected, visited, i, circle);
//            }
//        }
//    }
}

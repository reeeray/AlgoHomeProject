package leetcode.dfs;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 02.07.2023
 **/
public class MaxNumberOfAchivableTransferReq_1601 {

    private static int max;

    public static void main(String[] args) {
        final int[][] input = {{0,1},{1,0},{0,1},{1,2},{2,0},{3,4}};
        assert 5 == maxRequests(5, input);

    }

    public static int maxRequests(final int n, final int[][] requests) {
        max = 0;
        final int[] balance = new int[n];
        dfs(requests, balance, 0, 0);
        return max;
    }

    private static void dfs(final int[][] requstes, final int[] balance, final int index, final int count) {
        if(index == requstes.length) {
            for(int i=0; i<balance.length; i++) {
                if(balance[i] != 0) {
                    return;
                }
            }
            max = Math.max(max, count);
            return;
        }

        balance[requstes[index][0]]--;
        balance[requstes[index][1]]++;
        dfs(requstes, balance, index+1, count+1);
        //backtracking
        balance[requstes[index][0]]++;
        balance[requstes[index][1]]--;
        dfs(requstes, balance, index+1, count);
    }
}

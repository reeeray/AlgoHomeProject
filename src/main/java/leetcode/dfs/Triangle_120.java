package leetcode.dfs;

import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 25.09.2025
 **/
public class Triangle_120 {

    public static void main(String[] args) {

    }
    //botton up approach
    public int minimumTotalOpt(final List<List<Integer>> triangle) {
        for(int row = triangle.size() - 2; row > -1; row--) {
            for(int col = 0; col < triangle.get(row).size(); col++) {
                triangle.get(row).set(col, triangle.get(row).get(col) +
                        Math.min(triangle.get(row + 1).get(col), triangle.get(row + 1).get(col + 1)));
            }
        }
        return triangle.get(0).get(0);
    }
    //TLE
    public int minimumTotal(final List<List<Integer>> triangle) {
        final int[] res = new int[1];
        res[0] = Integer.MAX_VALUE;
        dfs(0, 0, 0, triangle, res);
        return res[0];
    }

    private static void dfs(final int level, final int index, final int currSum, final List<List<Integer>> triangle, final int[] res) {
        if(level == triangle.size()) {
            res[0] = Math.min(currSum, res[0]);
            return;
        }
        dfs(level + 1, index, currSum + triangle.get(level).get(index), triangle, res);
        dfs(level + 1, index + 1, currSum + triangle.get(level).get(index), triangle, res);
    }
}

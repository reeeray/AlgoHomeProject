package leetcode.pureLogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 16.06.2023
 **/
public class NumberOfWaysToReorderArrayToGetSameBST_1569 {

    public static void main(String[] args) {

    }

    private final long MOD = (long)1e9 + 7;
    //For Pascal table since we need to know how to put k elements in n positions C^k_n
    private long[][] table;

    public int numOfWays(int[] nums) {
        final int m = nums.length;

        // Table of Pascal's triangle
        table = new long[m][m];
        for (int i = 0; i < m; ++i) {
            table[i][0] = table[i][i] = 1;
        }
        //it will be much faster to predefine Pascal table in order not to calculate it each time c^k_n = n!/k!(n-k)!
        for (int i = 2; i < m; i++) {
            for (int j = 1; j < i; j++) {
                table[i][j] = (table[i - 1][j - 1] + table[i - 1][j]) % MOD;
            }
        }
        final List<Integer> arrList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return (int)((dfs(arrList) - 1) % MOD);
    }

    private long dfs(List<Integer> nums) {
        int m = nums.size();
        if (m < 3) {
            return 1;
        }

        final List<Integer> leftNodes = new ArrayList<>();
        final List<Integer> rightNodes = new ArrayList<>();
        for (int i = 1; i < m; ++i) {
            if (nums.get(i) < nums.get(0)) {
                leftNodes.add(nums.get(i));
            } else {
                rightNodes.add(nums.get(i));
            }
        }
        long leftWays = dfs(leftNodes) % MOD;
        long rightWays = dfs(rightNodes) % MOD;

        return (((leftWays * rightWays) % MOD) * table[m - 1][leftNodes.size()]) % MOD;
    }
}

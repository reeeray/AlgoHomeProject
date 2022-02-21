package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 21.02.2022
 **/
public class PascalsTriangle_118 {

    public static void main(String[] args) {
        final List<List<Integer>> expected = new ArrayList<>();
        final List<Integer> level1 = new ArrayList<>();
        final List<Integer> level2 = new ArrayList<>();
        final List<Integer> level3 = new ArrayList<>();
        final List<Integer> level4 = new ArrayList<>();
        final List<Integer> level5 = new ArrayList<>();
        level1.add(1);
        level2.add(1);
        level2.add(1);
        level3.add(1);
        level3.add(2);
        level3.add(1);
        level4.add(1);
        level4.add(3);
        level4.add(3);
        level4.add(1);
        level5.add(1);
        level5.add(4);
        level5.add(6);
        level5.add(4);
        level5.add(1);
        expected.add(level1);
        expected.add(level2);
        expected.add(level3);
        expected.add(level4);
        expected.add(level5);

        assert generate(5).equals(expected);
    }

    public static List<List<Integer>> generateEfficiently(int numRows) {
        int[][] pascal = new int[numRows][numRows];
        buildPascal(pascal);
        List<List<Integer>> ans = new ArrayList();
        for (int i = 0; i < numRows; i++) {
            List<Integer> rows = new ArrayList();
            for (int j = 0; j <= i; j++) {
                rows.add(pascal[i][j]);
            }
            ans.add(rows);
        }
        return ans;
    }

    private static void buildPascal(int[][] numRows) {
        for (int i = 0; i < numRows.length; i++) {
            if (i == 0) {
                numRows[0][0] = 1;
            } else if (i == 1) {
                numRows[1][0] = 1;
                numRows[1][1] = 1;
            } else {
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        numRows[i][j] = 1;
                    } else {
                        numRows[i][j] = numRows[i - 1][j - 1] + numRows[i - 1][j];
                    }
                }
            }
        }
    }


    public static List<List<Integer>> generate(int numRows) {
        if (numRows == 0)
            return new ArrayList<>();
        final List<List<Integer>> res = new ArrayList<>();
        final List<Integer> first = new ArrayList<>();
        first.add(1);
        res.add(first);
        if (numRows == 1)
            return res;
        for (int i = 2; i <= numRows; i++) {
            final List<Integer> subRes = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                int left = 0;
                int right = 0;
                if (j - 1 >= 0) {
                    left = res.get(i - 2).get(j - 1);
                }
                if (j <= res.get(i - 2).size() - 1) {
                    right = res.get(i - 2).get(j);
                }
                subRes.add(left + right);
            }
            res.add(subRes);
        }
        return res;
    }
}

package leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 18.08.2025
 **/
public class Game24_679 {

    private final static double TOLERANCE  = 1e-6;

    public static void main(String[] args) {

    }

    public static boolean judgePoint24(final int[] cards) {
        final List<Double> nums = new ArrayList<>();
        for(final int card : cards) {
            nums.add((double) card);
        }
        return dfs(nums);
    }

    private static boolean dfs(final List<Double> nums) {
        if(nums.size() == 1) {
            return Math.abs(24. - nums.get(0)) < TOLERANCE;
        }
        for(int i = 0; i < nums.size(); i ++) {
            for(int j = 0; j < nums.size(); j++) {
                if(i == j) continue;
                final List<Double> next = new ArrayList<>();
                for (int k = 0; k < nums.size(); k++) {
                    if (k != i && k != j) next.add(nums.get(k));
                }
                final List<Double> resultsOfTwo = mathOperationResults(nums.get(i), nums.get(j));
                for(final double val : resultsOfTwo) {
                    next.add(val);
                    if(dfs(next)) return true;
                    next.remove(next.size() - 1);
                }
            }
        }
        return false;
    }

    private static List<Double> mathOperationResults(final double a, final double b) {
        final List<Double> res = new ArrayList<>();
        res.add(a * b);
        res.add(a - b);
        res.add(b - a);
        res.add(a + b);
        if(a > TOLERANCE) {
            res.add(b / a);
        }
        if(b > TOLERANCE) {
            res.add(a / b);
        }
        return res;
    }



}

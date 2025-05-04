package leetcode.pureLogic;

import java.util.HashMap;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 04.05.2025
 **/
public class NumberOfEquivalentDominoPairs_1128 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(1)
    public int numEquivDominoPairsOpt(final int[][] dominoes) {
        final int[] num = new int[100];
        int ret = 0;
        for (final int[] domino : dominoes) {
            int val = domino[0] < domino[1]
                    ? domino[0] * 10 + domino[1]
                    : domino[1] * 10 + domino[0];
            ret += num[val];
            num[val]++;
        }
        return ret;
    }

    public static int numEquivDominoPairs(final int[][] dominos) {
        final Map<String, Integer> freq = new HashMap<>();
        for(final int[] domino : dominos) {
            final int a = domino[0];
            final int b = domino[1];
            final String res = a > b ? "" + b + a : "" + a + b;
            freq.put(res, freq.getOrDefault(res, 0) + 1);
        }
        int res = 0;
        for(int freqency : freq.values()) {
            if(freqency > 1) {
                res += (freqency * (freqency - 1)) / 2;
            }
        }
        return res;
    }
}

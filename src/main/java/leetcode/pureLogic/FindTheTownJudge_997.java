package leetcode.pureLogic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 23.01.2023
 **/
public class FindTheTownJudge_997 {

    public static void main(String[] args) {
        assert 2 == findTownJudgeEfficient(2, new int[][] {{1, 2}});
    }

    private static int findTownJudge(final int n, final int[][] trust) {
        final Map<Integer, Integer> count = new HashMap<>();
        final Set<Integer> trusts = new HashSet<>();
        for(int[] t : trust) {
            trusts.add(t[0]);
            count.put(t[1], count.getOrDefault(t[1], 0) + 1);
        }

        int answ = -1;
        int c = 0;
        for(final Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if(entry.getValue() > c) {
                answ = entry.getKey();
                c = entry.getValue();
            }
        }
        return c == n - 1 && trusts.add(answ) ? answ : -1;
    }

    private static int findTownJudgeEfficient(final int n, final int[][] trust) {
        final int[] count = new int[n+1];
        for(int[] t : trust) {
            count[t[0]]--;
            count[t[1]]++;
        }

        for(int i=0; i<n+1; i++) {
            if(count[i] == n-1) return i;
        }
        return -1;
    }
}

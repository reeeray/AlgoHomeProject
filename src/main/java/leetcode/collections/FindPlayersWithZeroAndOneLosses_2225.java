package leetcode.collections;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 15.01.2024
 **/
public class FindPlayersWithZeroAndOneLosses_2225 {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> findWinners(final int[][] matches) {
        final Set<Integer> winners = new HashSet<>();
        final Map<Integer, Integer> loosers = new HashMap<>();
        final List<Integer> zero = new ArrayList<>();
        final List<Integer> one = new ArrayList<>();
        for(int[] match : matches) {
            winners.add(match[0]);
            loosers.put(match[1], loosers.getOrDefault(match[1], 0) + 1);
        }

        for(int player : loosers.keySet()) {
            if(loosers.get(player) == 1) {
                one.add(player);
            }

            if(winners.contains(player)) {
                winners.remove(player);
            }
        }

        zero.addAll(winners);
        Collections.sort(zero);
        Collections.sort(one);
        final List<List<Integer>> ans = new ArrayList<>();
        ans.add(zero);
        ans.add(one);
        return ans;
    }
}

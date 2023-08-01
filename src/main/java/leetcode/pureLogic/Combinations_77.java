package leetcode.pureLogic;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 01.08.2023
 **/
public class Combinations_77 {

    public static void main(String[] args) {
        final List<List<Integer>> param = combine(4, 2);
        int i = 0;
    }

    public static List<List<Integer>> combine(final int n, final int k) {
        final List<List<Integer>> answer = new ArrayList<>();
        backTrack(answer, new ArrayList<>(),1, k, n);
        return answer;
    }

    private static void backTrack(final List<List<Integer>> result, final List<Integer> curr, final int index, final int level, final int end) {
        if(level == 0 || index > end) {
            result.add(curr);
            return;
        }
        for(int i=index; i<=end - level + 1; i++) {
            curr.add(i);
            backTrack(result, new ArrayList<>(curr), i+1, level-1, end);
            curr.remove(curr.size()-1);
        }
    }
}

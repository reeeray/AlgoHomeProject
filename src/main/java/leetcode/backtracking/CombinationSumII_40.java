package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 13.08.2024
 **/
public class CombinationSumII_40 {

    public static void main(String[] args) {

    }

    //Space O(n) and Time O(2^n)
    public static List<List<Integer>> combinationSum2(final int[] candidates, final int target) {
        final List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(answer, new ArrayList<>(), candidates, target, 0);
        return answer;
    }

    private static void backTrack(final List<List<Integer>> answer, final List<Integer> current, final int[] candidates, final int target, final int index) {
        if(target < 0) {
            return;
        } else if(target == 0) {
            answer.add(new ArrayList<>(current));
            return;
        } else {
            for(int i=index; i<candidates.length && candidates[i] <= target; i++) {
                if(i > index && candidates[i] == candidates[i - 1]) continue;
                current.add(candidates[i]);
                backTrack(answer, current, candidates,target - candidates[i], i + 1);
                //backTrack
                current.remove(current.size() - 1);
            }
        }
    }
}

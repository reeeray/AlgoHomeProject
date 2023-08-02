package leetcode.pureLogic;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 02.08.2023
 **/
public class Permutations_46 {

    public static void main(String[] args) {
        final List<List<Integer>> answ = permute(new int[] {1, 2, 3});
        int i = 0;
    }

    public static List<List<Integer>> permute(final int[] nums) {
        final List<List<Integer>> answer = new ArrayList<>();
        backTrack(answer, new ArrayList<>(), nums);
        return answer;
    }

    private static void backTrack(final List<List<Integer>> permutations, final List<Integer> perm, final int[] nums) {
        if(perm.size() == nums.length) {
            permutations.add(perm);
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(!perm.contains(nums[i])) {
                perm.add(nums[i]);
                backTrack(permutations, new ArrayList<>(perm), nums);
                perm.remove(perm.size()-1);
            }
        }
    }
}

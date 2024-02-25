package leetcode.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 25.02.2024
 **/
public class GreatestCommonDivisorTraversal_2709 {

    final Map<Integer, List<Integer>> prime2index = new HashMap<>();
    final Map<Integer, List<Integer>> index2prime = new HashMap<>();

    public static void main(String[] args) {

    }

    public boolean canTraverseAllPairs(final int[] nums) {
        if(nums.length < 2) {
            return true;
        }
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 1) {
                return false;
            }
            int temp = nums[i];
            for(int j=2; j*j < nums[i]; j++) {
                if(temp % j == 0) {
                    prime2index.computeIfAbsent(j, v -> new ArrayList<>()).add(i);
                    index2prime.computeIfAbsent(i, v -> new ArrayList<>()).add(j);
                    while(temp % j == 0) {
                        temp /= j;
                    }
                }
            }
            if(temp > 1) {
                prime2index.computeIfAbsent(temp, v -> new ArrayList<>()).add(i);
                index2prime.computeIfAbsent(i, v -> new ArrayList<>()).add(temp);
            }
        }
        final boolean[] visitedIndex = new boolean[nums.length];
        final Map<Integer, Boolean> visitedPrime = new HashMap<>();
        dfs(0, visitedIndex, visitedPrime);
        for(boolean visited : visitedIndex) {
            if(!visited) {
                return false;
            }
        }
        return true;
    }

    private void dfs(final int index, final boolean[] visitedIndex, final Map<Integer, Boolean> visitedPrime) {
        if(visitedIndex[index]) {
            return;
        }
        visitedIndex[index] = true;
        for(int prime : index2prime.get(index)) {
            if(visitedPrime.getOrDefault(prime, false)) {
                continue;
            }
            visitedPrime.put(prime, true);
            for(int idx : prime2index.get(prime)) {
                dfs(idx, visitedIndex, visitedPrime);
            }
        }
    }
}

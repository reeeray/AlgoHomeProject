package leetcode.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 17.04.2025
 **/
public class CountEqualAndDevisiblePairsInAnArray_2176 {

    public static void main(String[] args) {

    }

    //Time O(2n) and Space O(n)
    public static int countPairs(final int[] nums, final int k) {
        final Map<Integer, List<Integer>> valToIndex = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            valToIndex.putIfAbsent(nums[i], new ArrayList<>());
            valToIndex.get(nums[i]).add(i);
        }
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            valToIndex.get(nums[i]).remove((Integer)i);
            if(!valToIndex.get(nums[i]).isEmpty()) {
                for(final int j : valToIndex.get(nums[i])) {
                    if(i * j % k == 0) {
                        res +=1;
                    }
                }
            }
        }
        return res;
    }

    //Time O(n^2) and Space O(1)
    public int countPairsNonOpt(int[] nums, int k) {
        int n = nums.length;
        int res = 0; // number of pairs meeting the requirements
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if ((i * j) % k == 0 && nums[i] == nums[j]) {
                    ++res;
                }
            }
        }
        return res;
    }
}

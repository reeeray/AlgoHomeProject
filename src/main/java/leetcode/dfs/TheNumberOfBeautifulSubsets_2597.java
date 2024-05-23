package leetcode.dfs;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 23.05.2024
 **/
public class TheNumberOfBeautifulSubsets_2597 {

    private static int counter = 0;

    public static void main(String[] args) {
        beautifulSubsets(new int[] {2, 4, 6}, 1);
    }

    //don't work with duplicates or TLE
    public static int beautifulSubsets(final int[] nums, final int k) {
        counter = 0;
        System.out.println(Arrays.toString(nums).equals("[2, 4, 6]"));
        //to avoid duplicates
        dfs(nums, 0, new HashSet<>(), new HashSet<>(), k);
        return counter;
    }

    private static void dfs(final int[] nums, final int index, final Set<String> unique, final Set<Integer> backtracking, final int k) {
        if(index >= nums.length) {
            return;
        }

        for(int i=index; i<nums.length; i++) {
            final int val = nums[i];
            if(!backtracking.contains(Math.abs(val - k)) && !backtracking.contains(Math.abs(val + k))) {
                backtracking.add(val);
                final String repr = backtracking.toString();
                if(unique.add(repr)) {
                    counter++;
                }
                dfs(nums, i + 1, unique, backtracking, k);
                System.out.println(backtracking);
                backtracking.remove(val);
            }
        }
    }

    public int beautifulSubsetsWork(int[] nums, int k) {
        final Map<Integer, Integer> map = new HashMap<>();
        return dfs(nums, 0, k, map) - 1;
    }

    public int dfs(final int[] nums, final int idx, final int k, final Map<Integer, Integer> mp) {
        if (idx == nums.length) return 1;

        int taken = 0;
        if (!mp.containsKey(nums[idx] - k) && !mp.containsKey(nums[idx] + k)) {
            mp.put(nums[idx], mp.getOrDefault(nums[idx], 0) + 1);
            taken = dfs(nums, idx + 1, k, mp);
            mp.put(nums[idx], mp.get(nums[idx]) - 1);
            if (mp.get(nums[idx]) == 0) {
                mp.remove(nums[idx]);
            }
        }

        int notTaken = dfs(nums, idx + 1, k, mp);

        return taken + notTaken;
    }
}

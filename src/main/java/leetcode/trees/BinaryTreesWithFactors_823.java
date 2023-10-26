package leetcode.trees;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.10.2023
 **/
public class BinaryTreesWithFactors_823 {

    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        final int[] input = {45,42,2,18,23,1170,12,41,40,9,47,24,33,28,10,32,29,17,46,11,759,37,6,26,21,49,31,14,19,8,13,7,27,22,3,36,34,38,39,30,43,15,4,16,35,25,20,44,5,48};
        System.out.println(numFactoredBinaryTrees(input));
    }

    public static int numFactoredBinaryTrees(final int[] arr) {
        Arrays.sort(arr);
        final Set<Integer> unique = new HashSet<>();
        final Map<Integer, Integer> dp = new HashMap<>();
        for(int n : arr) {
            unique.add(n);
            dp.put(n, 1);
        }

        for(int parent : arr) {
            for(int child : arr) {
                if(child > Math.sqrt(parent)) break;
                final int product = parent / child;
                if(parent % child == 0 && unique.contains(product)) {
                   long temp = (long) dp.get(child) * dp.get(product);
                   dp.put(parent, (int)((dp.get(parent) + (product == child ? temp : 2*temp))%MOD));
                }
            }
        }

        int res = 0;
        for(int val : dp.values()) {
            res = (res + val)%MOD;
        }
        return res;
    }
}

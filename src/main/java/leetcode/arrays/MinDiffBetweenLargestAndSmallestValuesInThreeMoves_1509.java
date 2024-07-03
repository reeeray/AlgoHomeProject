package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 03.07.2024
 **/
public class MinDiffBetweenLargestAndSmallestValuesInThreeMoves_1509 {

    public static void main(String[] args) {

    }

    //Space efficient because it's O(1) but not in terms of time O(n)
    public static int minDiff(final int[] nums) {
         if(nums.length <= 4) {
             return 0;
         }

         final List<Integer> min = new ArrayList<>();
         final List<Integer> max = new ArrayList<>();
         for(int num : nums) {
             min.add(num);
             max.add(num);
             if(min.size() > 4) {
                 Collections.sort(min, Collections.reverseOrder());
                 min.remove(0);
                 Collections.sort(max);
                 max.remove(0);
             }
         }
         Collections.sort(min);
         int diff = Integer.MAX_VALUE;
         for(int i=0; i<4; i++) {
             diff = Math.min(diff, max.get(i) - min.get(i));
         }
         return diff;
    }

    //weird, it's O(nlogn) because of sort
    public int minDifferenceEff(final int[] A) {
        int n = A.length, res = Integer.MAX_VALUE;
        if (n < 5) return 0;
        Arrays.sort(A);
        for (int i = 0; i < 4; ++i) {
            res = Math.min(res, A[n - 4 + i] - A[i]);
        }
        return res;
    }
}

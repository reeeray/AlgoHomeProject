package leetcode.bruteforce;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 22.01.2026
 **/
public class MinimumPairRemovalToSortArrayI_3507 {

    public static void main(String[] args) {
        minimumPairRemoval(new int[] {5, 2, 3, 1});
    }

    public static int minimumPairRemoval(final int[] nums) {
        final List<Integer> numsArr = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int res = 0;
        while (numsArr.size() > 1) {
            int minVal = Integer.MAX_VALUE;
            int index = -1;
            boolean sorted = true;
            for(int i = 0; i < numsArr.size() - 1; i++) {
                var sum = numsArr.get(i) + numsArr.get(i + 1);
                if(sum < minVal) {
                    minVal = sum;
                    index = i;
                }
                if(numsArr.get(i) > numsArr.get(i + 1)) sorted = false;
            }
            if(sorted) return res;
            numsArr.set(index, minVal);
            numsArr.remove(index + 1);
            res++;
        }
        return res;
    }
}

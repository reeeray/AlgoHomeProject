package leetcode.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 24.11.2023
 **/
public class ArithmeticSubArrays_1630 {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        final List<Boolean> ans = new ArrayList();
        for (int i = 0; i < l.length; i++) {
            int[] arr = new int[r[i] - l[i] + 1];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = nums[l[i] + j];
            }

            ans.add(check(arr));
        }

        return ans;
    }

    public Boolean check(int[] arr) {
        int minElement = Integer.MAX_VALUE;
        int maxElement = Integer.MIN_VALUE;
        final Set<Integer> arrSet = new HashSet();

        for (int num : arr) {
            minElement = Math.min(minElement, num);
            maxElement = Math.max(maxElement, num);
            arrSet.add(num);
        }

        if ((maxElement - minElement) % (arr.length - 1) != 0) {
            return false;
        }

        int diff = (maxElement - minElement) / (arr.length - 1);
        int curr = minElement + diff;

        while (curr < maxElement) {
            if (!arrSet.contains(curr)) {
                return false;
            }

            curr += diff;
        }

        return true;
    }
}

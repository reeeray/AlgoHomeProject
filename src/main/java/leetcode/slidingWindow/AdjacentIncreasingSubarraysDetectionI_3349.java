package leetcode.slidingWindow;

import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 14.10.2025
 **/
public class AdjacentIncreasingSubarraysDetectionI_3349 {

    public static void main(String[] args) {
        hasIncreasingSubarrays(List.of(1,2,3,4,4,4,4,5,6,7), 5);
    }

    public static boolean hasIncreasingSubarrays(final List<Integer> nums, final int k) {
        int index = 0;
        final int len = nums.size();
        final int lastIndex = len - 2*k;
        while(index <= lastIndex) {
            boolean flag = false;
            for(int i = 1; i < k; i++) {
                if (nums.get(index + k + i) <= nums.get(index + k + i - 1)) {
                    index = index + i;
                    flag = true;
                    break;
                }
            }
            if(flag) {
                continue;
            }
            for(int i = 1; i < k; i++) {
                if (nums.get(index + i) <= nums.get(index + i - 1)) {
                    index = index + i;
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                return true;
            }
        }
        return false;
    }
}

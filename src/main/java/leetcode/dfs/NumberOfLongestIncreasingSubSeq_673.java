package leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 21.07.2023
 **/
public class NumberOfLongestIncreasingSubSeq_673 {

    public static void main(String[] args) {
        final int[] input = {1,3,5,4,7};
        findNumberOfLIS(input);
    }

    public int findNumberOfLISDP(final int[] nums) {
        final int n = nums.length;
        final int[] length = new int[n];
        final int[] count = new int[n];

        Arrays.fill(length, 1);
        Arrays.fill(count, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (length[j] + 1 > length[i]) {
                        length[i] = length[j] + 1;
                        count[i] = 0;
                    }
                    if (length[j] + 1 == length[i]) {
                        count[i] += count[j];
                    }
                }
            }
        }

        int maxLength = 0;
        int result = 0;

        for (int len : length) {
            maxLength = Math.max(maxLength, len);
        }

        for (int i = 0; i < n; i++) {
            if (length[i] == maxLength) {
                result += count[i];
            }
        }

        return result;
    }

    //TLE
    public static int findNumberOfLIS(final int[] nums) {
        final List<Integer> seq = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            dfs(nums,i, 1, seq);
        }

        Collections.sort(seq, Collections.reverseOrder());
        int num = seq.get(0);
        int res = 1;
        for(int i=1; i<seq.size(); i++) {
            if(num == seq.get(i)) {
                res++;
            } else {
                break;
            }
        }
        return res;
    }

    private static void dfs(final int[] nums, final int index, final int seq, final List<Integer> len) {
        boolean flag = true;
        for(int i=index+1; i<nums.length; i++) {
            if(nums[i] > nums[index]) {
                flag = false;
                dfs(nums, i, seq + 1, len);
            }
        }
        if(flag) {
            len.add(seq);
        }
    }
}

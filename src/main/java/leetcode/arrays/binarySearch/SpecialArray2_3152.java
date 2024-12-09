package leetcode.arrays.binarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 09.12.2024
 **/
public class SpecialArray2_3152 {

    public static void main(String[] args) {
        isArraySpecial(new int[] {4, 3, 1, 6}, new int[][] {{0, 2}, {2, 3}});
    }

    //Space O(n) and Time O(mlogn + n) because intially we iterate over n nums and then over m queries and for each we use binary search which is logm
    public static boolean[] isArraySpecial(final int[] nums, final int[][] queries) {
        final boolean[] answer = new boolean[queries.length];
        final List<Integer> violations = new ArrayList<>();
        for(int i=1; i<nums.length; i++) {
            if(nums[i - 1] % 2 == nums[i] % 2) {
                violations.add(i);
            }
        }
        for(int i=0; i<queries.length; i++) {
            answer[i] = !queryContainViolations(violations, queries[i][0] + 1, queries[i][1]);
        }
        return answer;
    }

    private static boolean queryContainViolations(final List<Integer> violations, final int start, final int end) {
        int left = 0;
        int right = violations.size() - 1;
        while (left <= right) {
            final int mid = (left + right) / 2;
            if(violations.get(mid) < start) {
                left = mid + 1;
            } else if (violations.get(mid) > end) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    //Space O(n) and Time O(n + m)
    public static boolean[] isArraySpecialOpt(final int[] nums, final int[][] queries) {
        final boolean[] ans = new boolean[queries.length];
        final int[] prefix = new int[nums.length];
        prefix[0] = 0;
        for(int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + (nums[i - 1] % 2 == nums[i] % 2 ? 1 : 0);
        }
        for(int i=0; i<queries.length; i++) {
            ans[i] = prefix[queries[i][1]] - prefix[queries[i][0]] == 0;
        }
        return ans;
    }

}

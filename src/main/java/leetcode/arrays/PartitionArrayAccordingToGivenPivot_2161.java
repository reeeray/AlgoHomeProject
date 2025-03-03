package leetcode.arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 03.03.2025
 **/
public class PartitionArrayAccordingToGivenPivot_2161 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(n)
    public static int[] pivotArray(final int[] nums, final int pivot) {
        final Queue<Integer> less = new LinkedList<>();
        final Queue<Integer> more = new LinkedList<>();
        for (final int num : nums) {
            if(num < pivot) {
                less.add(num);
            } else if (num > pivot) {
                more.add(num);
            }
        }
        final int idxEq = less.size();
        final int idxMore = nums.length - more.size();
        for(int i = 0; i < nums.length; i++) {
            if(i < idxEq) {
                nums[i] = less.poll();
            } else if (i >= idxEq && i < idxMore) {
                nums[i] = pivot;
            } else {
                nums[i] = more.poll();
            }
        }
        return nums;
    }

    //Two passes : Time O(n) and Space O(1) ? debatable
    public int[] pivotArrayOptimized(final int[] nums, final int pivot) {
        int less = 0;
        int equal = 0;
        for (int num : nums) {
            if (num < pivot) less++;
            else if (num == pivot) equal++;
        }

        final int[] ans = new int[nums.length];
        int lessI = 0;
        int equalI = less;
        int greaterI = less + equal;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num < pivot) {
                ans[lessI] = num;
                lessI++;
            } else if (num > pivot) {
                ans[greaterI] = num;
                greaterI++;
            } else {
                ans[equalI] = num;
                equalI++;
            }
        }
        return ans;
    }

    //Two pointer : Time O(n) and Space better but still O(n)
    public int[] pivotArrayComparable(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        int lessI = 0;
        int greaterI = nums.length - 1;
        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            if (nums[i] < pivot) {
                ans[lessI] = nums[i];
                lessI++;
            }
            if (nums[j] > pivot) {
                ans[greaterI] = nums[j];
                greaterI--;
            }
        }
        while (lessI <= greaterI) {
            ans[lessI] = pivot;
            lessI++;
        }
        return ans;
    }
}

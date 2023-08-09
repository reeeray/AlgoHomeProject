package leetcode.pureLogic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 09.08.2023
 **/
public class MinimizeTheMaxDiffOfPairs_2616 {

    public static void main(String[] args) {
        final int[] input = new int[]{8,9,1,5,4,3,6,4,3,7};
        System.out.println(minimizeMax(input, 2));
    }

    public static int minimizeMax(final int[] nums, final int p) {
//        final Set<Integer> distinct = new HashSet<>();
//        int numOfPairs = 0;
//        for(int n : nums) {
//            if(!distinct.add(n)) {
//                numOfPairs++;
//                distinct.remove(n);
//            }
//        }
//        final Integer[] arr = new Integer[distinct.size()];
//        distinct.toArray(arr);
//        Arrays.sort(arr);
//        int max = 0;
//        for(int i=0; i<p-numOfPairs; i++) {
//            final int index = i*2;
//            final int diff = Math.abs(arr[index] - arr[index+1]);
//            max = Math.max(max, diff);
//        }
//
//        return max;
//        final int[] dp = new int[nums.length-1];
//        Arrays.sort(nums);
//        for(int i=0; i<nums.length-1; i++) {
//            dp[i] = Math.abs(nums[i] - nums[i+1]);
//        }
//        return -1;
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length-1] - nums[0];
        while(left < right) {
            final int mid = (left + right) / 2;
            if(countPairs(nums, mid) >= p) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int countPairs(final int[] nums, final int threshold) {
        int pairs = 0;
        int index = 0;
        while (index < nums.length-1) {
            if(nums[index+1] - nums[index] <= threshold) {
                pairs++;
                index++;
            }
            index++;
        }
        return pairs;
    }
}

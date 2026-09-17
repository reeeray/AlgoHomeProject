package leetcode.slidingWindow;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 17.09.2026
 **/
public class FindTwoNonOverlappingSubArraysEachWithTargetSum_1477 {

    public static void main(String[] args) {
        minSumOfLengths(new int[]{3, 2, 2, 4, 3}, 3);

    }

    public static int minSumOfLengths(final int[] arr, final int target) {
        final int[] dp = new int[arr.length + 1];
        int res = arr.length + 1, currentSum = 0;
        Arrays.fill(dp, arr.length);
        for(int left = 0, right = 0; right < arr.length; right++) {
            currentSum += arr[right];
            while(currentSum > target) currentSum-=arr[left++];
            dp[right + 1] = dp[right];
            if(currentSum == target) {
                res = Math.min(res, right - left + 1 + dp[left]);
                dp[right + 1] = Math.min(dp[right], right - left + 1);
            }
        }
        return res == arr.length + 1 ? -1 : res;
        //        final int[] minLen = new int[arr.length];
//        int countOfSubArrs = 0, currSum = 0, currLen = 0, prevIndex = 0;
//        for(int i = 0; i < arr.length; i++) {
//            currSum += arr[i];
//            currLen++;
//            if(arr[i] == target) {
//                countOfSubArrs++;
//                minLen[i] = 1;
//                currLen = 0;
//                currSum = 0;
//                continue;
//            }
//            if(currSum == target) {
//                countOfSubArrs++;
//                minLen[i] = Math.min(currLen, i > 0  ? minLen[i - 1] : Integer.MAX_VALUE);
//                currLen--;
//                currSum -= arr[prevIndex++];
//            } else if(currSum < target) {
//                minLen[i] = i > 0 ? minLen[i - 1] : Integer.MAX_VALUE;
//                continue;
//            } else {
//                minLen[i] = i > 0 ? minLen[i - 1] : Integer.MAX_VALUE;
//                currLen--;
//                currSum -= arr[prevIndex++];
//            }
//        }
//        if(countOfSubArrs < 2) return -1;
//        int res = Integer.MAX_VALUE;
//        currSum = 0;
//        currLen = 0;
//        prevIndex = arr.length - 1;
//        for(int i = arr.length - 1; i > 0; i--) {
//            currSum += arr[i];
//            currLen++;
//            if(currSum == target) {
//                res = Math.min(minLen[i-1], currLen);
//                currLen--;
//                currSum -= arr[prevIndex--];
//            } else if(currSum > target) {
//                currLen--;
//                currSum -= arr[prevIndex--];
//            }
//        }
//        return res;
    }
}

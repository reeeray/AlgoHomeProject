package leetcode.dp;

import java.util.Arrays;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 28.12.2024
 **/
public class MaxSumOf3NonOverlappingSubArrays_689 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSumOfThreeSubarrays(new int[] {1, 2, 1, 2, 6, 7, 5, 1}, 2)));
    }

    //Time O(n*m) and Space O(n*m)
    public static int[] maxSumOfThreeSubarrays(final int[] nums, final int k) {
        final int[] ans = new int[3];
        if(nums.length < k * 3) {
            return ans;
        }
        final int[][] fromRightToLeft = new int[nums.length][3];
        int maxRight = Integer.MIN_VALUE;
        int rightIndex = 0;
        for(int i=nums.length - 2*k; i >= k; i--) {
            int rightSum = 0, midSum = 0;
            for(int j=0; j<k;j++) {
                rightSum += nums[i + j + k];
                midSum += nums[i + j];
            }
            if(maxRight <= rightSum) {
                maxRight = rightSum;
                rightIndex = i + k;
            }
            fromRightToLeft[i][0] = midSum + maxRight;
            fromRightToLeft[i][1] = i;
            fromRightToLeft[i][2] = rightIndex;
        }
        int maxSum = 0;
        int maxLeft = Integer.MIN_VALUE;
        int leftIndex = 0;
        for(int i=0; i<nums.length - 2*k; i++) {
            int leftSum = 0;
            for(int j=0; j<k; j++) {
                leftSum += nums[i + j];
            }
            if(leftSum > maxLeft) {
                maxLeft = leftSum;
                leftIndex = i;
            }
            final int currSum = maxLeft + fromRightToLeft[i + k][0];
            if(currSum > maxSum) {
                maxSum = currSum;
                ans[0] = leftIndex;
                ans[1] = fromRightToLeft[i + k][1];
                ans[2] = fromRightToLeft[i + k][2];
            }
        }
        return ans;

    }

    //O(n) and O(n)
    public int[] maxSumOfThreeSubarraysThreePointers(int[] nums, int k) {
        int n = nums.length;
        int maxSum = 0;

        // Prefix sum array to calculate sum of any subarray
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        // Arrays to store the best starting index for the left and right subarrays
        int[] leftMaxIndex = new int[n];
        int[] rightMaxIndex = new int[n];

        // Result array to store the starting indices of the three subarrays
        int[] result = new int[3];

        // Calculate the best starting index for the left subarray for each position
        for (
                int i = k, currentMaxSum = prefixSum[k] - prefixSum[0];
                i < n;
                i++
        ) {
            if (prefixSum[i + 1] - prefixSum[i + 1 - k] > currentMaxSum) {
                leftMaxIndex[i] = i + 1 - k;
                currentMaxSum = prefixSum[i + 1] - prefixSum[i + 1 - k];
            } else {
                leftMaxIndex[i] = leftMaxIndex[i - 1];
            }
        }

        // Calculate the best starting index for the right subarray for each position
        rightMaxIndex[n - k] = n - k;
        for (
                int i = n - k - 1, currentMaxSum = prefixSum[n] - prefixSum[n - k];
                i >= 0;
                i--
        ) {
            if (prefixSum[i + k] - prefixSum[i] >= currentMaxSum) {
                rightMaxIndex[i] = i;
                currentMaxSum = prefixSum[i + k] - prefixSum[i];
            } else {
                rightMaxIndex[i] = rightMaxIndex[i + 1];
            }
        }

        // Iterate over the middle subarray and calculate the total sum for all valid combinations
        for (int i = k; i <= n - 2 * k; i++) {
            int leftIndex = leftMaxIndex[i - 1];
            int rightIndex = rightMaxIndex[i + k];
            int totalSum =
                    (prefixSum[i + k] - prefixSum[i]) +
                            (prefixSum[leftIndex + k] - prefixSum[leftIndex]) +
                            (prefixSum[rightIndex + k] - prefixSum[rightIndex]);

            if (totalSum > maxSum) {
                maxSum = totalSum;
                result[0] = leftIndex;
                result[1] = i;
                result[2] = rightIndex;
            }
        }

        return result;
    }


    //Time O(n + k) and Space O(1)
    public int[] maxSumOfThreeSubarraysSlidingWindow(int[] nums, int k) {
        // Variables to track the best indices for one, two, and three subarray configurations
        int bestSingleStart = 0;
        int[] bestDoubleStart = { 0, k };
        int[] bestTripleStart = { 0, k, k * 2 };

        // Compute the initial sums for the first three subarrays
        int currentWindowSumSingle = 0;
        for (int i = 0; i < k; i++) {
            currentWindowSumSingle += nums[i];
        }

        int currentWindowSumDouble = 0;
        for (int i = k; i < k * 2; i++) {
            currentWindowSumDouble += nums[i];
        }

        int currentWindowSumTriple = 0;
        for (int i = k * 2; i < k * 3; i++) {
            currentWindowSumTriple += nums[i];
        }

        // Track the best sums found so far
        int bestSingleSum = currentWindowSumSingle;
        int bestDoubleSum = currentWindowSumSingle + currentWindowSumDouble;
        int bestTripleSum =
                currentWindowSumSingle +
                        currentWindowSumDouble +
                        currentWindowSumTriple;

        // Sliding window pointers for the subarrays
        int singleStartIndex = 1;
        int doubleStartIndex = k + 1;
        int tripleStartIndex = k * 2 + 1;

        // Slide the windows across the array
        while (tripleStartIndex <= nums.length - k) {
            // Update the sums using the sliding window technique
            currentWindowSumSingle =
                    currentWindowSumSingle -
                            nums[singleStartIndex - 1] +
                            nums[singleStartIndex + k - 1];
            currentWindowSumDouble =
                    currentWindowSumDouble -
                            nums[doubleStartIndex - 1] +
                            nums[doubleStartIndex + k - 1];
            currentWindowSumTriple =
                    currentWindowSumTriple -
                            nums[tripleStartIndex - 1] +
                            nums[tripleStartIndex + k - 1];

            // Update the best single subarray start index if a better sum is found
            if (currentWindowSumSingle > bestSingleSum) {
                bestSingleStart = singleStartIndex;
                bestSingleSum = currentWindowSumSingle;
            }

            // Update the best double subarray start indices if a better sum is found
            if (currentWindowSumDouble + bestSingleSum > bestDoubleSum) {
                bestDoubleStart[0] = bestSingleStart;
                bestDoubleStart[1] = doubleStartIndex;
                bestDoubleSum = currentWindowSumDouble + bestSingleSum;
            }

            // Update the best triple subarray start indices if a better sum is found
            if (currentWindowSumTriple + bestDoubleSum > bestTripleSum) {
                bestTripleStart[0] = bestDoubleStart[0];
                bestTripleStart[1] = bestDoubleStart[1];
                bestTripleStart[2] = tripleStartIndex;
                bestTripleSum = currentWindowSumTriple + bestDoubleSum;
            }

            // Move the sliding windows forward
            singleStartIndex += 1;
            doubleStartIndex += 1;
            tripleStartIndex += 1;
        }

        // Return the starting indices of the three subarrays with the maximum sum
        return bestTripleStart;
    }

}

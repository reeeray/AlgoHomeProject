package leetcode.slidingWindow;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 22.06.2024
 **/
public class CountNumberOfNiceSubarrays_1248 {

    public static void main(String[] args) {
        System.out.println(numberOfSubarrays(new int[] {1, 1, 1, 1, 1}, 1));
    }

    //Space O(n) and Time O(n)
    public static int numberOfSubarraysHashing(final int[] nums, final int k) {
        int currSum = 0, subarrays = 0;
        final Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(currSum, 1);

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i] % 2;
            // Find subarrays with sum k ending at i
            if (prefixSum.containsKey(currSum - k)) {
                subarrays = subarrays + prefixSum.get(currSum - k);
            }
            // Increment the current prefix sum in hashmap
            prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);
        }

        return subarrays;
    }

    //Space O(n) and Time O(n)
    public static int numberOfSubarraysSlidingWindowQueue(final int[] nums, final int k) {
        final Queue<Integer> oddIndices = new LinkedList<>();
        int subarrays = 0;
        int lastPopped = -1;
        int initialGap = -1;

        for (int i = 0; i < nums.length; i++) {
            // If element is odd, append its index to the list.
            if (nums[i] % 2 == 1) {
                oddIndices.offer(i);
            }
            // If the number of odd numbers exceeds k, remove the first odd index.
            if (oddIndices.size() > k) {
                lastPopped = oddIndices.poll();
            }
            // If there are exactly k odd numbers, add the number of even numbers
            // in the beginning of the subarray to the result.
            if (oddIndices.size() == k) {
                initialGap = oddIndices.element() - lastPopped;
                subarrays += initialGap;
            }
        }

        return subarrays;
    }

    //Space O(1) and Time O(n)
    public int numberOfSubarraysSlidingWindowQueueOpt(int[] nums, int k) {
        int subarrays = 0, initialGap = 0, qsize = 0, start = 0;
        for (int end = 0; end < nums.length; end++) {
            // If current element is odd, increment qsize by 1.
            if (nums[end] % 2 == 1) {
                qsize++;
            }
            // If qsize is k, calculate initialGap and add it in the answer.
            if (qsize == k) {
                initialGap = 0;
                // Calculate the number of even elements in the beginning of
                // subarray.
                while (qsize == k) {
                    qsize -= nums[start] % 2;
                    initialGap++;
                    start++;
                }
            }
            subarrays += initialGap;
        }
        return subarrays;
    }

    //Time O(n) and Space O(1)
    public int numberOfSubarraysViaSubArrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int windowSize = 0, subarrays = 0, start = 0;

        for (int end = 0; end < nums.length; end++) {
            windowSize += nums[end] % 2;
            // Find the first index start where the window has exactly k odd elements.
            while (windowSize > k) {
                windowSize -= nums[start] % 2;
                start++;
            }
            // Increment number of subarrays with end - start + 1.
            subarrays += end - start + 1;
        }

        return subarrays;
    }

    public static int numberOfSubarrays(final int[] nums, final int k) {
        int leftIndex = 0;
        int rightIndex = 0;
        int leftW = -1;
        int rightW = -1;
        int window = 0;
        int count = 0;
        while (rightIndex <= nums.length) {
            if(rightIndex == nums.length || nums[rightIndex] % 2 == 1) {
                window++;
                if(leftW > -1 && nums[leftW] % 2 == 1) {
                    if(rightW > - 1 && nums[rightW] % 2 == 1){
                        count += (leftW - leftIndex + 1) * (rightIndex - rightW);
                        leftIndex = leftW + 1;
                        rightW = rightIndex;
                        window--;
                        while(++leftW < nums.length && nums[leftW] % 2 != 1) {

                        }
                    } else if (window == k){
                        rightW = rightIndex;
                    }
                } else {
                    leftW = rightIndex;
                    if(window == k) {
                        rightW = rightIndex;
                    }
                }
            }
            rightIndex++;
        }
        return count;
    }


    public static int numberOfSubarraysWrongRequirement(final int[] nums, final int k) {
        int numOdd = 0;
        for(int i=0; i<k; i++) {
            if(nums[i] % 2 == 1) {
                numOdd++;
            }
        }
        int ans = numOdd % 2 == 1 ? 1 : 0;
        for(int i=0; i<=nums.length - k; i++) {
            if(nums[i] % 2 == 1) {
                numOdd--;
            }
            if(nums[i + k] % 2 == 1) {
                numOdd++;
            }
            if(numOdd % 2 == 1) {
                ans++;
            }
        }
        return ans;
    }

}

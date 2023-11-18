package leetcode.pureLogic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 18.11.2023
 **/
public class FreqOfTheMostFrequentElement_1838 {

    public static void main(String[] args) {
        final int[] input = new int[] {9940,9995,9944,9937,9941,9952,9907,9952,9987,9964,9940,9914,9941,9933,9912,9934,9980,9907,9980,9944,9910,9997};
        System.out.println(maxFrequencyMedian(input, 7925));
    }

    public static int maxFrequencyMedian(final int[] nums, int k) {
        final int n = nums.length;
        final int sum = Arrays.stream(nums).sum();
        final int median = (sum + k) / n;
        int index = 0;
        Arrays.sort(nums);
        if(median >= nums[n-1]) {
            return n;
        }
        for(int i=0; i<n; i++) {
            if (nums[i] == median || (i < n-1 && nums[i + 1] > median)) {
                index = i;
                break;
            }
        }
        int count = 1;

        while (index > 0 && nums[index] - nums[index-1] <= k) {
            count++;
            k -= nums[index] - nums[index-1];
            index--;
        }
        return count;
    }

    public static int maxFrequencyWindow(final int[] nums, final int k) {
        final int n = nums.length;
        Arrays.sort(nums);
        int left = 0;
        int total = 0;
        long curr = 0;

        for(int right=0; right<n; right++) {
            final int target = nums[right];
            curr += target;

            while((right - left + 1) * target - curr > k) {
                curr -= nums[left];
                left++;
            }
            total = Math.max(total, (right - left + 1));
        }
        return total;
    }

    public static int maxFrequencyBinarySearch(final int[] nums, final int k) {
        Arrays.sort(nums);
        final long[] prefix = new long[nums.length];
        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = nums[i] + prefix[i - 1];
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, check(i, k, nums, prefix));
        }

        return ans;

    }

    public static int check(final int i, final int k, final int[] nums, final long[] prefix) {
        int target = nums[i];
        int left = 0;
        int right = i;
        int best = i;

        while (left <= right) {
            int mid = (left + right) / 2;
            long count = i - mid + 1;
            long finalSum = count * target;
            long originalSum = prefix[i] - prefix[mid] + nums[mid];
            long operationsRequired = finalSum - originalSum;

            if (operationsRequired > k) {
                left = mid + 1;
            } else {
                best = mid;
                right = mid - 1;
            }
        }

        return i - best + 1;
    }
}

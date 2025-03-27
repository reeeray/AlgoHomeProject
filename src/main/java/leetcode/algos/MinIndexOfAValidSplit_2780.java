package leetcode.algos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 27.03.2025
 **/
public class MinIndexOfAValidSplit_2780 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(n)
    public int minimumIndex(final List<Integer> nums) {
        final Map<Integer, Integer> firstMap = new HashMap<>();
        final Map<Integer, Integer> secondMap = new HashMap<>();
        for (final int num : nums) {
            secondMap.put(num, secondMap.getOrDefault(num, 0) + 1);
        }

        for (int index = 0; index < nums.size(); index++) {
            final int num = nums.get(index);
            secondMap.put(num, secondMap.get(num) - 1);
            firstMap.put(num, firstMap.getOrDefault(num, 0) + 1);

            if (firstMap.get(num) * 2 > index + 1 && secondMap.get(num) * 2 > nums.size() - index - 1) {
                return index;
            }
        }
        return -1;
    }
    //Booyer-Moore majority voting algorithm Time O(n) and Space O(1)
    public int minimumIndexoPT(List<Integer> nums) {
        // Find the majority element
        int x = nums.get(0), count = 0, xCount = 0, n = nums.size();

        for (int num : nums) {
            if (num == x) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                x = num;
                count = 1;
            }
        }

        // Count frequency of majority element
        for (int num : nums) {
            if (num == x) {
                xCount++;
            }
        }

        // Check if valid split is possible
        count = 0;
        for (int index = 0; index < n; index++) {
            if (nums.get(index) == x) {
                count++;
            }
            int remainingCount = xCount - count;
            // Check if both left and right partitions satisfy the condition
            if (count * 2 > index + 1 && remainingCount * 2 > n - index - 1) {
                return index;
            }
        }

        return -1;
    }
}

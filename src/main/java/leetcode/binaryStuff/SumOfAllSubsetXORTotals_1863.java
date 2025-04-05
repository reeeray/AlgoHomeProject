package leetcode.binaryStuff;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 05.04.2025
 **/
public class SumOfAllSubsetXORTotals_1863 {

    public static void main(String[] args) {

    }

    //bactracking Time O(n*2^n) and Space O(n*2^n)
    public static int subsetXORSum(final int[] nums) {
        final List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), subsets);

        int res = 0;
        for(final List<Integer> subset : subsets) {
            int subsetXOR = 0;
            for(final int num : subset) {
                subsetXOR ^= num;
            }
            res += subsetXOR;
        }
        return res;
    }

    private static void generateSubsets(final int[] nums, final int index, final List<Integer> curr, final List<List<Integer>> total) {
        if(index == nums.length) {
            total.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[index]);
        generateSubsets(nums, index + 1, curr, total);
        curr.remove(curr.size() - 1);
        generateSubsets(nums, index + 1, curr, total);
    }

    //optimized backtracking Time O(2^n) and Space O(n)
    public int subsetXORSumOpt(int[] nums) {
        return XORSum(nums, 0, 0);
    }

    private int XORSum(int[] nums, int index, int currentXOR) {
        // Return currentXOR when all elements in nums are already considered
        if (index == nums.length) return currentXOR;

        // Calculate sum of subset xor with current element
        int withElement = XORSum(nums, index + 1, currentXOR ^ nums[index]);

        // Calculate sum of subset xor without current element
        int withoutElement = XORSum(nums, index + 1, currentXOR);

        // Return sum of xor totals
        return withElement + withoutElement;
    }

    //Time O(n) and Space O(1)
    public int subsetXORSumBitManupulation(int[] nums) {
        int result = 0;
        // Capture each bit that is set in any of the elements
        for (int num : nums) {
            result |= num;
        }
        // Multiply by the number of subset XOR totals that will have each bit set
        return result << (nums.length - 1);
    }
}

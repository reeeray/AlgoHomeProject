package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 08.04.2025
 **/
public class MinNumberOfOperationsToMakeElementsInArrayDistinct_3396 {

    public static void main(String[] args) {

    }

    //Reverse traversal Time O(n) and Space O(n)
    public int minimumOperationsOpt(int[] nums) {
        boolean[] seen = new boolean[128];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (seen[nums[i]]) {
                return i / 3 + 1;
            }
            seen[nums[i]] = true;
        }
        return 0;
    }

    //a bit more space required. Time O(n) and Space O(n)
    public static int minimumOperations(final int[] nums) {
        final int[] indexes = new int[101];
        int operations = 0;
        for(int i = 0; i< nums.length; i++) {
            if(indexes[nums[i]] != 0) {
                operations = Math.max(operations, indexes[nums[i]] % 3 == 0 ? indexes[nums[i]] / 3 : indexes[nums[i]] / 3 + 1);
            }
            indexes[nums[i]] = i + 1;
        }
        return operations;
    }
}

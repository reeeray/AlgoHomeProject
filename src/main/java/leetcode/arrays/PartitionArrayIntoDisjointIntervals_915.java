package leetcode.arrays;

/**
 * 915. Partition Array into Disjoint Intervals.
 * <p>
 * Given an array nums, partition it into two (contiguous) subarrays left and right so that:
 * <p>
 * Every element in left is less than or equal to every element in right.
 * left and right are non-empty.
 * left has the smallest possible size.
 * Return the length of left after such a partitioning.  It is guaranteed that such a partitioning exists.
 * <p>
 * <p>
 * User : Shein G.A.{@reeeray}
 * Date : 22.07.2021
 **/
public class PartitionArrayIntoDisjointIntervals_915 {

    public static void main(String[] args) {
        final int answer = partitionDisjoint(new int[]{5, 0, 3, 6, 8});
        System.out.println(answer);
        assert answer == 3;
    }

    private static int partitionDisjoint(final int[] nums) {
        int maxLeft = nums[0];
        int counter = 1;
        for (int i = 1; i < nums.length; i++) {
            final int num = nums[i];
            if (num >= maxLeft) {
                boolean flag = false;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] < maxLeft) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    maxLeft = num;
                    counter++;
                }
            } else {
                counter++;
            }
        }
        return counter;
    }
}

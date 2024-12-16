package leetcode.structures;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 16.12.2024
 **/
public class FinalArrayStateAfterKMultiplicationOperations1_3264 {

    public static void main(String[] args) {

    }

    //Time O(n*k) and Space O(1)
    public static int[] getFincalStateBruteForce(final int[] nums, final int k, final int multiplier) {
        for(int i=0; i<k; i++) {
            int x = 0;
            for(int j=1; j<nums.length; j++) {
                x = nums[j] < nums[x] ? j : x;
            }
            nums[x] = nums[x] * multiplier;
        }
        return nums;
    }
    //Space O(n) and Time O(n + klogn)
    public static int[] getFinalState(final int[] nums, int k, final int multiplier) {
        final PriorityQueue<int[]> sortedByIndex = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        for(int i=0; i<nums.length; i++) {
            sortedByIndex.offer(new int[] {nums[i], i});
        }
        while(k-- > 0) {
            final int[] min = sortedByIndex.poll();
            min[0] = min[0] * multiplier;
            nums[min[1]] = min[0];
            sortedByIndex.offer(min);
        }
        return nums;
    }
}

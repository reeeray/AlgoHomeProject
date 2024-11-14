package leetcode.arrays.binarySearch;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 14.11.2024
 **/
public class MinimizedMaxProductDistributedToAnyStore_2064 {

    public static void main(String[] args) {

    }

    //Time O(nlogn) and Space O(1)
    public boolean canDistribute(int x, int[] quantities, int n) {
        // Pointer to the first not fully distributed product type
        int j = 0;
        // Remaining quantity of the jth product type
        int remaining = quantities[j];

        // Loop through each store
        for (int i = 0; i < n; i++) {
            // Check if the remaining quantity of the jth product type
            // can be fully distributed to the ith store
            if (remaining <= x) {
                // If yes, move the pointer to the next product type
                j++;
                // Check if all products have been distributed
                if (j == quantities.length) {
                    return true;
                } else {
                    remaining = quantities[j];
                }
            } else {
                // Distribute the maximum possible quantity (x) to the ith store
                remaining -= x;
            }
        }
        return false;
    }

    public int minimizedMaximum(int n, int[] quantities) {
        // Initialize the boundaries of the binary search
        int left = 0;
        int right = Arrays.stream(quantities).max().orElse(quantities[0]);

        // Perform binary search until the boundaries converge
        while (left < right) {
            int middle = (left + right) / 2;
            if (canDistribute(middle, quantities, n)) {
                // Try for a smaller maximum
                right = middle;
            } else {
                // Increase the minimum possible maximum
                left = middle + 1;
            }
        }
        return left;
    }
}

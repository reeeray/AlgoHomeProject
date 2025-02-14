package leetcode.structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 14.02.2025
 **/
public class ProductOfTheLastKNumbers_1352 {

    final int[] nums;
    int index;
    int[] cache;

    public static void main(String[] args) {
        final ProductOfTheLastKNumbers_1352 instnce = new ProductOfTheLastKNumbers_1352();
        instnce.add(3);
        instnce.add(0);
        instnce.add(0);
        instnce.add(8);
        instnce.add(3);
        System.out.println(instnce.getProduct(1));
        instnce.add(7);
        System.out.println(instnce.getProduct(5));
        System.out.println(instnce.getProduct(4));
    }

    public ProductOfTheLastKNumbers_1352() {
        this.nums = new int[40_000];
        this.index = 0;
        cache = new int[0];
    }

    public void add (final int num) {
        nums[index++] = num;
        cache = new int[0];
    }

    public int getProduct(final int k) {
        if(cache.length == 0) {
            cache = new int[index];
            Arrays.fill(cache, -1);
            cache[0] = nums[index - 1];
        }
        if(cache[k - 1] != -1) {
            return cache[k - 1];
        }
        int idx = k - 1;
        while (--idx >= 0) {
            if(cache[idx] != -1) {
                break;
            }
        }
        for(int i = idx + 1; i < k; i++) {
            cache[i] = cache[i - 1] * nums[index - i - 1];
        }
        return cache[k - 1];
    }

    //Time O(n) and Space O(n)
    private static class ProductOfNumbers {

        // Stores cumulative product of the stream
        private ArrayList<Integer> prefixProduct = new ArrayList<>();
        private int size = 0;

        public ProductOfNumbers() {
            // Initialize the product list with 1 to handle multiplication logic
            this.prefixProduct.add(1);
            this.size = 0;
        }

        public void add(final int num) {
            if (num == 0) {
                // If num is 0, reset the cumulative products since multiplication
                // with 0 invalidates previous products
                this.prefixProduct = new ArrayList<Integer>();
                this.prefixProduct.add(1);
                this.size = 0;
            } else {
                // Append the cumulative product of the current number with the last
                // product
                this.prefixProduct.add(this.prefixProduct.get(this.size) * num);
                this.size++;
            }
        }

        public int getProduct(final int k) {
            // Check if the requested product length exceeds the size of the valid
            // product list
            if (k > this.size) return 0;

            // Compute the product of the last k elements using division
            return (
                    this.prefixProduct.get(this.size) /
                            this.prefixProduct.get(this.size - k)
            );
        }
    }

}

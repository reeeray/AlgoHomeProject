package leetcode.arrays;

import java.util.Stack;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 18.12.2024
 **/
public class FindPricesWithASpecialDiscountInAShop_1475 {

    public static void main(String[] args) {

    }

    //Brute force Spce O(n) and Time O(n2)
    public int[] finalPrices(int[] prices) {
        final int n = prices.length;
        final int[] result = prices.clone();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    result[i] = prices[i] - prices[j];
                    break;
                }
            }
        }

        return result;
    }

    //Time O(n) and Space O(n)
    public int[] finalPricesOpt(int[] prices) {
        // Create a copy of prices array to store discounted prices
        final int[] result = prices.clone();

        final Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            // Process items that can be discounted by current price
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                // Apply discount to previous item using current price
                result[stack.pop()] -= prices[i];
            }
            // Add current index to stack
            stack.add(i);
        }

        return result;
    }
}

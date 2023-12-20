package leetcode.pureLogic;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 20.12.2023
 **/
public class BuyTwoChocolates_2706 {

    public static void main(String[] args) {

    }

    //One pass : Time O(n) and Space O(1)
    public static int buyChocoOP(final int[] prices, final int money) {
        // Assume minimum and second minimum
        int minimum = Math.min(prices[0], prices[1]);
        int secondMinimum = Math.max(prices[0], prices[1]);

        // Iterate over the remaining elements
        for (int i = 2; i < prices.length; i++) {
            if (prices[i] < minimum) {
                secondMinimum = minimum;
                minimum = prices[i];
            } else if (prices[i] < secondMinimum) {
                secondMinimum = prices[i];
            }
        }

        // Minimum Cost
        int minCost = minimum + secondMinimum;

        return money >=  minCost ? money - minCost : money;
    }

    //O(n*logn) and O(logn)
    public static int buyChocoGreedy(final int[] prices, final int money) {
        Arrays.sort(prices);
        final int minPrice = prices[0] + prices[1];
        return money >=  minPrice ? money - minPrice : money;
    }
}

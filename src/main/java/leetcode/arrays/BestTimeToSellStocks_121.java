package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 23.02.2022
 **/
public class BestTimeToSellStocks_121 {

    public static void main(String[] args) {
        final int[] prices = {7, 1, 5, 3, 6, 4};
        assert maxProfit(prices) == 5;
    }

    public static int maxProfit(int[] prices) {
        int currentMin = Integer.MAX_VALUE;
        int profit = 0;
        int currentProfit;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < currentMin)
                currentMin = prices[i];
            currentProfit = prices[i] - currentMin;
            if (profit < currentProfit)
                profit = currentProfit;
        }
        // int profit = 0;
        // for(int i=1; i<prices.length; i++) {
        //     prices[i] = prices[i] - prices[0];
        //     profit = Math.max(profit, prices[i]);
        // }
        // for(int i=1; i<prices.length; i++) {
        //     for(int j=i+1; j<prices.length; j++) {
        //         prices[j] = -prices[i] + prices[j];
        //         profit = Math.max(profit, prices[j]);
        //     }
        // }
        return profit;
    }
}

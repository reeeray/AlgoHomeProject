package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 22.06.2023
 **/
public class BestTimeToBuyAndSellStockwithFee_714 {

    private static int max = 0;

    public static void main(String[] args) {
        final int[] prices = {1,4,6,2,8,3,10,14};
        assert maxProfitDP(prices, 3) == 13;
    }

    public static int maxProfitDP(final int[] prices, final int fee) {
        final int n= prices.length;
//        final int[] holdStock = new int [n], freeOfStock = new int[n];
//        holdStock[0] = -prices[0];
        int freeOfStock = 0, holdStock = -prices[0];
        for(int i=1; i<n; i++) {
//            holdStock[i] = Math.max(holdStock[i-1], freeOfStock[i-1] - prices[i]);
//            freeOfStock[i] = Math.max(freeOfStock[i-1], holdStock[i-1] + prices[i] - fee);
            holdStock = Math.max(holdStock, freeOfStock - prices[i]);
            freeOfStock = Math.max(freeOfStock, holdStock + prices[i] - fee);
        }
        return freeOfStock;
//        return freeOfStock[n-1];
    }

    //TLE
    public static int maxProfit(final int[] prices, final int fee) {
        max = 0;
        for(int i=0; i<prices.length-1; i++) {
            for(int j=i+1; j<prices.length; j++) {
                dfs(prices, j, prices[i], fee, 0);
            }
        }
        return max;
    }

    public static void dfs(final int[] prices, final int curr, final int price, final int fee, final int profit) {
        if(curr >= prices.length) {
            max = Math.max(max, profit);
            return;
        }
        final int currProfit = prices[curr] - price - fee;
        if(currProfit <= 0) {
            return;
        }

        for(int i=curr+1; i<prices.length-1; i++) {
            for(int j=i+1; j<prices.length; j++) {
                dfs(prices, j, prices[i], fee, profit + currProfit);
            }
        }
        max = Math.max(max, profit+currProfit);
    }


}

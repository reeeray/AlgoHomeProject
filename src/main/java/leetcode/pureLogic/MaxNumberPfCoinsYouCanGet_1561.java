package leetcode.pureLogic;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 24.11.2023
 **/
public class MaxNumberPfCoinsYouCanGet_1561 {

    public static void main(String[] args) {

    }

    public static int maxCoins(final int[] piles) {
        Arrays.sort(piles);
        int n = piles.length / 3;
        int total = 0;
        int index = piles.length - 2;
        while(n > 0) {
            total += piles[index];
            index -= 2;
            n--;
        }
        return total;
    }
}

package leetcode.pureLogic;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 06.01.2023
 **/
public class MaxIceCreamBars_1833 {

    public static void main(String[] args) {
        final int[] costs = {1, 3, 2, 4, 1};
        final int coins = 7;
        assert 4 == maxIceCream(costs, coins);
    }

    private static int maxIceCream(final int[] costs, int coins) {
        Arrays.sort(costs);
        int iceCreams = 0;

        while(iceCreams < costs.length && costs[iceCreams] <= coins) {
            coins-=costs[iceCreams];
            iceCreams++;
        }
        return iceCreams;
    }


}

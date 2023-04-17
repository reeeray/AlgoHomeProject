package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 17.04.2023
 **/
public class KidsWithGreatestNumberOfCandies_1431 {

    public static void main(String[] args) {

    }

    private static List<Boolean> kidsWithCandies (final int[] candies, final int extraCandies) {
        int max = candies[0];
        for(final int num : candies) {
            if(num > max) {
                max = num;
            }
        }

        final List<Boolean> result = new ArrayList<>();
        for(final int num : candies) {
            if(num + extraCandies >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}

package leetcode.arrays.binarySearch;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 08.03.2023
 **/
public class KokoEatingBananas_875 {

    public static void main(String[] args) {
        final int[] input = {3, 6, 7, 11};
        System.out.println(minEatingSpeed(input, 8));
    }

    public static int minEatingSpeed(final int[] piles, final int h) {
        int max = 0;
        for(int pile : piles) {
            max = max > pile ? max : pile;
        }
        int min = 1;

        while(min < max) {
            int mid = (min + max) / 2;
            int hours = 0;
            for(int pile : piles) {
                hours += pile % mid == 0 ? pile/mid : pile/mid + 1;
            }

            if(hours > h) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }
}

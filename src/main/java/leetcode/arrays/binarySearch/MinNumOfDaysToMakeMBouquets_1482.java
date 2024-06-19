package leetcode.arrays.binarySearch;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 19.06.2024
 **/
public class MinNumOfDaysToMakeMBouquets_1482 {

    public static void main(String[] args) {

    }

    public static int minDays(final int[] bloomDay, final int m, final int k) {
        if(m*k > bloomDay.length) {
            return -1;
        }
        int left = 0;
        int right = 0;
        for(int days : bloomDay) {
            right = days > right ? days : right;
        }
        int minDays = -1;

        while(left <= right) {
            final int mid = (left + right) / 2;
            final int numBouquets = countBouquets(bloomDay, mid, k);
            if(numBouquets >= m) {
                minDays = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return minDays;
    }

    private static int countBouquets(final int[] bloomDay, final int day, final int adj) {
        int index = 0;
        int numOfBouquets = 0;
        for(int i=0; i<bloomDay.length; i++) {
            if(bloomDay[i] <= day) {
                index++;
            } else {
                index = 0;
            }

            if(index == adj) {
                index = 0;
                numOfBouquets++;
            }
        }
        return numOfBouquets;
    }
}

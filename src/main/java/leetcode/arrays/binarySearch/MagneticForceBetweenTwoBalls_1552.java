package leetcode.arrays.binarySearch;

import leetcode.structures.Pair;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 20.06.2024
 **/
public class MagneticForceBetweenTwoBalls_1552 {

    public static void main(String[] args) {

    }

    //Space is only for sorting, in Java it's quick sort and it's O(logn) and Time is O(nlog(n* k/m)), O(nlogn) - sorting, k - max dist
    public static int maxDistance(final int[] position, final int m) {
        Arrays.sort(position);
        int left = 0;
        int right = (int) Math.ceil(position[position.length - 1] / (m - 1));
        int res = 0;
        while(left <= right) {
            final int mid = (left + right) / 2;
            if(canBeMinDistance(position, mid, m)) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    private static boolean canBeMinDistance(final int[] pos, final int dist, final int balls) {
        int prevIndex = 0;
        int ballsPlaced = 1;

        for(int i = 1; i<pos.length && ballsPlaced < balls; i++) {
            if(pos[i] - pos[prevIndex] >= dist) {
                prevIndex = i;
                ballsPlaced++;
            }
        }
        return ballsPlaced == balls;
    }

}

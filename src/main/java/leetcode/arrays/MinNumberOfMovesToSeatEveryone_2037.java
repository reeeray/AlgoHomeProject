package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 13.06.2024
 **/
public class MinNumberOfMovesToSeatEveryone_2037 {

    public static void main(String[] args) {

    }

    // Time complexity O(n) and Space complexity O(1)
    public static int minMovesToSeat(final int[] seats, final int[] students) {
        final int[] diffs = new int[100]; // it's task constraints
        int moves = 0;
        int difference = 0;

        for (int i = 0; i < seats.length; i++) {
            diffs[seats[i]]++;
            diffs[students[i]]--;
        }

        for (int diff : diffs) {
            moves += Math.abs(difference);
            difference += diff;
        }

        return moves;
    }
}

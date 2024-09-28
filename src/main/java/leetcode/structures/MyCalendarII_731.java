package leetcode.structures;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 28.09.2024
 **/
public class MyCalendarII_731 {

    private List<int[]> bookings;
    private List<int[]> overlapBookings;

    //Time O(n) and Space O(n) where n is the size of the list of bookings
    public MyCalendarII_731() {
        bookings = new ArrayList<>();
        overlapBookings = new ArrayList<>();
    }

    private boolean doesOverlap(int start1, int end1, int start2, int end2) {
        return Math.max(start1, start2) < Math.min(end1, end2);
    }

    private int[] getOverlapped(int start1, int end1, int start2, int end2) {
        return new int[] { Math.max(start1, start2), Math.min(end1, end2) };
    }

    public boolean book(int start, int end) {
        for (int[] booking : overlapBookings) {
            if (doesOverlap(booking[0], booking[1], start, end)) {
                return false;
            }
        }

        for (int[] booking : bookings) {
            if (doesOverlap(booking[0], booking[1], start, end)) {
                overlapBookings.add(
                        getOverlapped(booking[0], booking[1], start, end)
                );
            }
        }

        bookings.add(new int[] { start, end });
        return true;
    }
}

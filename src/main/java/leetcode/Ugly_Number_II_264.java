package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode issue 264 : Ugly number II.
 * <p>
 * Write a program to find the n-th ugly number.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5
 * <p>
 * User : Shein G.A.{@reeeray}
 * Date : 04.07.2020
 **/
public class Ugly_Number_II_264 {

    public static int nthUglyNumber(int n) {
        final List<Integer> ugly = new ArrayList<>();
        ugly.add(1);
        int counter2 = 0;
        int counter3 = 0;
        int counter5 = 0;
        while (ugly.size() != n) {
            int x = ugly.get(counter2) * 2;
            int y = ugly.get(counter3) * 3;
            int z = ugly.get(counter5) * 5;
            int min = min(x, y, z);
            ugly.add(min);
            if (min == x)
                counter2++;
            if (min == y)
                counter3++;
            if (min == z)
                counter5++;
        }
        return ugly.get(n - 1);
    }

    private static int min(final int x, final int y, final int z) {
        return Math.min(x, Math.min(y, z));
    }

    public static void main(String[] args) {
        assert nthUglyNumber(11) == 14;
    }
}

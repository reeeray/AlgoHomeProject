package leetcode.pureLogic;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 04.11.2023
 **/
public class LastMomentBeforeAllAntsFallOut_1503 {

    public static void main(String[] args) {

    }

    public static int getLastMoment(final int n, final int[] left, final int[] right) {
        final int fromLeft = n - Arrays.stream(right).min().orElse(n);
        final int fromRight = Arrays.stream(left).max().orElse(0);
        return Math.max(fromLeft, fromRight);
    }
}

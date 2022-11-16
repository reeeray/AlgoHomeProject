package leetcode.binaryStuff;

import patterns.behavioral.chain_of_responsibility.RequestType;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 16.11.2022
 **/
public class GuessNumberHigherOrLower_374 {

    public static final int DESIRED = 6;

    public static void main(String[] args) {
        assert guessNumber(10) == DESIRED;
    }

    private static int guessNumber(final int n) {
        int left = 0;
        int right = n;
        while(left <= right) {
            final int gues = left + (right - left) / 2;
            final int res = guess(gues);
            if(res == 0) {
                return gues;
            } else if(res == -1) {
                right = gues - 1;
            } else {
                left = gues + 1;
            }
        }
        return -1;
    }

    private static int guess(final int number) {
        if(number == DESIRED) {
            return 0;
        } else if(number > DESIRED) {
            return -1;
        } else {
            return 1;
        }
    }
}

package leetcode.algos;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 06.07.2024
 **/
public class PassThePillow_2582 {
    public static void main(String[] args) {

    }

    //Time O(1) and Space O(1)
    public int passThePillow(final  int n, final int time) {
        // Calculate the number of complete rounds of pillow passing
        final int fullRounds = time / (n - 1);

        // Calculate the remaining time after complete rounds
        final int extraTime = time % (n - 1);

        // Determine the position of the person holding the pillow
        // If fullRounds is even, the pillow is moving forward.
        // If fullRounds is odd, the pillow is moving backward.
        return  fullRounds % 2 == 0 ? extraTime + 1 : n - extraTime;
    }
}

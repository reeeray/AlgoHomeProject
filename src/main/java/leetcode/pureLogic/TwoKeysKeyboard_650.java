package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 19.08.2024
 **/
public class TwoKeysKeyboard_650 {

    public static void main(String[] args) {

    }

    public static int minSteps(final int n) {
        if(n < 2) {
            return 0;
        }
        final int[] simpleNumbers = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
        for(int i : simpleNumbers) {
            if(n % i == 0) {
                return i + minSteps(n / i);
            }
        }
        return n;
    }

    //Space O(n) and Time O(1)
    public int minStepsEditorial(int n) {
        int ans = 0;
        int d = 2;
        while (n > 1) {
            // If d is prime factor, keep dividing
            // n by d until is no longer divisible
            while (n % d == 0) {
                ans += d;
                n /= d;
            }
            d++;
        }
        return ans;
    }
}

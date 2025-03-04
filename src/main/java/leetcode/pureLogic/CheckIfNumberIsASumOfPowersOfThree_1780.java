package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 04.03.2025
 **/
public class CheckIfNumberIsASumOfPowersOfThree_1780 {

    public static void main(String[] args) {
        checkPowersOfThree(11);
    }

    public static boolean checkPowersOfThree(final int n) {
        if(n == 3 || n == 1) {
            return true;
        }
        int maxPow = 1;
        int num = 3;
        while (num*3 <= n) {
            num *= 3;
            maxPow++;
            if(num == n)
                return true;
        }
        final int diff = n - num;
        return diff >= num || diff < 0 ? false : checkPowersOfThree(diff);
    }

    //Optimized iterative approach Time O(log3n) and Space O(1)
    public boolean checkPowersOfThreeOpt(int n) {
        int power = 0;

        // Find the largest power that is smaller or equal to n
        while (Math.pow(3, power) <= n) {
            power++;
        }

        while (n > 0) {
            // Subtract current power from n
            if (n >= Math.pow(3, power)) {
                n -= (int) Math.pow(3, power);
            }
            // We cannot use the same power twice
            if (n >= Math.pow(3, power)) {
                return false;
            }
            // Move to the next lower power
            power--;
        }

        // n has reached 0
        return true;
    }

    //Time O(log3n) and Space O(1)
    public boolean checkPowersOfThreeElegant(int n) {
        while (n > 0) {
            // Check if this power should be used twice
            if (n % 3 == 2) {
                return false;
            }
            // Divide n by 3 to move to the next greater power
            n /= 3;
        }
        // The ternary representation of n consists only of 0s and 1s
        return true;
    }

    //bactracking brute force : Time O(2^(log3n) and Space O(log3n)
    public boolean checkPowersOfThreeBruteForce(int n) {
        return checkPowersOfThreeHelper(0, n);
    }

    private boolean checkPowersOfThreeHelper(int power, int n) {
        // Base case: if n becomes 0, we have successfully formed the sum
        if (n == 0) return true;

        // If the current power of 3 exceeds n, we can't use it, so return false
        if (Math.pow(3, power) > n) return false;

        // Option 1: Include the current power of 3 and subtract it from n
        boolean addPower = checkPowersOfThreeHelper(
                power + 1,
                n - (int) Math.pow(3, power)
        );

        // Option 2: Skip the current power of 3 and try with the next power
        boolean skipPower = checkPowersOfThreeHelper(power + 1, n);

        // Return true if either option leads to a valid solution
        return addPower || skipPower;
    }
}

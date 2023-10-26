package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 24.07.2023
 **/
public class Pow_50 {

    public static void main(String[] args) {
        myPowExp(4, 5);
    }

    public static double myPowExp(double x, long n) {
        if(x == .0) {
            return .0;
        }

        if(n == 0) {
            return 1.0;
        }
        // Handle case where, n < 0.
        if(n < 0) {
            n *= -1;
            x = 1/x;
        }
        // Perform Binary Exponentiation.
        double res = 1.0;
        while(n != 0) {
            // If 'n' is odd we multiply result with 'x' and reduce 'n' by '1'.
            if(n % 2 == 1) {
                res *= x;
                n--;
            }
            x *= x;
            n /= 2;
        }
        return res;
    }

    public double myPow(double x, int n) {
        return myPow(x, 1L*n);
    }

    private double myPow(double x, long n) {
        if(n == 0)
            return 1;
        if(n < 0)
            return myPow(1/x, -n);
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}

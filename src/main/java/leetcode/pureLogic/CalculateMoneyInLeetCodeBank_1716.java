package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 06.12.2023
 **/
public class CalculateMoneyInLeetCodeBank_1716 {

    public static void main(String[] args) {

    }

    public int totalMoney(final int n) {
        final int x = n / 7;
        final int y = n % 7;
        final int integerPart = x > 0 ? 28*x + (7*x*(x-1)) / 2 : 0;
        final int reminder = ((1 + y) * y) / 2 + x*y;
        return integerPart + reminder;
    }

    public int totalMoneyBrutForce(int n) {
        int monday = 1;
        int amount = 0;
        while (n > 0) {
            for(int i=0; i<Math.min(n, 7); i++) {
                amount += monday + i;
            }
            n -= 7;
            monday++;
        }
        return amount;
    }
}

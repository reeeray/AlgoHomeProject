package leetcode.structures;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.10.2025
 **/
public class SimpleBankSystem_2043 {

    public static void main(String[] args) {

    }

    private static class Bank {

        final long[] balance;
        final int n;

        public Bank(final long[] balance) {
            this.balance = balance;
            this.n = balance.length;
        }

        public boolean transfer(final int account1, final int account2, final long money) {
            if(account1 < 1 || account1 > n || account2 < 1 || account2 > n) {
                return false;
            }
            if(balance[account1 - 1] < money) {
                return false;
            }
            balance[account1 - 1] -= money;
            balance[account2 - 1] += money;
            return true;
        }

        public boolean deposit(final int account, final long money) {
            if(account < 1 || account > n) return false;
            balance[account - 1] += money;
            return true;
        }

        public boolean withdraw(final int account, final long money) {
            if(account < 1 || account > n || balance[account - 1] < money) {
                return false;
            }
            balance[account - 1] -= money;
            return true;
        }
    }
}

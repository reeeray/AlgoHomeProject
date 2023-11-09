package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 09.11.2023
 **/
public class CountNumberOfHomogenousSubstr_1759 {

    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        final String input = "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww";
        long g = count(456678);
        int i = (int) (g % MOD);
        countHomogenous(input);
    }

    public static int countHomogenous(final String s) {
        int inline = 0;
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            if(i == 0 || s.charAt(i-1) == s.charAt(i)) {
                inline++;
            }
            count = (count + inline) % MOD;
        }
        return count;
    }
    public static int countHomogenousOptimum(final String s) {

        int sum = 0;
        char curr = s.charAt(0);
        int count = 1;
        for(int index = 1; index<s.length(); index++) {
            if(curr == s.charAt(index)) {
                count++;
            } else {
                sum = (int) ((sum + count(count)) % MOD);
                count = 1;
                curr = s.charAt(index);
            }
        }
        sum =(int) ((sum + count(count)) % MOD);
        return sum;
    }

    private static long count(final int n) {
        final long mid = (1L + n) * n;
        return mid/2;
    }
}

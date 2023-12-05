package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 05.12.2023
 **/
public class CountOfMatchesInTournament_1688 {

    public static void main(String[] args) {

    }

    public static int numberOfMatches(int n) {
        int ans = 0;
        while(n > 0) {
            ans += n / 2;
            n = n / 2 + n % 2;
        }
        return ans;
    }

    public static int numberOfMatchesLogic(final int n) {
        return n - 1;
    }
}

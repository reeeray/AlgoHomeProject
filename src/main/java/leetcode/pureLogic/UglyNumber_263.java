package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 18.11.2022
 **/
public class UglyNumber_263 {

    public static void main(String[] args) {
        assert true == isUgly(6);
    }

    private static boolean isUgly(int n) {
        if(n <= 0) {
            return false;
        }

        while(n%2 == 0) {
            n/=2;
        }
        while(n%3 == 0) {
            n/=3;
        }
        while(n%5 == 0) {
            n/=5;
        }
        return n==1;
    }
}

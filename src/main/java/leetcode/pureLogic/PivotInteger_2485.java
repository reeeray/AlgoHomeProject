package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 13.03.2024
 **/
public class PivotInteger_2485 {

    public static void main(String[] args) {

    }

    public static int pibotInteger(int n) {
        int left = (n + 1)*n/2;
        int right = n;

        while(left >= right) {
            if(left == right) {
                return n;
            }
            left -= n;
            right += n-1;
            n--;
        }
        return -1;
    }
}

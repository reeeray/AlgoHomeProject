package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.04.2023
 **/
public class AddDigits_258 {
    public static void main(String[] args) {

    }

    private static int addDigits(final int num) {
        String number = String.valueOf(num);
        while (number.length() != 1) {
            int res = 0;
            for(char i : number.toCharArray()) {
                res += i - '0';
            }
            number = String.valueOf(res);
        }
        return Integer.valueOf(number);
    }

    private static int addFigitEff(final int num) {
        //Mathematical: Digital Root
        return num == 0 ? 0 : 1 + (num - 1) % 9;
    }
}

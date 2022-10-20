package leetcode.strings;

/**
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 *
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 *
 * User : Shein G.A.{@reeeray}
 * Date : 20.10.2022
 **/
public class IntegersToRomanian_12 {

    public static void main(String[] args) {
        System.out.println(intToRomanian(1994));
        assert intToRomanian(1994).equals("MCMXCIV");
    }
    private static String intToRomanian(int n) {
        final StringBuilder sb = new StringBuilder();

        while (n > 0) {

            if (n >= 1000) {
                n -= 1000;
                sb.append("M");
            } else if (n >= 900) {
                n -= 900;
                sb.append("CM");
            } else if (n >= 500) {
                n -= 500;
                sb.append("D");
            } else if (n >= 400) {
                n -= 400;
                sb.append("CD");
            } else if (n >= 100) {
                n -= 100;
                sb.append("C");
            } else if (n >= 90) {
                n -= 90;
                sb.append("XC");
            } else if (n >= 50) {
                n -= 50;
                sb.append("L");
            } else if (n >= 40) {
                n -= 40;
                sb.append("XL");
            } else if (n >= 10) {
                n -= 10;
                sb.append("X");
            } else if (n == 9) {
                n -= 9;
                sb.append("IX");
            } else if (n >= 5) {
                n -= 5;
                sb.append("V");
            } else if (n == 4) {
                n -= 4;
                sb.append("IV");
            } else {
                n -= 1;
                sb.append("I");
            }
        }


        return sb.toString();
    }
}

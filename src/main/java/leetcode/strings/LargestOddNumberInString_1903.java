package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 07.12.2023
 **/
public class LargestOddNumberInString_1903 {

    public static void main(String[] args) {
        final String input = "52";
        System.out.println(largestOddNumber(input));
    }

    public static String largestOddNumber(final String num) {
        for(int i=num.length()-1; i >= 0; i--) {
            if(Integer.valueOf(num.charAt(i) - 48) % 2 != 0) {
                return num.substring(0, i+1);
            }
        }
        return "";
    }
}

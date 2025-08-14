package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 14.08.2025
 **/
public class Largest3SameDigitNumberInString_2264 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(1)
    public static String largestGoodInteger(final String num) {
        int res = -1;
        for (int i = 2; i < num.length(); i++) {
            if(num.charAt(i - 2) == num.charAt(i) && num.charAt(i - 1) == num.charAt(i)) {
                final int val = (int) num.charAt(i);
                res = res >= val ? res : val;
            }
            if(res == 9) {
                return "999";
            }
        }
        return "" +res + res + res;
    }

    public String largestGoodIntegerElegantImpl(String num) {
        // Assign 'maxDigit' to the NUL character (smallest ASCII value character)
        char maxDigit = '\0';

        // Iterate on characters of the num string.
        for (int index = 0; index <= num.length() - 3; ++index) {
            // If 3 consecutive characters are the same,
            // store the character in 'maxDigit' if it's bigger than what it already stores.
            if (num.charAt(index) == num.charAt(index + 1) && num.charAt(index) == num.charAt(index + 2)) {
                maxDigit = (char) Math.max(maxDigit, num.charAt(index));
            }
        }

        // If 'maxDigit' is NUL, return an empty string; otherwise, return a string of size 3 with 'maxDigit' characters.
        return maxDigit == '\0' ? "" : new String(new char[]{maxDigit, maxDigit, maxDigit});
    }
}

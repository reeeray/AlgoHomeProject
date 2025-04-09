package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 10.02.2025
 **/
public class ClearDigits_3174 {

    public static void main(String[] args) {
        System.out.println(clearDigits("c3b4te"));
    }

    //Time O(n) and Time O(n)
    public static String clearDigits(final String s) {
        final StringBuilder sb = new StringBuilder();
        for(final char c : s.toCharArray()) {
            if(c >= '0' && c <= '9' && sb.length() != 0) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    //Time O(n) and Space O(1)
    public static String clearDigitsInPlace(final String s) {
        final char[] chars = s.toCharArray();
        int lengthOfAnswer = 0;
        for(int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                lengthOfAnswer = lengthOfAnswer > 0 ? lengthOfAnswer - 1 : 0;
            } else {
                chars[lengthOfAnswer++] = s.charAt(i);
            }
        }
        return new String(chars, 0, lengthOfAnswer);
    }
}

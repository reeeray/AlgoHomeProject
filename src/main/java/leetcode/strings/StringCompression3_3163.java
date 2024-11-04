package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 04.11.2024
 **/
public class StringCompression3_3163 {

    public static void main(String[] args) {

    }

    public static String compressedString(final String word) {
        final StringBuilder sb = new StringBuilder();
        char str = word.charAt(0);
        int count = 1;
        for(int i=1; i<word.length(); i++) {
            if(str == word.charAt(i) && count < 9) {
                count++;
                continue;
            } else {
                sb.append(count);
                count = 0;
                sb.append(str);
                str = word.charAt(i);
            }
        }
        sb.append(count);
        sb.append(str);
        return sb.toString();
    }

}

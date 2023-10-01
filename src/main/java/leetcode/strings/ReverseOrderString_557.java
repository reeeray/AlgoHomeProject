package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 01.10.2023
 **/
public class ReverseOrderString_557 {

    public static void main(String[] args) {

    }

    private static String reverseWords(String s) {
        int lastSpaceIndex = -1;
        final char[] chArray = s.toCharArray();
        int len = s.length();
        for (int strIndex = 0; strIndex <= len; strIndex++) {
            if (strIndex == len || chArray[strIndex] == ' ') {
                int startIndex = lastSpaceIndex + 1;
                int endIndex = strIndex - 1;
                while (startIndex < endIndex) {
                    char temp = chArray[startIndex];
                    chArray[startIndex] = chArray[endIndex];
                    chArray[endIndex] = temp;
                    startIndex++;
                    endIndex--;
                }
                lastSpaceIndex = strIndex;
            }
        }
        return new String(chArray);
    }
}

package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 15.09.2025
 **/
public class MaxNumberOfWordsYouCanType_1935 {

    public static void main(String[] args) {

    }

    public static int canBeTypeWords(final String text, final String brokenLetters) {
        boolean isToSkip = false;
        int counter = 0;
        for(final char c : text.toCharArray()) {
            if(c == ' ') {
                if(!isToSkip) {
                    counter++;
                }
                isToSkip = false;
            } else {
                if(brokenLetters.contains("" + c)) {
                    isToSkip = true;
                }
            }
        }
        if(!isToSkip) counter++;
        return counter;
    }
}

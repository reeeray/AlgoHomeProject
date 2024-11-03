package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 03.11.2024
 **/
public class CircularSentence_2490 {

    public static void main(String[] args) {

    }

    public boolean isCircularSentence(final String sentence) {
        for (int i = 0; i < sentence.length(); ++i) {
            if (sentence.charAt(i) == ' ' && sentence.charAt(i - 1) != sentence.charAt(i + 1))
                return false;
        }
        return sentence.charAt(0) == sentence.charAt(sentence.length() - 1);
    }
}

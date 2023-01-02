package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 02.01.2023
 **/
public class DetectCapital_520 {

    public static void main(String[] args) {
        final String input1 = "Russia";
        final String input2 = "RUSSIA";
        final String input3 = "RuSSia";

        assert detecCapitalCase(input1);
        assert detectCapitalCase(input2);
        assert !detecCapitalCase(input3);


    }


    private static boolean detecCapitalCase(final String word) {
        int counter = 0;
        for(char c : word.toCharArray()) {
            if (c < 'a') {
                counter++;
            }
        }

        if(counter == word.length() || counter == 0 || (counter == 1 && word.charAt(0) < 'a')) {
            return true;
        }
        return false;
    }

    private static boolean detectCapitalCase(final String word) {
        return word.toUpperCase().equals(word) || word.substring(1).toLowerCase().equals(word.substring(1));
    }
}

package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 02.12.2024
 **/
public class CheckIfAWordOccursAPrefix_1455 {

    public static void main(String[] args) {

    }

    //Space O(n) and Time O(n)
    public static int isPrefixOfWord(final String sentence, final String searchWord) {
        final String[] words = sentence.split("\\s+");
        for(int i=0; i<words.length; i++) {
            if(words[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}

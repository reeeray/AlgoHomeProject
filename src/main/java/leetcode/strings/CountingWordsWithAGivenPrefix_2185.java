package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 09.01.2025
 **/
public class CountingWordsWithAGivenPrefix_2185 {

    public static void main(String[] args) {

    }

    public static int prefixCountCompact(final String[] words, final String pref) {
        int count = 0;
        for(final String word : words)
            if(word.startsWith(pref)) count++;
        return count;
    }

    //Time O(n * m) where n is the number of words and m is the prefix length, Space O(1)
    public static int prefixCount(final String[] words, final String pref) {
        int count = 0;
        for(final String word : words) {
            if(word.startsWith(pref)) count++;
            if(pref.length() > word.length()) {
                continue;
            }
            boolean isPrefix = true;
            for(int i=0; i<pref.length(); i++) {
                if(pref.charAt(i) != word.charAt(i)) {
                    isPrefix = false;
                    break;
                }
            }
            if(isPrefix) count++;
        }
        return count;
    }


    //can be also solved via Trie, then we loose in space but gain in time
}

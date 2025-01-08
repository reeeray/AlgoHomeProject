package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 08.01.2025
 **/
public class CountPrefixAndSuffixPairs1_3042 {

    public static void main(String[] args) {
        System.out.println(countPrefixSuffixPairs(new String[] {"a", "aba", "ababa", "aa"}));
        assert 4 == countPrefixSuffixPairs(new String[] {"a", "aba", "ababa", "aa"});
    }

    //Time O(n^2 * m) where n is number of the words in array and m is an average length of the word, Space is O(1)
    public static int countPrefixSuffixPairs(final String[] words) {
        int count = 0;
        for(int i=0; i<words.length - 1; i++) {
            for(int j=i+1; j<words.length; j++) {
                if(isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isPrefixAndSuffix(final String str1, final String str2) {
        if(str1.length() > str2.length()) {
            return false;
        }
        if(str1.length() == str2.length()) {
            return str1.equals(str2);
        }
        for(int i=0; i<str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i) || str1.charAt(str1.length() - 1 - i) != str2.charAt(str2.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

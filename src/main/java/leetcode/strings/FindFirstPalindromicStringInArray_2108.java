package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 13.02.2024
 **/
public class FindFirstPalindromicStringInArray_2108 {

    public static void main(String[] args) {

    }

    //Time complexity O(N*M) where m is the length of longest word and Space complexity is O(1)
    public static String firstPalindrome(final String[] words) {
        for(final String word : words) {
            if(word.length() <= 1) {
                return word;
            }
            int left = 0;
            int right = word.length()-1;
            while(left < right) {
                if(word.charAt(left) != word.charAt(right)) {
                    break;
                }
                if(++left >= --right) {
                    return word;
                }
            }
        }
        return "";
    }
}

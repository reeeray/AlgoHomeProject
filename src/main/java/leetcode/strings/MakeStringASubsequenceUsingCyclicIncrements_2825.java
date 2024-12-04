package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 04.12.2024
 **/
public class MakeStringASubsequenceUsingCyclicIncrements_2825 {

    public static void main(String[] args) {
        canMakeSubsequence("zc", "ad");
    }

    public static boolean canMakeSubsequence(final String str1, final String str2) {
        int idx = 0;
        int match = 0;
        for(int i=0; i<str2.length(); i++) {
            while (idx < str1.length()) {
                if (str1.charAt(idx) == str2.charAt(i) || ((str1.charAt(idx) - 'a' + 1) % 26) == (str2.charAt(i) - 'a')) {
                    idx++;
                    match++;
                    break;
                }
                idx++;
            }
            if(idx == str1.length() && match != str2.length()) {
                return false;
            }
        }
        return true;
    }

    public boolean canMakeSubsequenceOpt(final String str1, final String str2) {
        int idx = 0;
        for (int i = 0; i < str1.length() && idx < str2.length(); i++) {
            if (str1.charAt(i) == str2.charAt(idx) || ((str1.charAt(i) - 'a' + 1) % 26) == (str2.charAt(idx) - 'a')) {
                idx++;
            }
        }
        return idx == str2.length();
    }

    //O(n+m) and O(1)
    public boolean canMakeSubsequenceSimplier(String str1, String str2) {
        int str2Index = 0;
        int lengthStr1 = str1.length(), lengthStr2 = str2.length();

        // Traverse through both strings using a for loop
        for (
                int str1Index = 0;
                str1Index < lengthStr1 && str2Index < lengthStr2;
                ++str1Index
        ) {
            // Check if characters match, or if str1[str1Index] can be incremented to str2[str2Index]
            if (
                    str1.charAt(str1Index) == str2.charAt(str2Index) ||
                            (str1.charAt(str1Index) + 1 == str2.charAt(str2Index)) ||
                            (str1.charAt(str1Index) - 25 == str2.charAt(str2Index))
            ) {
                // If match found, move to next character in str2
                str2Index++;
            }
        }
        // Check if all characters in str2 were matched
        return str2Index == lengthStr2;
    }

}

package leetcode.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 01.02.2023
 **/
public class GreatestCommonDiviserOfStrings_1071 {

    public static void main(String[] args) {
        gcdOfString("ABABAB", "ABAB");

    }

    //this solution is for random strings without pattern
    private static String gcdOfStrings(final String str1, final String str2) {
        String smallest = str1.length() > str2.length() ? str1 : str2;
        String biggest = str1.length() > str2.length() ? str2 : str1;
        final List<String> combinations = new ArrayList<>();
        for(int i = 0; i<smallest.length(); i++) {
            combinations.add(smallest.substring(i, smallest.length()));
        }

        for(final String possibleAnsw : combinations) {
            if(biggest.contains(possibleAnsw)) {
                return possibleAnsw;
            }
        }
        return "";
    }

    private static String gcdOfString(final String str1, final String str2) {
        String smallest = str1.length() > str2.length() ? str2 : str1;
        String biggest = str1.length() > str2.length() ? str1 : str2;
        String pattern = "";
        for(int i = 0; i<smallest.length(); i++) {
            String pat = smallest.substring(0, i+1);
            String substr = pat;
            while(smallest.contains(substr)) {
                if(smallest.equals(substr)) {
                    String substr2 = pat;
                    while(biggest.contains(substr2)) {
                        if (biggest.equals(substr2)) {
                            pattern = smallest.substring(0, i+1);
                            break;
                        }
                        substr2 +=pat;
                    }
                    break;
                }
                substr += pat;
            }
        }
        return pattern;
    }

    private static String gcdOfStringElegant(final String str1, final String str2) {
        if(!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        final int lengthOfLargestPattern = gcd(str1.length(), str2.length());
        return str1.substring(0, lengthOfLargestPattern);
    }

    private static int gcd(final int l, final int r) {
        if(r == 0) {
            return l;
        } else {
            return gcd(r, l%r);
        }
    }

    private static boolean valid(String str1, String str2, int k) {
        int len1 = str1.length(), len2 = str2.length();
        if (len1 % k > 0 || len2 % k > 0) {
            return false;
        } else {
            String base = str1.substring(0, k);
            return str1.replace(base, "").isEmpty() && str2.replace(base, "").isEmpty();
        }
    }

    //elegant brute force
    private static String gcdOfStringsElegantBruteForce(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        for (int i = Math.min(len1, len2); i >= 1; --i) {
            if (valid(str1, str2, i)) {
                return str1.substring(0, i);
            }
        }
        return "";
    }
}

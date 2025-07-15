package leetcode.strings;

import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 15.07.2025
 **/
public class ValidWord_3136 {

    public static void main(String[] args) {
        isValid("Ya$");
    }

    public boolean isValidRegExp(String word) {
        return word.matches("(?i)(?=^.*[b-df-hj-np-tv-z])(?=.*[aieou])^[a-z0-9]{3,}$");
    }

    public boolean isValidElegenat( final String word) {
        if (word.length() < 3) {
            return false;
        }
        boolean hasVowel = false;
        boolean hasConsonant = false;
        for (final char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                char ch = Character.toLowerCase(c);
                if (
                        ch == 'a' ||
                                ch == 'e' ||
                                ch == 'i' ||
                                ch == 'o' ||
                                ch == 'u'
                ) {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            } else if (!Character.isDigit(c)) {
                return false;
            }
        }
        return hasVowel && hasConsonant;
    }

    public static boolean isValid(String word) {
        if(word.length() < 3) {
            return false;
        }
        final List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
        word = word.toLowerCase();
        boolean isVowelThere = false;
        boolean isConsonantThere = false;
        for(final char c : word.toCharArray()) {
            if(c - 'a' >= 0 && c - 'a' < 26) {
                if (vowels.contains(c)) {
                    isVowelThere = true;
                } else {
                    isConsonantThere = true;
                }
            } else if (c - '0' >= 0 && c - '0' < 10) {
                continue;
            } else {
                return false;
            }
        }
        return isVowelThere && isConsonantThere;
    }
}

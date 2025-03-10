package leetcode.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 10.03.2025
 **/
public class CountOfSubstringsContainingEveryVowelAndKConsonants2_3306 {

    public static void main(String[] args) {
        countOfSubstrings("iqeaouqi", 2);
    }

    //Timt O(n) and Space O(1)
    public long countOfSubstringsOpt(String word, int k) {
        return atLeastK(word, k) - atLeastK(word, k + 1);
    }

    private long atLeastK(String word, int k) {
        long numValidSubstrings = 0;
        int start = 0;
        int end = 0;
        // keep track of counts of vowels and consonants
        HashMap<Character, Integer> vowelCount = new HashMap<>();
        int consonantCount = 0;

        // start sliding window
        while (end < word.length()) {
            // insert new letter
            char newLetter = word.charAt(end);

            // update counts
            if (isVowel(newLetter)) {
                vowelCount.put(
                        newLetter,
                        vowelCount.getOrDefault(newLetter, 0) + 1
                );
            } else {
                consonantCount++;
            }

            // shrink window while we have a valid substring
            while (vowelCount.size() == 5 && consonantCount >= k) {
                numValidSubstrings += word.length() - end;
                char startLetter = word.charAt(start);
                if (isVowel(startLetter)) {
                    vowelCount.put(
                            startLetter,
                            vowelCount.get(startLetter) - 1
                    );
                    if (vowelCount.get(startLetter) == 0) {
                        vowelCount.remove(startLetter);
                    }
                } else {
                    consonantCount--;
                }
                start++;
            }

            end++;
        }

        return numValidSubstrings;
    }

    //Time O(n) and Space O(n)
    public long countOfSubstringsWorks(String word, int k) {
        long numValidSubstrings = 0;
        int start = 0;
        int end = 0;
        // keep track of counts of vowels and consonants
        final HashMap<Character, Integer> vowelCount = new HashMap<>();
        int consonantCount = 0;

        // compute index of next consonant for all indices
        int[] nextConsonant = new int[word.length()];
        int nextConsonantIndex = word.length();
        for (int i = word.length() - 1; i >= 0; i--) {
            nextConsonant[i] = nextConsonantIndex;
            if (!isVowel(word.charAt(i))) {
                nextConsonantIndex = i;
            }
        }

        // start sliding window
        while (end < word.length()) {
            // insert new letter
            char newLetter = word.charAt(end);

            // update counts
            if (isVowel(newLetter)) {
                vowelCount.put(
                        newLetter,
                        vowelCount.getOrDefault(newLetter, 0) + 1
                );
            } else {
                consonantCount++;
            }

            // shrink window if too many consonants in our window
            while (consonantCount > k) {
                char startLetter = word.charAt(start);
                if (isVowel(startLetter)) {
                    vowelCount.put(
                            startLetter,
                            vowelCount.get(startLetter) - 1
                    );
                    if (vowelCount.get(startLetter) == 0) {
                        vowelCount.remove(startLetter);
                    }
                } else {
                    consonantCount--;
                }
                start++;
            }

            // while we have a valid window, try to shrink it
            while (
                    start < word.length() &&
                            vowelCount.keySet().size() == 5 &&
                            consonantCount == k
            ) {
                // count the current valid substring, as well as valid substrings produced by appending more vowels
                numValidSubstrings += nextConsonant[end] - end;
                char startLetter = word.charAt(start);
                if (isVowel(startLetter)) {
                    vowelCount.put(
                            startLetter,
                            vowelCount.get(startLetter) - 1
                    );
                    if (vowelCount.get(startLetter) == 0) {
                        vowelCount.remove(startLetter);
                    }
                } else {
                    consonantCount--;
                }

                start++;
            }
            end++;
        }

        return numValidSubstrings;
    }

    public static long countOfSubstrings(final String word, final int k) {
        final int[] vowels = new int[26];
        int consonantsVowels = 0;
        long substrings = 0;
        int left = 0;
        for(int i = 0; i < word.length(); i++) {
            if(isVowel(word.charAt(i))) {
                vowels[word.charAt(i) - 'a']++;
            } else {
                consonantsVowels++;
                while (consonantsVowels >= k && vowels[0] > 0 && vowels[4] > 0 && vowels[8] > 0 && vowels[14] > 0 && vowels[20] > 0) {
                    if(consonantsVowels == k) {
                        substrings++;
                    }
                    if(isVowel(word.charAt(left))) {
                        vowels[word.charAt(left) - 'a']--;
                    } else {
                        consonantsVowels--;
                    }
                    left++;

                }
            }
        }
        return substrings;
    }

    private static boolean isVowel(final char currChar) {
        return currChar == 'a' || currChar == 'e' || currChar == 'i' || currChar == 'o' || currChar == 'u';
    }
}

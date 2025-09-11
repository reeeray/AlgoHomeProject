package leetcode.strings;

import java.util.*;
import java.util.stream.Collectors;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 11.09.2025
 **/
public class SortVowelsInAString_2785 {

    public static void main(String[] args) {

    }

    public static String sortVowels(final String s) {
        final char[] arr = s.toCharArray();
        final List<Character> vowels = List.of('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');
        final List<Integer> indexes = new ArrayList<>();
        final List<Character> chars = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if(vowels.contains(arr[i])) {
                indexes.add(i);
                chars.add(arr[i]);
            }
        }
        Collections.sort(chars);
        for(int i = 0; i < indexes.size(); i++) {
            arr[indexes.get(i)] = chars.get(i);
        }
        return new String(arr);
     }

    // Returns true if the character is a vowel.
    boolean isVowel(Character c) {
        return c == 'a' || c == 'e' || c == 'o'|| c == 'u'|| c == 'i'
                || c == 'A' || c == 'E' || c == 'O'|| c == 'U'|| c == 'I';
    }

    public String sortVowelsOpt(String s) {
        int[] count = new int[1000];

        // Store the frequencies for each character.
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                count[c - 'A']++;
            }
        }

        // Sorted string having all the vowels.
        String sortedVowel = "AEIOUaeiou";
        StringBuilder ans = new StringBuilder();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!isVowel(s.charAt(i))) {
                ans.append(s.charAt(i));
            } else {
                // Skip to the character which is having remaining count.
                while (count[sortedVowel.charAt(j) - 'A'] == 0) {
                    j++;
                }

                ans.append(sortedVowel.charAt(j));
                count[sortedVowel.charAt(j) - 'A']--;
            }
        }
        return ans.toString();
    }
}

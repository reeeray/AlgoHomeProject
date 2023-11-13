package leetcode.strings;

import java.util.*;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 13.11.2023
 **/
public class SortVowelsInString_2785 {

    public static void main(String[] args) {
        System.out.println(sortVowels("lEetcOde"));
    }

    public static String sortVowels(final String s) {
        final List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y');
        final char[] character = s.toCharArray();
        final List<Integer> indexes = new ArrayList<>();
        final List<Character> characters = new ArrayList<>();
        for(int i=0; i<s.length(); i++) {
            if(vowels.contains(character[i])) {
                indexes.add(i);
                characters.add(character[i]);
            }
        }
        Collections.sort(characters);

        for(int i=0; i<indexes.size(); i++) {
            character[indexes.get(i)] = characters.get(i);
        }
        return new String(character);
    }

    // Returns true if the character is a vowel.
    boolean isVowel(Character c) {
        return c == 'a' || c == 'e' || c == 'o'|| c == 'u'|| c == 'i'
                || c == 'A' || c == 'E' || c == 'O'|| c == 'U'|| c == 'I';
    }

    public String sortVowels2(String s) {
        ArrayList<Character> temp = new ArrayList<>();

        // Store the vowels in the temporary string.
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                temp.add(c);
            }
        }

        // Sort the temporary string characters in ascending order.
        Collections.sort(temp);

        StringBuilder ans = new StringBuilder();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            // If the character is a vowel, replace it with the character in the string temp.
            if (isVowel(s.charAt(i))) {
                ans.append(temp.get(j));
                j++;
            } else {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }

    public String sortVowelsSpaceOptimized(String s) {
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

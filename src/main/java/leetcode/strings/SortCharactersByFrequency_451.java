package leetcode.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 07.02.2024
 **/
public class SortCharactersByFrequency_451 {

    public static void main(String[] args) {
        assert frequencySortEfficient("thee") == "eeht";
    }

    public static String frequencySort(final String s) {
        final Map<Character, Integer> sorted = new HashMap<>();
        for(final char c : s.toCharArray()) {
            sorted.put(c, sorted.getOrDefault(c, 0) + 1);
        }


        final StringBuilder sb = new StringBuilder();
        sorted.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByValue().reversed()).forEach(entry -> {
            for(int i=0; i<entry.getValue(); i++)
                sb.append(entry.getKey());
        });
        return sb.toString();
    }

    public static String frequencySortEfficient(final String s) {
        final int freq[] = new int[125];
        for (char c : s.toCharArray())
            freq[c]++;

        final char output[] = new char[s.length()];

        int pointer = 0;
        int max;
        int index;
        while (pointer < s.length()) {
            max = 0;
            index = -1;
            for (int i = 0; i < freq.length; i++) {
                if (max < freq[i]) {
                    max = freq[i];
                    index = i;
                }
            }
            if (max == 0) {
                return new String(output);
            }
            int temp = max;
            while (temp-- > 0)
                output[pointer++] = (char) index;

            freq[index] = 0;
        }


        return new String(output);
    }
}

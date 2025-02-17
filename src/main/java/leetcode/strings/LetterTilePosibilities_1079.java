package leetcode.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 17.02.2025
 **/
public class LetterTilePosibilities_1079 {

    public static void main(String[] args) {

    }

    //Space O(1) and Time O(n!)
    public static int numTilePossibilities(final String tiles) {
        final int[] freq = new int[26];
        for(final char c : tiles.toCharArray()) {
            freq[c - 'A']++;
        }
        return dfs(freq);
    }

    private static int dfs(final int[] freq) {
        int count = 0;

        for(int i = 0; i < 26; i++) {
            if(freq[i] != 0) {
                freq[i]--;
                count += dfs(freq) + 1;
                freq[i]++;
            }
        }
        return count;
    }

    //Time O(n * n!) and Space O(n*n!)
    public int numTilePossibilitiesBruteForce(String tiles) {
        Set<String> sequences = new HashSet<>();
        int len = tiles.length();
        boolean[] used = new boolean[len];

        // Generate all possible sequences including empty string
        generateSequences(tiles, "", used, sequences);

        // Subtract 1 to exclude empty string from count
        return sequences.size() - 1;
    }

    public void generateSequences(
            String tiles,
            String current,
            boolean[] used,
            Set<String> sequences
    ) {
        // Add current sequence to set
        sequences.add(current);

        // Try adding each unused character to current sequence
        for (int pos = 0; pos < tiles.length(); pos++) {
            if (!used[pos]) {
                used[pos] = true;
                generateSequences(
                        tiles,
                        current + tiles.charAt(pos),
                        used,
                        sequences
                );
                used[pos] = false;
            }
        }
    }
}

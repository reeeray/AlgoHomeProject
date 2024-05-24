package leetcode.backtracking;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 24.05.2024
 **/
public class MaxScoreWordsFormedByLetters_1255 {

    public static void main(String[] args) {

    }

    private int maxScore;
    private int[] freq;

    //Space O(woeds.length + 26) Time O((word.len + 26)2^words.length)
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        final int wordsNum = words.length;
        freq = new int[26];
        for (char c: letters) {
            freq[c - 'a']++;
        }
        maxScore = 0;
        check(wordsNum - 1, words, score, new int[26], 0);
        return maxScore;
    }

    private void check(final int wordsLeft, final String[] words, final int[] score,
                       final int[] subsetLetters, int totalScore) {
        if (wordsLeft == -1) {
            maxScore = Math.max(maxScore, totalScore);
            return;
        }
        check(wordsLeft - 1, words, score, subsetLetters, totalScore);

        for (int i = 0; i < words[wordsLeft].length(); i++) {
            int c = words[wordsLeft].charAt(i) - 'a';
            subsetLetters[c]++;
            totalScore += score[c];
        }

        if (isValidWord(subsetLetters)) {
            check(wordsLeft - 1, words, score, subsetLetters, totalScore);
        }

        for (int i = 0; i < words[wordsLeft].length(); i++) {
            int c = words[wordsLeft].charAt(i) - 'a';
            subsetLetters[c]--;
            totalScore -= score[c];
        }
    }


    private boolean isValidWord(final int[] subsetLetters) {
        for (int c = 0; c < 26; c++) {
            if (freq[c] < subsetLetters[c]) {
                return false;
            }
        }
        return true;
    }
}

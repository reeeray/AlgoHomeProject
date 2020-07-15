package coursera.strings;

/**
 * Boyer-Moore algorithm of finding substring based on comparison of pattern from the end and skipping mismatched sybmbols
 * Average : N/M
 * Worst case : M*N
 * User : Shein G.A.{@reeeray}
 * Date : 12.07.2020
 **/
public class BoyerMoore {

    private static final int Radix = 256;
    private final String pattern;
    private final int M;
    private final int[] right;

    public BoyerMoore(final String pattern) {
        right = new int[Radix];
        this.pattern = pattern;
        this.M = pattern.length();
        for (int c = 0; c < Radix; c++)
            right[c] = -1;
        for (int j = 0; j < M; j++)
            right[pattern.charAt(j)] = j;
    }

    public int search(final String text) {
        final int N = text.length();
        int skip;
        for (int i = 0; i < N - M; i += skip) {
            skip = 0;
            for (int j = M - 1; j >= 0; j--) {
                if (pattern.charAt(j) != text.charAt(i + j)) {
                    skip = Math.max(1, j - right[text.charAt(i + j)]);
                    break;//in case other term is nonpositive
                }
            }
            if (skip == 0) return i; //match
        }
        return N;
    }
}

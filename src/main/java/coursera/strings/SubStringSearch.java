package coursera.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 12.07.2020
 **/
public class SubStringSearch {

    private final int[][] dfa;
    private final String pattern;
    private final int Radix = 256;
    private final int M;

    //Time M*R, much memory(R*M)
    public SubStringSearch(final String pattern) {
        this.pattern = pattern;
        this.M = pattern.length();
        this.dfa = new int[Radix][M];
        dfa[pattern.charAt(0)][0] = 1;
        for (int X = 0, j = 1; j < M; j++) {
            for (int c = 0; c < Radix; c++)
                dfa[c][j] = dfa[c][X]; //copy mismatch cases
            dfa[pattern.charAt(j)][j] = j + 1;//set match case
            X = dfa[pattern.charAt(j)][X]; //update restart case

        }
    }

    /**
     * Worst case : M*N
     *
     * @param pattern
     * @param text
     * @return
     */
    public static int bruteForce(final String pattern, final String text) {
        final int N = text.length();
        final int M = pattern.length();

        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (text.charAt(i + j) != pattern.charAt(j))
                    break;
            }
            if (j == M) return i;
        }
        return N;//not found
    }

    /**
     * Knuth-Morris-Pratt Algorithm of finding substring based on DFA(determenistic
     * Time ~N
     *
     * @return
     */
    public int search(final String txt) {
        int i, j, N = txt.length();
        for (i = 0, j = 0; i < N && j < M; i++)
            j = dfa[txt.charAt(i)][j];
        if (j == M) return i - M;
        else return N;
    }

}

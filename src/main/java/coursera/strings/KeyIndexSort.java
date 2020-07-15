package coursera.strings;

/**
 * Key Index Sort of String
 * If it is repeats of string(chars) it sorts it
 * Time : N + R (N - number of symbols in your String, R - number of symbols in your system 256(8bit))
 * User : Shein G.A.{@reeeray}
 * Date : 04.07.2020
 **/
public class KeyIndexSort {

    public static void sort(int[] sequence, final int R) {
        final int N = sequence.length;
        final int[] count = new int[R + 1];
        final int[] auxiliary = new int[N];

        for (int i = 0; i < N; i++)
            count[sequence[i] + 1]++;
        //compute cumulates
        for (int i = 1; i <= R; i++)
            count[i] += count[i - 1];

        for (int i = 0; i < N; i++) {
            int index = count[sequence[i]]++;
            auxiliary[index] = sequence[i];
        }

        for (int i = 0; i < N; i++)
            sequence[i] = auxiliary[i];

    }
}

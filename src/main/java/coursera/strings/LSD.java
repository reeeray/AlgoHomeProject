package coursera.strings;

/**
 * Least Significant Digit algorithm for sorting Strings.
 * <p>
 * guarantee    random     extra space  stable?
 * 2*W*N        2*W*N         N + R      YES
 * User : Shein G.A.{@reeeray}
 * Date : 05.07.2020
 **/
public class LSD {

    public void sort(String[] a, final int W) {
        final int R = 256;
        final int N = a.length;
        final String[] aux = new String[N];

        for (int v = W - 1; v >= 0; v--) {
            final int[] counter = new int[R + 1];
            for (int i = 0; i < N; i++)
                counter[a[i].charAt(v) + 1]++;
            for (int i = 1; i <= R; i++)
                counter[i] += counter[i - 1];
            for (int i = 0; i < N; i++)
                aux[counter[a[i].charAt(v)]++] = a[i];
            for (int i = 0; i < N; i++)
                a[i] = aux[i];
        }
    }
}

package coursera.strings;

/**
 * Most Significant Digit string sort. Sort by moving left to right.
 * guarantee    random     extra space  stable?
 * 2*W*N        2*(Log(R)N)         N + DR      YES
 * D - depth of longest prefix
 * Disadvantages :
 * - Is cache-inefficient
 * -Too much memory storing count[]
 * -Too much overhead reinitializing count[] and aux[].
 * User : Shein G.A.{@reeeray}
 * Date : 05.07.2020
 **/
public class MSD {

    private static final int Radix = 256;//ASCII (Unicode 65,536(2^16))

    public static void sort(final String[] a) {
        final String[] aux = new String[a.length];
        sort(a, aux, 0, a.length - 1, 0);
    }

    private static void sort(final String[] a, final String[] aux, final int subStart, final int subEnd, final int level) {
        final int N = a.length;
        if (subEnd <= subStart)
            return;
        final int[] counter = new int[Radix + 2];
        for (int i = subStart; i <= subEnd; i++)
            counter[charAt(a[i], level) + 2]++;
        for (int i = 1; i < Radix + 2; i++)
            counter[i] += counter[i - 1];
        for (int i = subStart; i <= subEnd; i++)
            aux[counter[charAt(a[i], level) + 1]++] = a[i];
        for (int i = subStart; i <= subEnd; i++)
            a[i] = aux[i - subStart];
        for (int i = 0; i < Radix; i++)
            sort(a, aux, subStart + counter[i], subStart + counter[i + 1] - 1, level + 1);
    }

    static int charAt(final String str, final int level) {
        if (level < str.length())
            return str.charAt(level);
        else
            return -1;
    }
}

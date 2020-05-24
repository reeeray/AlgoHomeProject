package books;

/**
 * User : gshein
 * Date : 24.05.2020
 **/
public class Util {

    public static boolean less(final Comparable a, final Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void exchange(final Comparable[] array, final int to, final int from) {
        final Comparable min = array[from];
        array[from] = array[to];
        array[to] = min;
    }
}

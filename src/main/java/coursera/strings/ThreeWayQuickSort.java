package coursera.strings;

/**
 * 3-way string quick-sort algorithm which combines benefits of quick sort and MSD.
 * Uses ~2NlgN CHARACTER compares instead of usual quicksort Uses ~2NlgN STRING compares
 * Advantages :
 * -Has a short inner loop.
 * -Is cache-friendly
 * -Is in-place.
 * guarantee    random     extra space  stable?
 * 1.39WNlgN    1.39NlgN   logN + W      NO
 * User : Shein G.A.{@reeeray}
 * Date : 05.07.2020
 **/
public class ThreeWayQuickSort {

    private static void sort(final String[] a) {
        sort(a, 0, a.length - 1, 0);
    }

    private static void sort(final String[] a, int lo, int hi, int level) {
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        int v = MSD.charAt(a[lo], level);
        int i = lo + 1;
        while (i < gt) {
            int t = MSD.charAt(a[i], level);
            if (t < v) swap(a, lt++, i++);
            else if (t > v) swap(a, i, gt--);
            else i++;
        }

        sort(a, lo, lt - 1, level); //sort first part (which less than symbol)
        if (v >= 0) sort(a, lt, gt, level); //sort middle layer
        sort(a, gt + 1, hi, level); //sort third level
    }

    private static void swap(final String[] a, int from, int to) {
        final String was = a[from];
        a[from] = a[to];
        a[to] = was;
    }
}

package books;

import java.util.Arrays;

/**
 * Selection sort
 * Costs :(N-1) + (N-2) +.....+ 1 + 0 = (N^2)/2 compares and N exchanges
 *
 * Note!!! Quadratic time even if it is sorted
 * User : gshein
 * Date : 24.05.2020
 **/
public class SelectionSort {

    public static void sort(final Comparable[] array) {
        final int N = array.length;
        for(int i = 0; i < N; i++) {
            int min = i;
            for (int j = min + 1; j < N; j++) {
                if(Util.less(array[j], array[min]))
                    min = j;
            }
            Util.exchange(array, i, min);
        }
    }

    public static void main(String[] args) {
        final Integer[] array = new Integer[] {4, 13, 1, 6, 9, 7, 2, 11};

        sort(array);
        System.out.println(Arrays.toString(array));
    }
}

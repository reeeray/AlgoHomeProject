package books;

import java.util.Arrays;

/**
 * Bubble sort
 *
 * N^2 complexity
 * User : gshein
 * Date : 24.05.2020
 **/
public class BubbleSort {

    public static void sort (final Comparable[] array) {

        final int N = array.length;

        for(int i = 0; i < N - 1; i++) {
            for(int j = 0; j < N - i - 1; j++)
                if(Util.less(array[j + 1], array[j]))
                    Util.exchange(array, j, j + 1);
        }

    }

    public static void main(String[] args) {
        final Integer[] array = new Integer[] {4, 13, 1, 6, 9, 7, 2, 11};

        sort(array);
        System.out.println(Arrays.toString(array));
    }


}

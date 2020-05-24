package books;

import java.util.Arrays;

/**
 * Insertion Sort!
 * Costs :(N^2)/4 compares and (N^2)/4 exchanges
 * Note!!!! Insertion sort does depend on the initial data.
 * Best case : if array already sorted insertion sort just does compares without exchanges. So it's N-1 complexity
 * Worst case : if the array sorted in descending order then it should exchange for the whole path : (N^2)/2 compares and (N^2)/2 exchanges
 * Middle : for partially sorted array it takes linear time : N
 * User : gshein
 * Date : 24.05.2020
 **/
public class InsertionSort {

    public static void sort(final Comparable[] array) {
        final int N = array.length;

        for(int i = 0; i < N; i++) {
            for(int j = i; j > 0; j--) {
                if(Util.less(array[j], array[j - 1]))
                    Util.exchange(array, j-1, j);
                else
                    break;
            }
        }
    }


    public static void main(String[] args) {
        final Integer[] array = new Integer[] {4, 13, 1, 6, 9, 7, 2, 11};

        sort(array);
        System.out.println(Arrays.toString(array));
    }

}

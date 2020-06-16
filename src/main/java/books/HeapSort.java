package books;

import static books.Util.less;

/**
 * Basic of the Heap sort is using binary tree
 * it takes : heap construction : 2*N and heap sort uses : 2*N*logN compares and changes
 * In place sort and guarantee linearifmic time
 * Pitfalls:
 * -inner loop longer than quicksort's
 * - makes poor use of cache memory (doesn't use local memory where parts are nearly located)
 * (ссылки на память оказываются рассогласованными, распределенными по всей памяти для массивов огромного размера, то есть
 * это плохой алгоритм для ситуаций, где присутствует кэширование, а оно сейчас повсеместно. Не обладает свойством
 * local memories references.
 * - Nonstable
 * User : Shein G.A.{@reeeray}
 * Date : 31.05.2020
 **/
public class HeapSort {

    public static void sort(final Comparable[] pq) {
        int N = pq.length;
        for (int k = N / 2; k >= 1; k--) {
            sink(pq, k, N);
        }

        while (N > 1) {
            exchange(pq, 1, N);
            sink(pq, 1, --N);
        }
    }

    /**
     * Exchange key in parent node with a larger child.
     * Repeat untill heap order restored.
     */
    private static void sink(final Comparable[] array, int k, final int size) {
        while (2 * k <= size) { //children of node k are 2*k and 2*k + 1
            int j = 2 * k;
            if (j < size && less(array[j], array[j + 1])) j++;
            if (!less(array[k], array[j])) break;
            exchange(array, k, j);
            k = j;
        }
    }

    private static void exchange(final Comparable[] array, final int index1, final int index2) {
        final Comparable item = array[index1];
        array[index1] = array[index2];
        array[index2] = item;
    }
}

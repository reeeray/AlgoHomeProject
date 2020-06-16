package coursera.sort_algorithms;

import books.InsertionSort;
import books.Util;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Quick Sort Algorithm. One of the most important algorithm of 20th century.
 * As a mergesort also recursive but MergeSort is a merging sort which used recursion before. And QuickSort uses recursion after.
 *
 * It takes in average : 1,39*N*log(N) time (actually a bit faster than mergeSort).
 * Worst case (when array is already sorted) : 1/2 * N^2.
 *
 * In place sort, doesn't use any extra space.
 * Quick sort is not stable because while partitioning it can be changed elements with the same values
 *
 * Note : Standard implementation of Quick Sort depends if it has duplicate keys, than it will be quadratic time. But we can do
 * improvement in partitioning part in this case.
 *
 * Quicksort is in-place and is typically the fastest general-purpose sorting algorithm in practice.
 * User : gshein
 * Date : 22.05.2020
 **/
public class QuickSort {

    public static final int CUTOFF = 10; //

    public static void sort(final Comparable[] array) {
        StdRandom.shuffle(array);//shuffle needed for performance guarantee
        sort(array, 0, array.length - 1);

    }

    public static void sort(final Comparable[] array, final int left, final int right) {
//        if (right <= left) return; //even quicksort has too much overhead for tiny subarrays. It can improve on 20%
        if (right <= left + CUTOFF - 1) {
            InsertionSort.sort(array);
            return;
        }
        final int j = partitioning(array, left, right);
        sort(array, left, j - 1);
        sort(array, j + 1, right);
    }

    //in average linearifmic time
    public static Comparable select(final Comparable[] array, final int k) {
        StdRandom.shuffle(array);
        int low = 0, high = array.length - 1;
        while (high > low) {
            final int j = partitioning(array, low, high);
            if (k > j)
                low = j + 1;
            else if (k < j)
                high = j - 1;
            else return array[k];
        }
        return array[k];
    }

    private static int partitioning(final Comparable[] array, final int left, final int right) {
        int i = left, j = right + 1;
        while (true) {
            while (Util.less(array[i++], array[left])) //find item on left part to swap
                if (i == right) break;

            while (Util.less(array[left], array[--j])) //find item on right part to swap
                if (j == left) break;

            if (i >= j) break; //check if pointers cresses
            swap(array, i, j);
        }
        swap(array, left, j);
        return j;
    }

    //Dijkstra 3ways partitioning(it works in case of duplicates)
    //best case N(linear, worst case linearifmic
    private static void sort3waysPart(final Comparable[] array, final int left, final int right) {
        if (right <= left) return;
        int lt = left, rt = right;
        final Comparable val = array[left];
        int i = left;
        while (left <= right) {
            final int comp = array[i].compareTo(val);
            if (comp < 0) swap(array, lt++, i++);
            else if (comp > 0) swap(array, i, rt--);
            else i++;
        }
        sort(array, left, lt - 1);
        sort(array, right + 1, right);

    }

    private static void swap(final Comparable[] array, final int left, final int right) {
        final Comparable element = array[left];

        array[left] = array[right];
        array[right] = element;
    }
}

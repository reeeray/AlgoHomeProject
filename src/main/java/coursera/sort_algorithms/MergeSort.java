package coursera.sort_algorithms;

import edu.princeton.cs.algs4.Insertion;

/**
 * It's an example of approach which called Divide and Concur. The sense is that you are dividing the problem and than merging
 * the solutions of small problems into solution of big problem.
 *
 * Merge sort takes N*log(N) time
 *
 * It doesn't matter if keys has duplicates. It's always between 1/2N*lgN and N*lgN
 *
 * Why does Arrays.sort() in Java use mergesort instead of quicksort when sorting reference types ?
 *
 * The Java API for Arrays.sort() for reference types requires that it is stable and guarantees nlogn performance.
 * Neither of these are properties of standard quicksort.
 *
 * Quicksort uses less memory and is faster in practice on typical inputs (and is typically used by
 * Arrays.sort() when sorting primitive types, where stability is not relevant).
 */
public class MergeSort {

    private static final int CUTOFF = 7;

    private static void merge (final Comparable[] a, final Comparable[] aux, final int lo, final int mid, final int hi) {
        assert isSorted(a, lo, mid) : "first subarray is not sorted!";

        assert isSorted(a, mid + 1, hi) : "second subarray is not sorted";

        //copy
        for (int k = lo; k<= hi; k++)
            aux[k] = a[k];

        //merge
        int i = lo, j = mid + 1;

        for(int k = lo; k <= hi; k++) {
            if(i > mid) a[k] = a[j++];
            else if (j > hi) a[k] = a[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = a[i++];
        }

        assert isSorted(a, lo, hi) : "array is not sorted";
    }

    private static void sort(final Comparable[] a, final Comparable[] aux, final int lo, final int hi) {
//        if(hi <= lo) return;
        //speed up improvement. CUTOFF ~ 7 items. There is no sense in recursions with small arrays,
        // it works good insertions sort with small arrays
        if(hi <= lo + CUTOFF + 1) {
            Insertion.sort(a, lo, hi);
            return;

        }
        int mid = lo + (hi - lo)/2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        //speed up. Stop if already sorted
        if(!less(a[mid+1], a[mid])) return;
        merge(a, aux, lo, mid, hi);
    }

    //bottom-up mergesort needed log(N) times
    //and N times of comparison elements
    //In total it's N*log(N)
    private static void sort(final Comparable[] a) {
        final int N = a.length;
        final Comparable[] aux = new Comparable[N];
        for(int sz = 1; sz<N; sz+=sz) {
            for(int lo = 0; lo < N - lo; lo+=sz+sz) {
                merge(a, aux, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
            }
        }
    }

    private static boolean less(final Comparable a, final Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static boolean isSorted(final Comparable[] array, final int start, final int end) {
        for(int i=start+1; i<end; i++) {
            if(less(array[i], array[i-1]))
                return false;
        }
        return true;
    }
}

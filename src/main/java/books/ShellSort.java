package books;

/**
 * Shell algorithm.
 * Note!!! It is still open issue about model
 * worst case O(n^3/2) for Knuth model 3*x + 1
 *  Best case : N*log(N)
 *  Получается, что мы сначала делает массив частично отсортированным, а затем используем insertion sort
 * User : gshein
 * Date : 24.05.2020
 **/
public class ShellSort {

    public static void sort(final Comparable[] array) {
        int N = array.length;

        int h = 1;
        while (h < N / 3) h = 3 * h + 1; //Knuth suggestion

        while ( h>= 1) { //h-sort of the array
            for(int i = h; i < N; i++) {
                for(int j = i; j >= h && Util.less(array[j], array[j - h]); j -= h)
                    Util.exchange(array, j, j - h);
            }
            h = h / 3;
        }
    }
}

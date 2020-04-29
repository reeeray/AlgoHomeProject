package books;

import java.util.Arrays;

/**
 * Created by Shein G.A. at 28.04.20
 **/
public class BinarySearchAlgorithm {

    //O(log(n))
    public static int binarySearch(final int[] array, final int key) {
        int first = 0;
        int end = array.length - 1;
        int middle;

        while(first<= end) {
            middle = first + (end - first) / 2;

            if(key < array[middle]) {
                end = middle - 1;
            } else if (key > array[middle]) {
                first = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    //the same through the recursion
    public static int binarySearchRecusrsion(final int[] array, final int key, final int start, final int end) {
        int middle = start + (end - start) / 2;

        if(start > end) {
            return -1;
        }
        if(key > array[middle]) {
            return binarySearchRecusrsion(array, key, middle + 1, end);
        } else if (key < array[middle]) {
            return binarySearchRecusrsion(array, key, start, middle - 1);
        }else {
            return middle;
        }
    }
}

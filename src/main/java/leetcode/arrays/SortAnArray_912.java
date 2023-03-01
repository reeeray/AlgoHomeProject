package leetcode.arrays;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 01.03.2023
 **/
public class SortAnArray_912 {

    public static void main(String[] args) {
        final int[] toSort = {5, 1, 1, 2, 0, 0};

        System.out.println(Arrays.toString(mergeSort(toSort)));
    }

    public static int[] mergeSort(final int[] array) {
        final int p = 0, r = array.length - 1;
        if(p >= r) {
            return array;
        }

        final int q = (p + r)/2;
        final int[] sortedSubArr1 = mergeSort(Arrays.copyOfRange(array, p, q+1));
        final int[] sortedSubArr2 = mergeSort(Arrays.copyOfRange(array, q+1, r+1));
        return merge(sortedSubArr1, sortedSubArr2);
    }

    public static int[] merge(final int[] arr1, final int[] arr2) {
        final int[] arr = new int[arr1.length + arr2.length];
        int p1 = 0;
        int p2 = 0;
        for(int i=0; i<arr.length; i++) {
            if(p1 < arr1.length && p2 < arr2.length) {
                if(arr1[p1] < arr2[p2]) {
                    arr[i] = arr1[p1++];
                } else {
                    arr[i] = arr2[p2++];
                }
            } else {
                if(p1 >= arr1.length) {
                    System.arraycopy(arr2, p2, arr, i, arr2.length - p2);
                    break;
                } else {
                    System.arraycopy(arr1, p1, arr, i, arr1.length - p1);
                    break;
                }
            }
        }
        return arr;
    }


}

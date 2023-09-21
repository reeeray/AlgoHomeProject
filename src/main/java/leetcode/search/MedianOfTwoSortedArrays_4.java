package leetcode.search;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 21.09.2023
 **/
public class MedianOfTwoSortedArrays_4 {

    private static int p1, p2;

    public static void main(String[] args) {

    }

    public static double finadMedianSortedArrays(final int[] array1, final int[] array2) {
        final int m = array1.length;
        final int n = array2.length;
        p1 = 0;
        p2 = 0;

        if((m + n) % 2 == 0) {
            for(int i=0; i< (m+n)/2 - 1; i++) {
                getMinAndMove(array1, array2);
            }
            return (double)(getMinAndMove(array1, array2) + getMinAndMove(array1, array2))/2;
        } else {
            for(int i=0; i<(m+n)/2; i++) {
                getMinAndMove(array1, array2);
            }
            return getMinAndMove(array1, array2);
        }
    }

    private static int getMinAndMove(final int[] arr1, final int[] arr2) {
        if(p1 < arr1.length && p2 < arr2.length) {
            return arr1[p1] < arr2[p2] ? arr1[p1++] : arr2[p2++];
        } else if(p1 < arr1.length) {
            return arr1[p1++];
        } else if(p2 < arr2.length){
            return arr2[p2++];
        }
        return -1;
    }
}

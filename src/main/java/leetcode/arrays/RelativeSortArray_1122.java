package leetcode.arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 11.06.2024
 **/
public class RelativeSortArray_1122 {

    public static void main(String[] args) {

    }

    //Let's assume k - is max element - > Time O(n + m + k) and Space O(k)
    public static int[] relativeSortArray(final int[] arr1, final int[] arr2) {
        final int[] freq = new int[1001];
        for(int val : arr1) {
            freq[val]++;
        }
        int index = 0;
        for(int val : arr2) {
            while(freq[val]-- > 0) {
                arr1[index++] = val;
            }
        }
        for(int i=0; i<1001; i++) {
            while(freq[i]-- > 0) {
                arr1[index++] = i;
            }
        }
        return arr1;
    }
}

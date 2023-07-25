package leetcode.arrays.binarySearch;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 25.07.2023
 **/
public class PeakIndexInAMountainArray_852 {

    public static void main(String[] args) {
        peakIndexInMountainArray(new int[]{0, 1, 0});
    }

    public static int peakIndexInMountainArray(final int[] arr) {
        int left = 0, right = arr.length - 1, mid;
        while (left < right) {
            mid = (right + left) / 2;
            if(arr[mid + 1] < arr[mid] && arr[mid - 1] < arr[mid]) {
                return mid;
            } else if (arr[mid + 1] > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

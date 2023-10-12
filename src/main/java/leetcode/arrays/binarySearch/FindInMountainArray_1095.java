package leetcode.arrays.binarySearch;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 12.10.2023
 **/
public class FindInMountainArray_1095 {

    public static void main(String[] args) {

    }

    // Space O(1) and Time 4log2(n)
    //Could be a bit improved in terms of number of interface calls by Hashing the previous calls and checking it before actual interface call
    private static int findInMountainArray(final int target, final MountainArray mountainArray) {
        final int n = mountainArray.length();
        int left = 1;
        int right = n - 2;
        while (left != right) {
            final int mid = (left + right) / 2;
            if(mountainArray.get(mid) > mountainArray.get(mid + 1)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        final int peak = left;

        left = 0;
        right = peak;
        while (left != right) {
            final int mid = (left + right) / 2;

            if(target > mountainArray.get(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if(target == mountainArray.get(left)) {
            return left;
        }

        left = peak + 1;
        right = n - 1;
        while (left != right) {
            final int mid = (left + right) / 2;
            if(target < mountainArray.get(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if(target == mountainArray.get(left)) {
            return left;
        }
        return -1;
    }

    private interface MountainArray {
        int get(final int index);
        int length();
    }
}

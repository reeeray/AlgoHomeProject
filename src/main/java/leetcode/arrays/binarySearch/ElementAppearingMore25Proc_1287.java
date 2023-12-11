package leetcode.arrays.binarySearch;

import patterns.functional.predicate.Predicate;

import java.util.function.BiPredicate;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 11.12.2023
 **/
public class ElementAppearingMore25Proc_1287 {

    public static void main(String[] args) {

    }

    public int findSpecialInteger(final int[] arr) {
        final int window = arr.length / 4;
        for(int i=0; i<arr.length-window; i++) {
            if(arr[i] == arr[i+window]) {
                return arr[i];
            }
        }
        return -1;
    }

    public int findSpecialIntegerBS(final int[] arr) {
        final int n = arr.length;
        final int window  = n / 4;

        for (int i=1; i<4; i++) {
            final int val = i * window;
            int left = findBound(arr, (v) -> v >= val);
            int right = findBound(arr, (v) -> v > val) - 1;
            if (right - left + 1 > window) {
                return val;
            }
        }

        return -1;
    }

    public int findBound(final int[] arr, final Predicate<Integer> toRight) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (toRight.test(arr[mid])) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

//    public int findSpecialInteger(int[] arr) {
//        int n = arr.length;
//        int[] candidates = {arr[n / 4], arr[n / 2], arr[3 * n / 4]};
//        int target = n / 4;
//
//        for (int candidate : candidates) {
//            int left = lower_bound(arr, candidate);
//            int right = upper_bound(arr, candidate) - 1;
//            if (right - left + 1 > target) {
//                return candidate;
//            }
//        }
//
//        return -1;
//    }
//
//    public int upper_bound(int[] arr, int target) {
//        int left = 0;
//        int right = arr.length;
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (arr[mid] > target) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//
//        return left;
//    }
//
//    public int lower_bound(int[] arr, int target) {
//        int left = 0;
//        int right = arr.length;
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (arr[mid] >= target) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//
//        return left;
//    }
}

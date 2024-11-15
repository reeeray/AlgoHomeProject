package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 15.11.2024
 **/
public class ShortestSubarrayToBeRemovedToMakeArraySorted_1574 {

    public static void main(String[] args) {
        final int[] input = new int[] {1, 2, 3, 10, 4, 2, 3, 5};
        final int[] input2 = new int[] {5, 4, 3, 2, 1};
        findLengthOfShortestSubarrayWorkingVersion(input);
    }

    //Time O(n) and Space O(1)
    public static int findLengthOfShortestSubarrayWorkingVersion(int[] arr) {
        int right = arr.length - 1;
        while (right > 0 && arr[right] >= arr[right - 1]){
            right--;
        }
        int ans = right;
        int left = 0;
        while (left < right && (left == 0 || arr[left - 1] <= arr[left])) {
            while (right < arr.length && arr[left] > arr[right]) {
                right++;
            }
            ans = Math.min(ans, right - left - 1);
            left++;
        }
        return ans;
    }

    //not working attempt
    public static int findLengthOfShortestSubarray(final int[] array) {
        int left = 1;
        int right = array.length - 2;
        while (left < array.length && array[left] >= array[left - 1]) {
            left++;
        }
        if(left == array.length) {
            return 0;
        }
        while (right > -1 && array[right] <= array[right + 1]) {
            right--;
        }
        while (left >= 0 && right < array.length && (left == right || array[left] > array[right])) {
            if((right == array.length - 1) || (left > 0 && array[left] - array[left - 1] >= array[right + 1] - array[right])) {
                left--;
            } else {
                right++;
            }
        }
        if(left < 0) {
            return right;
        } else if (right > array.length) {
            return left;
        }
        return right - left - 1;
    }
}

package leetcode.arrays.binarySearch;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 09.06.2023
 **/
public class FindTheSmallestLetterGreaterThanTarget_744 {

    public static void main(String[] args) {
        nextGreatestLetterBS(new char[]{'c', 'f', 'j'}, 'j');
    }

    public char nextGreatestLetter(final char[] letters, final char target) {
        final int n = letters.length;
        for(int i=0; i<n; i++) {
            if(letters[i] > target) {
                return letters[i];
            }
        }
        return letters[0];
    }

    public static char nextGreatestLetterBS(final char[] letters, final char target) {
        final int n = letters.length;
        int left = 0;
        int right = letters.length-1;
        while (left <= right) {
            int mid = (right + left) / 2; // >>> 1
            if(target < letters[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return letters[left % n];
    }
}

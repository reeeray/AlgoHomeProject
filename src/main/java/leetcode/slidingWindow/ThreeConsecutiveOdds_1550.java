package leetcode.slidingWindow;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 01.07.2024
 **/
public class ThreeConsecutiveOdds_1550 {

    public static void main(String[] args) {

    }

    //Space O(1) and Time O(n)
    public boolean threeConsecutiveOdds(final int[] arr) {
        int leftIndex = 0;
        int rightIndex = 0;
        for(int i=0; i<arr.length-2; i++) {
            if(arr[i] % 2 == 1) {
                leftIndex = i;
                rightIndex = leftIndex + 1;
                while (arr[rightIndex++] % 2 == 1) {
                    if(rightIndex - leftIndex == 3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

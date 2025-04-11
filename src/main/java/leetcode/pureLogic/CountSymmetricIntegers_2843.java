package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 11.04.2025
 **/
public class CountSymmetricIntegers_2843 {

    public static void main(String[] args) {

    }

    //Time O(high - low) and Space O(1)
    public static int countSymmetricIntegers(final int low, final int high) {
        int count = 0;
        for (int num = low; num <= high; num++) {
            if (num < 100 && num % 11 == 0) {
                count++;
            } else if (1000 <= num && num < 10000) {
                int left = num / 1000 + (num % 1000) / 100;
                int right = (num % 100) / 10 + (num % 10);
                if (left == right) {
                    count++;
                }
            }
        }
        return count;
    }
}

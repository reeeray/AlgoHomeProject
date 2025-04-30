package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 30.04.2025
 **/
public class FindNumbersWithEvenNumberOfDigits_1295 {

    public static void main(String[] args) {

    }

    //Time O(n*logM) and Space O(logM) where M is the length of the longest digit
    public static int findNumbers(final int[] nums) {
        int count = 0;
        for(final int num : nums) {
            final String representation = "" + num;
            if(representation.length() % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    private boolean hasEvenDigits(int num) {
        int digitCount = 0;
        while (num != 0) {
            digitCount++;
            num /= 10;
        }
        return (digitCount & 1) == 0;
    }

    public int findNumbersCounting(int[] nums) {
        // Counter to count the number of even digit integers
        int evenDigitCount = 0;

        for (int num : nums) {
            if (hasEvenDigits(num))
                evenDigitCount++;
        }

        return evenDigitCount;
    }

    public int findNumbersLogarithm(int[] nums) {
        // Counter to count the number of even digit integers
        int evenDigitCount = 0;

        for (int num : nums) {
            // Compute the number of digits in the num
            int digitCount = (int) Math.floor(Math.log10(num)) + 1;
            if (digitCount % 2 == 0)
                evenDigitCount++;
        }

        return evenDigitCount;
    }

    //Based on constraints Time O(n) and Space O(1)
    public int findNumbersOpt(final int[] nums) {
        // Counter to count the number of even digit integers
        int evenDigitCount = 0;

        for (int num : nums) {
            if ((num >= 10 && num < 100) || (num >= 1000 && num < 10000) || num == 100000)
                evenDigitCount++;
        }

        return evenDigitCount;
    }
}

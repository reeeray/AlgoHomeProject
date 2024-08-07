package leetcode.pureLogic;

import java.util.Arrays;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 07.08.2024
 **/
public class IntegerToEnglishWords_273 {

    private static final String[] ONES = {"Zero ", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine "};
    private static final String[] TENS = {"", "", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
    private static final String[] TEENS = {"Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};

    public static void main(String[] args) {

    }

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        final StringBuilder sb = new StringBuilder();
        if (num >= 1_000_000_000) {
            sb.append(numberToWords(num / 1_000_000_000));
            sb.append(" Billion ");
            num %= 1_000_000_000;
        }
        if (num >= 1_000_000) {
            sb.append(numberToWords(num / 1_000_000));
            sb.append(" Million ");
            num %= 1_000_000;
        }
        if (num >= 1_000) {
            sb.append(numberToWords(num / 1_000));
            sb.append(" Thousand ");
            num %= 1_000;
        }
        if (num >= 100) {
            sb.append(ONES[num / 100]);
            sb.append("Hundred ");
            num %= 100;
        }
        if (num >= 20) {
            sb.append(TENS[num / 10]);
            num %= 10;
        } else if (num >= 10) {
            sb.append(TEENS[num - 10]);
            num = 0;
        }
        if (num > 0) {
            sb.append(ONES[num]);
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    //Time O(log10 n) and Space O(1)
    public static String numberToWordsIterative(int num) {
        if(num == 0) {
            return "Zero";
        }

        final String[] ONES = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen",
                "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        final String[] TENS = new String[] {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        final String[] TEENS = new String[] {"", "Thousand", "Million", "Billion"};

        final StringBuilder sb = new StringBuilder();
        int group = 0;

        while(num > 0) {

            if(num % 1000 != 0) {
                final StringBuilder groupSb = new StringBuilder();
                int left = num % 1000;

                //handle hundreds
                if(left >= 100) {
                    groupSb.append(ONES[left / 100]).append(" Hundred ");
                    left %= 100;
                }

                //handel tens
                if(left >= 20) {
                    groupSb.append(TENS[left / 10]).append(" ");
                    left %= 10;
                }

                if(left > 0) {
                    groupSb.append(ONES[left]).append(" ");
                }

                //append scale
                groupSb.append(TEENS[group]).append(" ");
                sb.insert(0, groupSb);
            }

            num/=1000;
            group++;

        }
        return sb.toString().trim();

    }

    // List to store words for numbers
    private static final List<NumberWord> numberToWordsList = Arrays.asList(
            new NumberWord(1000000000, "Billion"), new NumberWord(1000000, "Million"),
            new NumberWord(1000, "Thousand"), new NumberWord(100, "Hundred"),
            new NumberWord(90, "Ninety"), new NumberWord(80, "Eighty"),
            new NumberWord(70, "Seventy"), new NumberWord(60, "Sixty"),
            new NumberWord(50, "Fifty"), new NumberWord(40, "Forty"),
            new NumberWord(30, "Thirty"), new NumberWord(20, "Twenty"),
            new NumberWord(19, "Nineteen"), new NumberWord(18, "Eighteen"),
            new NumberWord(17, "Seventeen"), new NumberWord(16, "Sixteen"),
            new NumberWord(15, "Fifteen"), new NumberWord(14, "Fourteen"),
            new NumberWord(13, "Thirteen"), new NumberWord(12, "Twelve"),
            new NumberWord(11, "Eleven"), new NumberWord(10, "Ten"),
            new NumberWord(9, "Nine"), new NumberWord(8, "Eight"),
            new NumberWord(7, "Seven"), new NumberWord(6, "Six"),
            new NumberWord(5, "Five"), new NumberWord(4, "Four"),
            new NumberWord(3, "Three"), new NumberWord(2, "Two"),
            new NumberWord(1, "One")
    );

    //Time O(K) k - number of pairs, space O(log10 n)
    public String numberToWordsPairs(int num) {
        if (num == 0) {
            return "Zero";
        }

        for (NumberWord nw : numberToWordsList) {
            // Check if the number is greater than or equal to the current unit
            if (num >= nw.value) {
                // Convert the quotient to words if the current unit is 100 or greater
                String prefix = (num >= 100) ? numberToWords(num / nw.value) + " " : "";

                // Get the word for the current unit
                String unit = nw.word;

                // Convert the remainder to words if it's not zero
                String suffix = (num % nw.value == 0) ? "" : " " + numberToWords(num % nw.value);

                return prefix + unit + suffix;
            }
        }

        return "";
    }

    private static class NumberWord {
        int value;
        String word;

        NumberWord(int value, String word) {
            this.value = value;
            this.word = word;
        }
    }
}

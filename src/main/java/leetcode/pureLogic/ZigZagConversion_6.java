package leetcode.pureLogic;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 03.02.2023
 **/
public class ZigZagConversion_6 {

    private static final String EXPECTED = "PAHNAPLSIIGYIR";
    //cypher and decypher code
    public static void main(String[] args) {
        final String toDecypher = "PAYPALISHIRING";
        final String actual = convert(toDecypher, 3);

        assert EXPECTED.equals(actual);

    }

    private static String convert(final String s, final int numRows) {
        final List<String[]> columns = new ArrayList<>();

        int counter = 0;
        while(counter < s.length()) {
            final String[] zig = new String[numRows];
            columns.add(zig);
            for(int i=0; i<numRows && counter<s.length(); i++) {
                zig[i] = "" + s.charAt(counter++);
            }
            int j = numRows-1-1;
            while (j > 0 && counter<s.length()) {
                final String[] zag = new String[numRows];
                columns.add(zag);
                zag[j--] = "" + s.charAt(counter++);
            }
        }

        final StringBuilder ans = new StringBuilder();
        for (int row=0; row<numRows; row++) {
            for(final String[] col : columns) {
                if(col[row] != null) {
                    ans.append(col[row]);
                }
            }
        }
        return ans.toString();
    }

    /**
     * String traversal. Time O(n). Space O(1).
     *
     * @param s
     * @param numRows
     * @return
     */
    private static String convertEfficient(final String s, final int numRows) {
        if (numRows == 1) {
            return s;
        }

        final StringBuilder answer = new StringBuilder();
        int n = s.length();
        int charsInSection = 2 * (numRows - 1);

        for (int currRow = 0; currRow < numRows; ++currRow) {
            int index = currRow;

            while (index < n) {
                answer.append(s.charAt(index));

                // If currRow is not the first or last row
                // then we have to add one more character of current section.
                if (currRow != 0 && currRow != numRows - 1) {
                    int charsInBetween = charsInSection - 2 * currRow;
                    int secondIndex = index + charsInBetween;

                    if (secondIndex < n) {
                        answer.append(s.charAt(secondIndex));
                    }
                }
                // Jump to same row's first character of next section.
                index += charsInSection;
            }
        }

        return answer.toString();
    }


}

package leetcode.structures;

import java.util.HashMap;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 19.09.2025
 **/
public class DesignSpreadsheet_3484 {

    public static void main(String[] args) {

    }

    private static class Spreadsheet {

        final int[][] array = new int[26][];

        public Spreadsheet(final int rows) {
            for(int i = 0; i < 26; i++) {
                array[i] = new int[rows + 1];
            }
        }

        public void setCell(final String cell, final int value) {
            final int row = cell.charAt(0) - 'A';
            final int col = Integer.parseInt(cell.substring(1));
            array[row][col] = value;
        }

        public void resetCell(final String cell) {
            setCell(cell, 0);
        }

        public int getValue(final String formula) {
            final String[] vals = formula.substring(1).split("\\+");
            int left = 0;
            if(Character.isDigit(vals[0].charAt(0))) {
                left = Integer.parseInt(vals[0]);
            } else {
                left = array[vals[0].charAt(0) - 'A'][Integer.parseInt(vals[0].substring(1))];
            }

            int right = 0;
            if(Character.isDigit(vals[1].charAt(0))) {
                right = Integer.parseInt(vals[1]);
            } else {
                right = array[vals[1].charAt(0) - 'A'][Integer.parseInt(vals[1].substring(1))];
            }
            return left + right;
        }
    }

    private static class SpreadsheetViaHashMap {
        final HashMap<String, Integer> mpp = new HashMap<>();

        public SpreadsheetViaHashMap(int rows) {
        }

        public void setCell(String cell, int value) {
            mpp.put(cell, value);
        }

        public void resetCell(String cell) {
            mpp.put(cell, 0);
        }

        public int getValue(String formula) {
            formula = formula.substring(1);
            for (int i = 0; i < formula.length(); i++) {
                if (formula.charAt(i) == '+') {
                    String s1 = formula.substring(0, i), s2 = formula.substring(i + 1);
                    int left = Character.isUpperCase(s1.charAt(0)) ? mpp.getOrDefault(s1, 0) : Integer.parseInt(s1);
                    int right = Character.isUpperCase(s2.charAt(0)) ? mpp.getOrDefault(s2, 0) : Integer.parseInt(s2);
                    return left + right;
                }
            }
            return 0;
        }
    }
}

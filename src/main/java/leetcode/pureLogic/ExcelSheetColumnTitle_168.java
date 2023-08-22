package leetcode.pureLogic;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 22.08.2023
 **/
public class ExcelSheetColumnTitle_168 {

    public static void main(String[] args) {
        System.out.println(convertToTitle(52));
    }

    public static String convertToTitle(int columnNumber) {
        final StringBuilder sb = new StringBuilder();
        while(columnNumber > 0) {
            columnNumber--;
            sb.append((char)('A' + columnNumber%26));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}

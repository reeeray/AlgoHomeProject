package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 03.05.2024
 **/
public class CompareVersionNumbers_165 {

    public static void main(String[] args) {
        compareVersion("1.01", "1.001");
    }

    public static int compareVersion(final String version1, final String version2) {
        final String[] reg1 = version1.split("\\.");
        final String[] reg2 = version2.split("\\.");
        int i = 0;
        while (i < reg1.length || i < reg2.length) {
            final int num1 = i < reg1.length ? toInt(reg1[i]) : 0;
            final int num2 = i < reg2.length ? toInt(reg2[i]) : 0;
            if(num1 == num2) {
                i++;
                continue;
            }
            return num1 > num2 ? 1 : -1;
        }
        return 0;
    }

    private static int toInt(final String s) {
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '0') {
                continue;
            }
            return Integer.valueOf(s.substring(i));
        }
        return 0;
    }
}

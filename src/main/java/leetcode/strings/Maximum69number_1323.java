package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 16.08.2025
 **/
public class Maximum69number_1323 {

    public static void main(String[] args) {

    }

    public static int maximum69Number(final int num) {
        String res = "" + num;
        for(int i = 0; i < res.length(); i++) {
            if(res.charAt(i) == '6') {
                return Integer.valueOf(res.substring(0, i) + '9' + res.substring(i + 1));
            }
        }
        return num;
    }
}

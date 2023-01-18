package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 17.01.2023
 **/
public class FlipStringToMonotoneIncreasing_926 {


    public static void main(String[] args) {

        System.out.println(minFlipsMonoIncrEfficient("00110"));
    }



    private static int minFlipsMonoIncrEfficient(final String s) {
    int m = 0;
        for (int i = 0; i < s.length(); ++i) {
        if (s.charAt(i) == '0') {
            ++m;
        }
    }
    int ans = m;
        for (int i = 0; i < s.length(); ++i) {
        if (s.charAt(i) == '0') {
            ans = Math.min(ans, --m);
        } else {
            ++m;
        }
    }
        return ans;
}

    private static int min = Integer.MAX_VALUE;

    //this solution is TLE(Time Limited Exception)
    private static int minFlipsMonoIncr(final String s) {
        if (s.charAt(0) == '1') {
            flip("0" + s.substring(1), 1, '0', 1);
        }
        flip(s, 1, s.charAt(0), 0);

        return min;
    }

    private static void flip(final String str, final int pos, final char type, final int changes) {
        if(pos == str.length()-1) {
            int chg = changes;
            if(str.charAt(pos) != type && type == '1') {
                chg += 1;
            }
            min = Math.min(min, chg);
            return;
        }
        if(str.charAt(pos) == type) {
            flip(str, pos+1, type, changes);
            return;
        } else {
            flip(str, pos+1, type, changes+1);
            if(type == '0') {
                flip(str, pos+1, '1', changes);
            }
        }
    }



}

package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 03.11.2024
 **/
public class RotateString_796 {

    public static void main(String[] args) {

    }

    public static boolean rotateString(final String s, final String goal) {
        if(s.length() != goal.length()) {
            return false;
        }
        if(goal.equals(s)) {
            return true;
        }
        for(int i=1; i<s.length(); i++) {
            if(goal.contains(s.substring(0, i)) && goal.contains(s.substring(i, s.length()))) {
                return true;
            }
        }
        return false;
    }
}

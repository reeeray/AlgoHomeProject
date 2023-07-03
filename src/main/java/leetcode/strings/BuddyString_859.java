package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 03.07.2023
 **/
public class BuddyString_859 {

    public static void main(String[] args) {
       assert false == buddyStrings("abac", "abad");
    }

    public static boolean buddyStrings(final String s, final String goal) {
        if(s.length() != goal.length()) {
            return false;
        }
        if(s.equals(goal)) {
            final int[] chars = new int[26];
            for(int i=0; i<goal.length(); i++) {
                if(++chars[s.charAt(i) - 'a'] == 2) {
                    return true;
                }
            }
            return false;
        }
        final char[] chars = new char[2];
        int count = 0;
        for(int i=0; i<goal.length(); i++) {
            if(s.charAt(i) != goal.charAt(i)) {
                if(count == 0) {
                    chars[0] = s.charAt(i);
                    chars[1] = goal.charAt(i);
                    count++;
                } else if(count == 1) {
                    if(chars[0] != goal.charAt(i) || chars[1] != s.charAt(i)) {
                        return false;
                    }
                    count++;
                } else {
                    return false;
                }
            }
        }
        return chars[1] != 0 && count == 2;
    }
}

package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 19.10.2023
 **/
public class BackspaceStringCompare_844 {

    public static void main(String[] args) {
        final String s = "nzp#o#g";
        final String t = "b#nzp#o#g";
        backspaceCompare(s, t);
    }

    public static boolean backspaceCompare(final String s, final String t) {
        int left = s.length() - 1;
        int right = t.length() - 1;

        while(left >= 0 || right >= 0) {
            left = findNextIndex(s, left);
            right = findNextIndex(t, right);
            if((left >= 0 && right < 0) || (right >= 0 && left < 0)) {
                return false;
            }
            if(left >= 0 && right >= 0 && s.charAt(left) != t.charAt(right)) {
                return false;
            }
            left --;
            right--;
        }
        return true;
    }

    private static int findNextIndex(final String s, final int index) {
        if(index < 0 || s.charAt(index) != '#') {
            return index;
        }

        int toSkip = 0;
        for(int i=index; i>= 0; i--) {
            if(s.charAt(i) == '#') {
                toSkip++;
                continue;
            }else if(toSkip > 0) {
                toSkip--;
                continue;
            } else {
                return i;
            }
        }
        return -1;
    }
}

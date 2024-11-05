package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 05.11.2024
 **/
public class MinNumberOfChangesToMakeBinaryStringBeautiful_2914 {

    public static void main(String[] args) {

    }

    //Space O(1) and Time O(n)
    public static int minChanges(final String s) {
        int count = 1;
        int changes = 0;
        char curr = s.charAt(0);
        for(int i=1; i<s.length(); i++) {
            if(count == 2) {
                count = 1;
                curr = s.charAt(i);
            } else if(curr == s.charAt(i)){
                count++;
            } else {
                count++;
                changes++;
            }
        }
        return changes;
    }

    //Space O(1) and Time O(n/2)
    public int minChangesOptimized(String s) {
        int minChangesRequired = 0;

        // Check pairs of characters (i, i+1) with step size 2
        for (int i = 0; i < s.length(); i += 2) {
            // If characters in current pair don't match,
            // we need one change to make them equal
            if (s.charAt(i) != s.charAt(i + 1)) {
                minChangesRequired++;
            }
        }

        return minChangesRequired;
    }
}

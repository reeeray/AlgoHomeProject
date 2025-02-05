package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 05.02.2025
 **/
public class CheckIfOneStringSwapCanMakeStringsEqual_1790 {

    public static void main(String[] args) {
        areAlmostEqual("bank", "kanb");
    }

    //Time O(n) and Space O(1)
    public static boolean areAlmostEqual(final String s1, final String s2) {
        if(s1.equals(s2)) {
            return true;
        }
        int counter = 0;
        char misMatchS1 = '_';
        char misMatchS2 = '_';
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                counter++;
                if(counter == 1) {
                    misMatchS1 = s1.charAt(i);
                    misMatchS2 = s2.charAt(i);
                } else if (counter > 2 || (counter == 2 && (misMatchS1 != s2.charAt(i) || misMatchS2 != s1.charAt(i)))) {
                    return false;
                }
            }
        }
        return counter == 2;
    }
}

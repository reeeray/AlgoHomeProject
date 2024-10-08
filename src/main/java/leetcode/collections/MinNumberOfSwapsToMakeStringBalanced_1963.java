package leetcode.collections;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 08.10.2024
 **/
public class MinNumberOfSwapsToMakeStringBalanced_1963 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(n)
    public static int minSwaps(final String s) {
        int counter = 0;
        int unbalanced = 0;
        for(final char c : s.toCharArray()) {
            if(c == '[') {
                counter++;
            } else {
                if(counter != 0) {
                    counter--;
                } else {
                    unbalanced++;
                }
            }
        }
        return (unbalanced + 1) / 2;
    }
}

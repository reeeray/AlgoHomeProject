package leetcode.strings;

import java.util.Stack;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 12.01.2025
 **/
public class CheckIfParenthesisStringCanBeValid_2116 {

    public static void main(String[] args) {

    }

    public static boolean canBeValid(final String s, final String locked) {
        if(s.length() % 2 != 0) {
            return false;
        }
        int counter = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                counter++;
            } else {
                if(counter > 0) {
                    counter--;
                } else if(locked.charAt(i) == '0') {
                    counter++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    //Time O(n) and Space O(1)
    public static boolean canBeValidOpt(final String s, final String locked) {
        final int length = s.length();
        // If length of string is odd, return false.
        if (length % 2 == 1) {
            return false;
        }
        int openBrackets = 0;
        int unlocked = 0;
        // Iterate through the string to handle '(' and ')'.
        for (int i = 0; i < length; i++) {
            if (locked.charAt(i) == '0') {
                unlocked++;
            } else if (s.charAt(i) == '(') {
                openBrackets++;
            } else if (s.charAt(i) == ')') {
                if (openBrackets > 0) {
                    openBrackets--;
                } else if (unlocked > 0) {
                    unlocked--;
                } else {
                    return false;
                }
            }
        }

        // Match remaining open brackets with unlocked characters.
        int balance = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0') {
                balance--;
                unlocked--;
            } else if (s.charAt(i) == '(') {
                balance++;
                openBrackets--;
            } else if (s.charAt(i) == ')') {
                balance--;
            }
            if (balance > 0) {
                return false;
            }
            if (unlocked == 0 && openBrackets == 0) {
                break;
            }
        }

        if (openBrackets > 0) {
            return false;
        }

        return true;
    }

    //Time O(n) and Space O(n)
    public boolean canBeValidSpaceNonOptimized(final String s, final String locked) {
        final int length = s.length();

        // If length of string is odd, return false.
        if (length % 2 == 1) {
            return false;
        }

        final Stack<Integer> openBrackets = new Stack<>();
        final Stack<Integer> unlocked = new Stack<>();

        // Iterate through the string to handle '(' and ')'
        for (int i = 0; i < length; i++) {
            if (locked.charAt(i) == '0') {
                unlocked.push(i);
            } else if (s.charAt(i) == '(') {
                openBrackets.push(i);
            } else if (s.charAt(i) == ')') {
                if (!openBrackets.empty()) {
                    openBrackets.pop();
                } else if (!unlocked.empty()) {
                    unlocked.pop();
                } else {
                    return false;
                }
            }
        }

        // Match remaining open brackets with unlocked characters
        while (
                !openBrackets.empty() &&
                        !unlocked.empty() &&
                        openBrackets.peek() < unlocked.peek()
        ) {
            openBrackets.pop();
            unlocked.pop();
        }

        if (!openBrackets.empty()) {
            return false;
        }

        return true;
    }
}

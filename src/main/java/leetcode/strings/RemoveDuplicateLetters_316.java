package leetcode.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 26.09.2023
 **/
public class RemoveDuplicateLetters_316 {

    public static void main(String[] args) {

    }

    //stack and greedy
    private static String removeDuplicateLetters(final String s) {
        final int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++){
            lastIndex[s.charAt(i) - 'a'] = i; // track the lastIndex of character presence
        }

        final boolean[] inStack = new boolean[26]; // keep track seen
        final Stack<Integer> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            if (inStack[curr]) continue; // if seen continue as we need to pick one char only
            while (!stack.isEmpty() && stack.peek() > curr && i < lastIndex[stack.peek()]){
                inStack[stack.pop()] = false; // pop out and mark unseen
            }
            stack.push(curr); // add into stack
            inStack[curr] = true; // mark seen
        }

        final StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append((char) (stack.pop() + 'a'));
        return sb.reverse().toString();
    }
}

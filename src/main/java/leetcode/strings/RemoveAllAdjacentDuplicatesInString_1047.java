package leetcode.strings;

import java.util.Stack;

/**
 * 1047. Remove All Adjacent Duplicates In String
 * You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
 * <p>
 * We repeatedly make duplicate removals on s until we no longer can.
 * <p>
 * Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
 * <p>
 * User : Shein G.A.{@reeeray}
 * Date : 28.06.2021
 **/
public class RemoveAllAdjacentDuplicatesInString_1047 {

    public static void main(String[] args) {
//        System.out.println(removeDuplicates("azxxzy"));
        System.out.println(removeDuplicates("aaaaaaaa"));
    }

    private static String removeDuplicates(final String s) {

        final Stack<Character> characterStack = new Stack<>();
        for (final char c : s.toCharArray())
            characterStack.push(c);
        final StringBuilder sb = new StringBuilder();
        while (!characterStack.isEmpty()) {
            final char last = characterStack.pop();
            if (characterStack.isEmpty()) {
                sb.append(last);
                break;
            }
            final char bLast = characterStack.pop();

            if (last != bLast) {
                sb.append(last);
                characterStack.push(bLast);
            } else if (!characterStack.isEmpty() && sb.length() != 0) {
                characterStack.push(sb.charAt(sb.length() - 1));
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.reverse().toString();
    }
}

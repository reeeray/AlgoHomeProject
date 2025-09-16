package leetcode.algos;

import java.util.List;
import java.util.Stack;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 16.09.2025
 **/
public class ReplaceNonCoprimeNumbersInArray_2197 {

    public static void main(String[] args) {

    }

    //Explanation : number are non-coprime if gcd == 1 (greater common divisor)
    public static List<Integer> replaceNonCoptimes(final int[] nums) {
        final Stack<Integer> stack = new Stack<>();
        for(int num : nums) {
            while (!stack.isEmpty()) {
                final int a = stack.peek();
                final int divisor = gcd(a, num);
                if(divisor == 1) {
                    break;
                }
                num = (stack.pop() / divisor) * num; // least common multiplier
            }
            stack.add(num);
        }
        return stack;
    }

    private static int gcd(final int a, final int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}

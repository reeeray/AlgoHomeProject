package leetcode.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Issue 60 Permutation Sequence [HARD].
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * <p>
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * <p>
 * Note:
 * <p>
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * <p>
 * User : Shein G.A.{@reeeray}
 * Date : 20.06.2020
 **/
public class PermutationSequence_60 {

    public static String solution(final int n, int k) {
        final int[] factorial = new int[n];
        factorial[0] = 1;
        final List<Integer> digits = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            factorial[i] = i * factorial[i - 1];
            digits.add(i);
        }
        digits.add(n);
        k--;
        final StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int index = k / factorial[i];
            sb.append(digits.remove(index));
            k = k % factorial[i];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(4, 9));
        assert solution(4, 9) == "2314";
    }
}

package leetcode.binarySuff;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 89. Gray code.
 * An n-bit gray code sequence is a sequence of 2n integers where:
 * <p>
 * Every integer is in the inclusive range [0, 2n - 1],
 * The first integer is 0,
 * An integer appears no more than once in the sequence,
 * The binary representation of every pair of adjacent integers differs by exactly one bit, and
 * The binary representation of the first and last integers differs by exactly one bit.
 * Given an integer n, return any valid n-bit gray code sequence.
 * User : Shein G.A.{@reeeray}
 * Date : 01.07.2021
 **/
public class GrayCode {

    public static void main(String[] args) {

        System.out.println(grayCode(2));

    }

    private static List<Integer> grayCode(final int n) {
        List<String> answer = new ArrayList<>();
        int counter = 0;

        if (n >= 0) {
            answer.add("0");
            counter++;
        }
        if (n >= 1) {
            answer.add("1");
            counter++;
        }

        while (counter <= n) {
            final List<String> temp = new ArrayList<>();
            for (int i = 0; i < answer.size(); i++)
                temp.add("0" + answer.get(i));
            for (int i = answer.size() - 1; i >= 0; i--)
                temp.add("1" + answer.get(i));

            answer = temp;
            counter++;
        }
        return answer.stream().map(v -> Integer.parseInt(v, 2)).collect(Collectors.toList());
    }
}

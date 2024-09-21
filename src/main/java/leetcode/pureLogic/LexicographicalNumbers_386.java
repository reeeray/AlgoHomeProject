package leetcode.pureLogic;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 21.09.2024
 **/
public class LexicographicalNumbers_386 {

    public static void main(String[] args) {

    }

    //Space O(1) and Time O(n)
    public List<Integer> lexicalOrder(int n) {
        final List<Integer> answer = new ArrayList<>();
        int currentNumber = 1;
        for (int i = 0; i < n; ++i) {
            answer.add(currentNumber);

            if (currentNumber * 10 <= n) {
                currentNumber *= 10;
            } else {
                while (currentNumber % 10 == 9 || currentNumber >= n) {
                    currentNumber /= 10;
                }
                currentNumber += 1;
            }
        }

        return answer;
    }
}

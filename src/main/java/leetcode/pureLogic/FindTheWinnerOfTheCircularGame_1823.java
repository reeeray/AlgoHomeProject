package leetcode.pureLogic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 08.07.2024
 **/
public class FindTheWinnerOfTheCircularGame_1823 {

    public static void main(String[] args) {
        findTheWinner(5, 2);
    }

    //Space O(n) and Time O(n*k) because of the shift operation in list
    public static int findTheWinner(final int n, final int k) {
        int index = 0;
        int size = n;
        final List<Integer> numbers = new ArrayList<>();
        for(int i=0; i<size; i++) {
            numbers.add(i+1);
        }
        for(int i=1; i<n; i++) {
            index = (index + k - 1) % size--;
            numbers.remove(index);
            index = index == size ? 0 : index;
        }
        return numbers.get(0);
    }

    //Time O(n*k) and Space O(n)
    public int findTheWinnerQueue(int n, int k) {
        // Initialize queue with n friends
        final Queue<Integer> circle = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            circle.add(i);
        }

        // Perform eliminations while more than 1 player remains
        while (circle.size() > 1) {
            // Process the first k-1 friends without eliminating them
            for (int i = 0; i < k - 1; i++) {
                circle.add(circle.remove());
            }
            // Eliminate the k-th friend
            circle.remove();
        }

        return circle.peek();
    }

    //Space O(1) and Time O(n)
    public int findTheWinnerMath(int n, int k) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + k) % i;
        }
        // add 1 to convert back to 1 indexing
        return ans + 1;
    }
}

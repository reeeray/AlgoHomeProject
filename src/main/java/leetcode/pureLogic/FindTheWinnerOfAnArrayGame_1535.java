package leetcode.pureLogic;

import java.util.*;
import java.util.stream.Collectors;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 05.11.2023
 **/
public class FindTheWinnerOfAnArrayGame_1535 {

    public static void main(String[] args) {
        final int[] input = {2,1,3,5,4,6,7};
        System.out.println(getWinner(input, 2));
    }

    public static int getWinnerWithoutOverhead(final int[] arr, final int k) {
        int max = Arrays.stream(arr).max().orElse(-1);
        int curr = arr[0];
        int counter = 0;
        for(int i=1; i<arr.length; i++) {
            if(curr > arr[i]) {
                counter++;
            } else {
                curr = arr[i];
                counter = 1;
            }

            if(counter == k || curr == max) {
                return curr;
            }
        }
        return -1;
    }

    public static int getWinner(final int[] arr, final int k) {
        if(k > arr.length) {
            int max = arr[0];
            int index = 0;
            for(int i=1; i<arr.length; i++) {
                if(arr[i] > max) {
                    max = arr[i];
                    index = i;
                }
            }
            return max;
        }
        final Queue<Integer> queue = new LinkedList<>(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        final int[] game = new int[2];
        game[0] = queue.poll();
        game[1] = queue.poll();
        int left = 0;
        int right = 0;
        while (!(left == k || right == k)) {
            if(game[0] > game[1]) {
                left++;
                right = 0;
                queue.add(game[1]);
                game[1] = queue.poll();
            } else {
                right++;
                left = 0;
                queue.add(game[0]);
                game[0] = queue.poll();
            }
        }
        return left == k ? game[0] : game[1];
    }
}

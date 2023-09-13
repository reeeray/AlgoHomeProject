package leetcode.pureLogic;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 13.09.2023
 **/
public class Candy_135 {

    public static void main(String[] args) {

    }

    public static int candy(final int[] ratings) {
        if(ratings.length == 0) {
            return 0;
        }

        int ret = 1, up = 0, down = 0, peak = 0;

        for(int i=0; i<ratings.length - 1; i++) {
            int prev = ratings[i], curr = ratings[i+1];

            if (prev < curr) {
                up++;
                down = 0;
                peak = up;
                ret += up + 1;
            } else if (prev == curr) {
                up = 0;
                down = 0;
                peak = 0;
                ret++;
            } else {
                up = 0;
                down++;
                ret += down + 1;
                if(peak >= down) {
                    ret--;
                }
            }
        }
        return ret;
    }

    public static int candyGreedy(final int[] ratings) {
        final int n = ratings.length;
        final int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for(int i=1; i<n; i++) {
            if(ratings[i] > ratings[i-1]) {
                candies[i] = 1 + candies[i-1];
            }
        }

        for(int i=n-2; i>= 0; i--) {
            if(ratings[i] > ratings[i+1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        return Arrays.stream(candies).sum();
    }


}

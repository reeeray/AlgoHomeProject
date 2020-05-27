package books;

import java.util.Arrays;

/**
 * Knuth algorithm of shuffling
 * Complexity : O(N)
 * pick integer between 0 and i randomly and swap it. Shuffling is uniform.
 * При этом получаем равновероятное распределение, если менять каждый раз с рандомным числом из 0 до N - 1,
 * то это не будет равновероятным распределением.
 * User : gshein
 * Date : 24.05.2020
 **/
public class Shuffling {

    public static void shuffl(final Comparable[] array) {
        int N = array.length;

        for(int i=0; i < N; i++) {
            int random = 0 + (int)(Math.random() * ((i - 0)) + 1);
            Util.exchange(array, i, random);
        }
    }

    public static void main(String[] args) {
        final Integer[] array = new Integer[] {2, 4, 7, 9, 13, 15, 17};

        shuffl(array);
        System.out.println(Arrays.toString(array));
    }
}

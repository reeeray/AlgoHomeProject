package books;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Radix sort algorithm
 * It takes linear time!
 * User : gshein
 * Date : 25.05.2020
 **/
public class Radix {


    public static void main(String[] args) {
        int[] array = {100, 54, 355, 102, 43, 10, 287, 005};
        final int RADIX = 10;
        ArrayList<Integer> arrayBuckets []= new ArrayList[RADIX];

        for(int i = 0; i < arrayBuckets.length; i++) {
            arrayBuckets[i] = new ArrayList<>();
        }

        boolean maxDigitsLengthReached = false;
        int temp = -1, placeValue = 1;
        while (!maxDigitsLengthReached) {
            maxDigitsLengthReached = true;
            for (Integer element : array) {
                temp = element / placeValue;
                arrayBuckets[temp%RADIX].add(element);
                if(maxDigitsLengthReached && temp > 0) {
                    maxDigitsLengthReached = false;
                }
            }
            int a = 0;
            for (int b = 0; b < RADIX; b++) {
                for(Integer i : arrayBuckets[b]) {
                    array[a++] = i;
                }
                arrayBuckets[b].clear();
            }
            placeValue = placeValue * RADIX;
        }
        Arrays.stream(array).forEach(System.out::println);


    }
}

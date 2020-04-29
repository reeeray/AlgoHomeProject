package books;

import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Shein G.A. at 27.04.20
 **/
public class GreedyAlgorithms {

    //common complexity : O(n*log(n)) + O(n) => O(n*log(n))
    public static int maxNumber(final int[] numbers) {
/*        //at each step we are choosing max number and then concatenate
        Arrays.sort(numbers); //O(n*log(n))
        String res = "";
        for (int i = numbers.length - 1; i >= 0; i--) {
            res+=numbers[i];
        }//O(n)
        return Integer.parseInt(res);*/
        return Integer.parseInt(String.join("", Arrays.stream(numbers).boxed()
                        .sorted(Collections.reverseOrder())
                        .map(String::valueOf)
                        .toArray(String[]::new)));
    }

    //returns -1 when it's impossible to ride between stops
    public static int minStops(final int[] stops, final int capacity) {
        int res = 0;
        int currentStop = 0;

        while (currentStop < stops.length - 1) {
            int nextStop = currentStop;

            while (nextStop < stops.length - 1 &&
                        stops[nextStop + 1] - stops[currentStop] <= capacity)
                nextStop++;

            if(currentStop == nextStop)
                return -1;

            if(nextStop < stops.length - 1)
                res++;

            currentStop = nextStop;
        }

        return res;
    }

    //Task "Fractional knapsack". It is also exists task "Discrete knapsack" but you can not solve it with Greedy algorithm approach you should solve it with Dynamic programming
    public static int getOPtimalValues (final Stuff[] stuffs, final int capacity) {
        Arrays.sort(stuffs, Comparator.comparingDouble(Stuff::getValuePerUnitOfWeight).reversed());

        int weightSoFar = 0;
        int valueSoFar = 0;
        int currentItem = 0;

        while(weightSoFar != capacity && currentItem < stuffs.length) {
            if(weightSoFar + stuffs[currentItem].getWeight() <= capacity) {
                weightSoFar += stuffs[currentItem].getWeight();
                valueSoFar += stuffs[currentItem].getValue();
                System.out.println("Get full stuff " + stuffs[currentItem]);
            } else {
                valueSoFar += ((capacity - weightSoFar) / (double)stuffs[currentItem].getWeight()) * stuffs[currentItem].getValue();
                System.out.println("Take " + ((capacity - weightSoFar) / (double)stuffs[currentItem].getWeight()) + " part from " + stuffs[currentItem]);
                weightSoFar = capacity;
            }
            currentItem++;
        }

        return valueSoFar;
    }

    public static class Stuff {
        @Getter
        final int weight;
        @Getter
        final int value;

        public Stuff (final int weight, final int value) {
            this.weight = weight;
            this.value = value;
        }

        public double getValuePerUnitOfWeight () {
            return value / (double) weight;
        }

        @Override
        public String toString() {
            return "{ w : " + weight + " , v : " + value + " }";
        }


    }
}

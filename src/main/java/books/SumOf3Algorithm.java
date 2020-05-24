package books;

/**
 * 3-Sum Algorithm. Given N distinct integers, how many triples sum to exactly zero?
 * User : gshein
 * Date : 24.05.2020
 **/
public class SumOf3Algorithm {

    //N^2 time: given an integer x and a sorted array a[] of
    //n distinct integers, design a linear-time algorithm to determine if there exists two distinct indices i and j
    //such that a[i] + a[j] == x.


    //We can create algo with N^2 * log(N) if we will sort algo and then use binary search
    //For each pair of numbers a[i] and a[j], binary search for -(a[i] + a[j])

    /**
     * Bruit force solution of the 3-Sum problem.
     * It takes N^3 algorithm complexity. It's not applicable.
     * @param array
     * @return
     */
    public static int bruitForceSolution(final int[] array) {
        final int len = array.length;
        int counter = 0;

        for(int i=0; i<len; i++) {
            for(int j=i+1; j<len; j++) {
                for(int k=j+1; k<len; j++) {
                    if(array[i] + array[j] + array[k] == 0) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }
}

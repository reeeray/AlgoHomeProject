package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 29.10.2023
 **/
public class PoorPigs_458 {

    public static void main(String[] args) {

    }

    public static int poorPigs(final int buckets, final int minutesToDie, final int minutesToTest) {
//        final int nrOfStates = minutesToTest / minutesToDie + 1;
//        int pigs = 0;
//        while(Math.pow(nrOfStates, pigs) < buckets) {
//                pigs++;
//        }
//        return pigs;
        final int testsPerPig = minutesToTest / minutesToDie;
        int states = 1; // number of uniqe states a pig can represent
        int pigNumber = 0;
        while(states < buckets) {
            states *= testsPerPig + 1;
            pigNumber++;
        }
        return pigNumber;
    }
}

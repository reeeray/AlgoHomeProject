package leetcode.binaryStuff;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 29.05.2024
 **/
public class NumberOfStepsToReduceANumberInBinaryReprToOne_1404 {

    public static void main(String[] args) {
        numSteps("1101");
    }

    public static int numStepsAlternative(final String s) {
        int res = 0;
        int val = Integer.valueOf(s, 2);
        while(val != 1) {
            if(val % 2 == 0) val /= 2;
            else val++;
            res++;
        }
        return res;
    }

    //Greedy Time O(n) and Space O(1)
    public int numStepsSimilarToNext(String s) {
        final int N = s.length();

        int operations = 0;
        int carry = 0;
        for (int i = N - 1; i > 0; i--) {
            int digit = Character.getNumericValue(s.charAt(i)) + carry;

            if (digit % 2 == 1) {
                operations += 2;
                carry = 1;
            } else {
                operations++;
            }
        }

        return operations + carry;
    }

    public static int numSteps(final String s) {
        int total = 0;
        int numberOfOnes = 0;
        for(int i=s.length()-1; i>0; i--) {
            boolean isOne = s.charAt(i) == '1';
            if(numberOfOnes != 0) {
                isOne = !isOne;
                if(isOne) {
                    numberOfOnes--;
                }
            }
            if(isOne) {
                total+=2;
                numberOfOnes++;
            } else {
                total++;
            }
        }
        return numberOfOnes == 0 ? total : total + 1;
    }
}

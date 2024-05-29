package leetcode.binaryStuff;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 29.05.2024
 **/
public class NumberOfStepsToReduceANumberInBinaryReprToOne_1404 {

    public static void main(String[] args) {
        numSteps("1101");
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

package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 13.02.2023
 **/
public class CountOddNumberInAnInterval_1523 {

    public static void main(String[] args) {
        assert 2 == countOddNumber(17, 19);
    }

    private static int countOddNumber(int low, int high) {
        //let's be sure to start with odd number
        if((low & 1) == 1) {
            low++;
        }
        return low < high ? 0 : (high - low) / 2 + 1;
    }
}

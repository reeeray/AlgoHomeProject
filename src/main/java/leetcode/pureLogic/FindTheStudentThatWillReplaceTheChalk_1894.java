package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 02.09.2024
 **/
public class FindTheStudentThatWillReplaceTheChalk_1894 {

    public static void main(String[] args) {

    }

    //Time O(2n) and Space O(1)
    public static int chalkReplacer(final int[] chalk, final int k) {
        int sum = 0;
        for(int i=0; i<chalk.length; i++) {
            sum += chalk[i];
            if(sum > k) {
                return i;
            }
        }
        int currSum = 0;
        for(int i=0; i<chalk.length; i++) {
            currSum += chalk[i];
            if(currSum> k % sum) {
                return i;
            }
        }
        return -1;
    }
}

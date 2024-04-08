package leetcode.pureLogic;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 08.04.2024
 **/
public class NumberOfStudentsUnableToEatLunch_1700 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(1)
    public static int countStudents(final int[] students, final int[] sandwiches) {
        int zero = 0;
        int ones = 0;
        for(int student : students) {
            if(student == 0) {
                zero++;
            } else {
                ones++;
            }
        }
        for(int i=0; i<sandwiches.length; i++) {
            if(zero != 0 && sandwiches[i] == 0) {
                zero--;
            } else if(ones != 0 && sandwiches[i] == 1) {
                ones--;
            } else {
                return sandwiches.length - i;
            }
        }
        return 0;
    }
}

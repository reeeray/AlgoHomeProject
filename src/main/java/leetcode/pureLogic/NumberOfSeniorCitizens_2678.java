package leetcode.pureLogic;

import java.util.Arrays;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 01.08.2024
 **/
public class NumberOfSeniorCitizens_2678 {

    public static void main(String[] args) {

    }

    public static int countSeniors(final String[] details) {
//        return (int)Arrays.stream(details).filter(str -> (str.charAt(11) > '6' || str.charAt(11) == '6' && str.charAt(12) > '0')).count();
        int count = 0;
        for(final String str : details) {
            if(str.charAt(11) > '6' || (str.charAt(11) == '6' && str.charAt(12) > '0')) {
                count++;
            }
        }
        return count;
    }
}

package leetcode.pureLogic;

import patterns.creational.factory.Page;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 04.12.2023
 **/
public class Largest3SameDigitNumberInString_2264 {

    public static void main(String[] args) {
        assert "777" == largestGoodInteger("711133310755088231390684011112227777007142226669892017313336662051880002555771116");

    }

    public static String largestGoodInteger(final String num) {
        int left =0, right = 1;
        String max = "";
        while(right < num.length()) {
            if(num.charAt(left) == num.charAt(right)) {
                if(right - left == 2) {
                    final String str = num.substring(left, right+1);
//                    max = Math.max(max, Integer.valueOf(num.substring(left, right+1)));
                    max = max.compareTo(str) > 0 ? max : str;
                    left = right + 1;
                    right+=2;
                } else {
                    right++;
                }
            } else {
                left = right;
                right++;
            }
        }
        return max;
    }
}

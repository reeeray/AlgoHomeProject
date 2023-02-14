package leetcode.binaryStuff;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 14.02.2023
 **/
public class AddBinary_67 {

    public static void main(String[] args) {

//        System.out.println(fromString("1011"));
//        System.out.println(toString(22));
        System.out.println(addBinaryEff("1010", "1011"));
    }

    private static String addBinaryEff(final String a, final String b) {
        final StringBuilder answer = new StringBuilder();
        int leftover = 0;
        int aCounter = a.length()-1;
        int bCounter = b.length()-1;
        while(aCounter >= 0 || bCounter >= 0) {
            int sum = leftover;
            sum += aCounter >= 0 ?a.charAt(aCounter--) - '0' : 0;
            sum += bCounter >= 0 ? b.charAt(bCounter--) - '0' : 0;
            answer.append(sum%2);
            leftover= sum/2;
        }
        if(leftover != 0) {
            answer.append(1);
        }
        return answer.reverse().toString();
    }

    private String addBinary(final String a, final String b) {
//        return Integer.toBinaryString(Integer.valueOf(a, 2) + Integer.valueOf(b, 2));
        return toString(fromString(a) + fromString(b));
    }

    private static String toString(int value) {
        if(value == 0) {
            return "0";
        }
        final StringBuilder answer = new StringBuilder();
        while (value != 1) {
            answer.append(value%2);
            value /=2;
        }
        answer.append("1");
        return answer.reverse().toString();
    }

    private static int fromString(final String str) {
        int asnw = 0;
        for(int i=0; i<str.length(); i++) {
            asnw += Integer.valueOf(str.charAt(i) - '0') * Math.pow(2, str.length() - i-1);
        }
        return asnw;
    }
}

package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 18.10.2022
 **/
public class CountAndSay_38 {

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
        assert countAndSay(4).equals("1211");
    }

    private static String countAndSay(int n) {
        if(n == 0)
            return "";

        String str = "1";
        while (n > 1) {
            int count = 1;
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<str.length(); i++) {
                if(i+1 < str.length() && str.charAt(i) == str.charAt(i+1)) {
                    count++;
                } else {
                    sb.append(count).append(str.charAt(i));
                    count = 1;
                }
            }
            n--;
            str = sb.toString();
        }



        return str;
    }
}

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

    //Time O(2^n) and Space O(2^n)
    private static String countAndSayElegant(final int n) {
        String res = "1";
        for(int i = 1; i < n; i++) {
            final StringBuilder sb = new StringBuilder();
            int count = 1;
            for(int j = 1; j < res.length(); j++) {
                if(res.charAt(j) == res.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count).append(res.charAt(j - 1));
                    count = 1;
                }
            }
            sb.append(count).append(res.charAt(res.length() - 1));
            res = sb.toString();
        }
        return res;
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

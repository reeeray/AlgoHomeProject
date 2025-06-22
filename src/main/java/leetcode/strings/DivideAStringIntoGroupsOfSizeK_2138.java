package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 22.06.2025
 **/
public class DivideAStringIntoGroupsOfSizeK_2138 {

    public static void main(String[] args) {
        divideString("abcdefghi", 3, 'x');
    }

    //Time O(n/k) and Space O(1)
    public static String[] divideString(final String s, final int k, final char fill) {
        final int numberOfBuckets = (s.length() / k ) + (s.length() % k == 0 ? 0 : 1);
        final String[] ans = new String[numberOfBuckets];
        for(int i = 0; i < numberOfBuckets - 1; i++) {
            ans[i] = s.substring(i*k, i*k + k);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(ans[numberOfBuckets - 1] = s.substring(k * (numberOfBuckets - 1)));
        if(s.length() % k != 0) {
          for(int i = 0; i < (k - (s.length()%k)); i++) {
              sb.append(fill);
          }
        }
        ans[numberOfBuckets - 1] = sb.toString();
        return ans;
    }
}

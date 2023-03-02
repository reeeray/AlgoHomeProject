package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 02.03.2023
 **/
public class StringCompression_443 {

    public static void main(String[] args) {
        final char[] input = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        compress(input);
    }

    private static int compress(char[] chars) {
        final StringBuilder sb = new StringBuilder();
        char curr = chars[0];
        int count = 0;
        for(final char c : chars) {
            if(curr == c) {
                count++;
            } else {
                sb.append(curr);
                curr = c;
                if(count > 1) {
                    sb.append(String.valueOf(count));
                }
                count = 1;
            }
        }
        sb.append(curr);
        if(count > 1) {
              sb.append(String.valueOf(count));
        }
        final String answer = sb.toString();
        return answer.length();
    }

    private static int compressWithoutExtraSpace(char[] chars) {
        char curr = chars[0];
        int count = 0;
        int length = 0;
        for(final char c : chars) {
            if(curr == c) {
                count++;
            } else {
                chars[length++] = curr;
                curr = c;
                if(count > 1) {
                    for(final char nc : String.valueOf(count).toCharArray()) {
                        chars[length++] = nc;
                    }
                }
                count = 1;
            }
        }
        chars[length++] = curr;
        if(count > 1) {
            for(final char nc : String.valueOf(count).toCharArray()) {
                chars[length++] = nc;
            }
        }
        return length;
    }
}

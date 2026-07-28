package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 28.07.2026
 **/
public class SmallestPalindromicRearragementI_3517 {

    public static void main(String[] args) {

    }

    //Time O(n) and Space O(1)
    public String smallestPalindromeMoreElegant(String s) {
        int partition = s.length() / 2;
        int[] bucket = new int[26];

        for (int i = 0; i < partition; i++) {
            bucket[s.charAt(i) - 'a'] += 1;
        }

        StringBuilder left = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (bucket[i] > 0) {
                left.append(String.valueOf((char) (i + 'a')).repeat(bucket[i]));
            }
        }

        String mid =
                s.length() % 2 != 0 ? String.valueOf(s.charAt(partition)) : "";
        String right = new StringBuilder(left).reverse().toString();

        return left.toString() + mid + right;
    }

    public static String smallestPalindrome(final String s) {
        final int[] count = new int[26];
        for(final char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        final StringBuilder sb = new StringBuilder();
        char odd = 'N';
        int index = 0;
        while(sb.length() <= s.length() / 2 && index < 26) {
            if(count[index] > 1) {
                sb.append((char)(index + 'a'));
                count[index]-=2;
            } else if (count[index] == 1) {
                odd = (char)(index + 'a');
                count[index]--;
            }
            if(count[index] == 0) index++;
        }
        if(s.length() % 2 != 0) {
            if(odd != 'N') sb.append(odd);
            else {
                for(int i = 0; i < 26; i++) {
                    if(count[i] == 1) sb.append((char)(i + 'a'));
                }
            }
        }
        final String straight = sb.toString();
        if (s.length() % 2 != 0) sb.setLength(sb.length() - 1);
        final String reversed = sb.reverse().toString();
        return straight + reversed;
    }
}

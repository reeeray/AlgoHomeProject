package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 13.01.2025
 **/
public class MinLengthOfStringAfterOperations_3223 {

    public static void main(String[] args) {
        System.out.println(minimumLength("ucvbutgkohgbcobqeyqwppbxqoynxeuuzouyvmydfhrprdbuzwqebwuiejoxsxdhbmuaiscalnteocghnlisxxawxgcjloevrdcj"));
    }

    //Time O(n) and Space O(1)
    public static int minimumLength(final String s) {
        final int[] chars = new int[26];
        for(final char c : s.toCharArray()) {
            chars[c - 'a']++;
        }
        int ans = 0;
        for(int i=0; i<26; i++) {
            ans += chars[i] < 3 ? chars[i] : chars[i] % 2 == 0 ? 2 : 1;
        }
        return ans;
    }
}

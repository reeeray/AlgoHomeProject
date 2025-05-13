package leetcode.strings;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 13.05.2025
 **/
public class TotalCharactersInStringAfterTransformationsI_3335 {

    public static void main(String[] args) {
        lengthAfterTransformations("azbk", 1);
    }

    //Space O(L) and Time O(n + t*L) where L the size of alphabet
    public static int lengthAfterTransformations(final String s, final int t) {
        final int MOD = (int)(1e9 + 7);
        final int[] lettersFrequency = new int[26];
        for(final char c : s.toCharArray()) {
            lettersFrequency[c - 'a']++;
        }
        for(int i = 0; i < t; i++) {
            int prevCount = lettersFrequency[0];
            lettersFrequency[0] = 0;
            for(int index = 1; index < 26; index++) {
                final int temp = lettersFrequency[index];
                lettersFrequency[index] = prevCount % MOD;
                if(index == 25) {
                    lettersFrequency[0] += temp;
                    lettersFrequency[1] += temp;
                }
                prevCount = temp;
            }
        }
        int res = 0;
        for(int i = 0; i < 26; i++) {
            res += (lettersFrequency[i] % MOD);
            res = res % MOD;
        }
        return res;
    }

    public int lengthAfterTransformationslESSoPTIMUM(String s, int t) {
        final int MOD = 1000000007;
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) {
            ++cnt[ch - 'a'];
        }
        for (int round = 0; round < t; ++round) {
            int[] nxt = new int[26];
            nxt[0] = cnt[25];
            nxt[1] = (cnt[25] + cnt[0]) % MOD;
            for (int i = 2; i < 26; ++i) {
                nxt[i] = cnt[i - 1];
            }
            cnt = nxt;
        }
        int ans = 0;
        for (int i = 0; i < 26; ++i) {
            ans = (ans + cnt[i]) % MOD;
        }
        return ans;
    }
}

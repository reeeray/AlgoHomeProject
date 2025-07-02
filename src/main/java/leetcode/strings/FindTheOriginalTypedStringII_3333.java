package leetcode.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 02.07.2025
 **/
public class FindTheOriginalTypedStringII_3333 {

    private static final int MOD = (int)(1e9) + 1;
    public static void main(String[] args) {
        possibleStringCount("aabbccdd", 7);
    }

    //Time O(n +k*k) and Space O(k)
    public static int possibleStringCount(final String word, final int k) {
        int left = 0, right = 0;
        final List<Integer> freq = new ArrayList<>();
        if(word.length() - k < 1) {
            return 1;
        }
        while(right < word.length()) {
            if(word.charAt(left) == word.charAt(right)) {
                right++;
            } else {
                freq.add(right - left);
                left = right++;
            }
        }
        freq.add(right - left);

        long ans = 1;
        for (int occur : freq) {
            ans = (ans * occur) % MOD;
        }
        if (freq.size() >= k) {
            return (int) ans;
        }

        int[] f = new int[k];
        int[] g = new int[k];
        f[0] = 1;
        Arrays.fill(g, 1);
        for (int i = 0; i < freq.size(); i++) {
            final int[] f_new = new int[k];
            for (int j = 1; j < k; j++) {
                f_new[j] = g[j - 1];
                if (j - freq.get(i) - 1 >= 0) {
                    f_new[j] = (f_new[j] - g[j - freq.get(i) - 1] + MOD) % MOD;
                }
            }
            final int[] g_new = new int[k];
            g_new[0] = f_new[0];
            for (int j = 1; j < k; ++j) {
                g_new[j] = (g_new[j - 1] + f_new[j]) % MOD;
            }
            f = f_new;
            g = g_new;
        }

        return (int) ((ans - g[k - 1] + MOD) % MOD);
    }
}

package leetcode.strings;

/**
 * 1220. Count Vowels Permutation.
 * <p>
 * Given an integer n, your task is to count how many strings of length n can be formed under the following rules:
 * <p>
 * Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
 * Each vowel 'a' may only be followed by an 'e'.
 * Each vowel 'e' may only be followed by an 'a' or an 'i'.
 * Each vowel 'i' may not be followed by another 'i'.
 * Each vowel 'o' may only be followed by an 'i' or a 'u'.
 * Each vowel 'u' may only be followed by an 'a'.
 * Since the answer may be too large, return it modulo 10^9 + 7.
 * <p>
 * User : Shein G.A.{@reeeray}
 * Date : 04.07.2021
 **/
public class CountVowelsPermutation_1220 {

    public static void main(String[] args) {
        assert countVowelPermutation(5) == 68;
        System.out.println(countVowelPermutation(5));
    }

    private static int countVowelPermutation(final int n) {
        final int MOD = (int) (1e9 + 7);

        final long[][] dp = new long[n + 1][5];
        //rule mapping {a(0), e(1), i(2), o(3), u(4)}
        final int[][] rule = new int[][]{
                {1}, //means that 'a' can be followed only by 'e'
                {0, 2}, //means that 'e' can be followed only by 'a' or 'i'
                {0, 1, 3, 4}, //means that 'i' can be followed by any other vowel letter 'a', 'e', 'o', 'u'
                {2, 4}, //means that 'o' can be followed only by 'i' or 'u'
                {0} // means that 'u' can be followed only by 'a'
        };

        for (int i = 0; i < 5; i++) {
            dp[1][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                dp[i + 1][j] = 0;
                for (int v : rule[j]) {
                    dp[i + 1][j] += dp[i][v] % MOD;
                }
            }
        }

        long res = 0;
        for (int i = 0; i < 5; i++) {
            res = (res + dp[n][i]) % MOD;
        }
        return (int) res;
    }
}

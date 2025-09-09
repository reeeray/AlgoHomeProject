package leetcode.pureLogic;

import java.util.Deque;
import java.util.LinkedList;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 09.09.2025
 **/
public class NumberOfPeopleAwareOfASecret_2327 {

    public static void main(String[] args) {
        peopleAwareOfSecret(6, 2, 4);
    }

    //optimized solution
    //Time O(n) and Space O(n)
    public int peopleAwareOfSecretOpt(int n, int delay, int forget) {
        final int MOD = (int)1e9 + 7;
        final Deque<int[]> know = new LinkedList<>();
        final Deque<int[]> share = new LinkedList<>();
        know.add(new int[] { 1, 1 });
        int knowCnt = 1;
        int shareCnt = 0;

        for (int i = 2; i <= n; i++) {
            if (!know.isEmpty() && know.peekFirst()[0] == i - delay) {
                final int[] first = know.pollFirst();
                knowCnt = (knowCnt - first[1] + MOD) % MOD;
                shareCnt = (shareCnt + first[1]) % MOD;
                share.add(first);
            }
            if (!share.isEmpty() && share.peekFirst()[0] == i - forget) {
                final int[] first = share.pollFirst();
                shareCnt = (shareCnt - first[1] + MOD) % MOD;
            }
            if (!share.isEmpty()) {
                knowCnt = (knowCnt + shareCnt) % MOD;
                know.add(new int[] { i, shareCnt });
            }
        }
        return (knowCnt + shareCnt) % MOD;
    }

    public int peopleAwareOfSecretWorkingSolution(int n, int delay, int forget) {
        final int MOD = 1_000_000_007;
        final int[] dp = new int[n + 1];
        dp[1] = 1;
        long sum = 0;

        for (int day = 2; day <= n; day++) {
            if (day - delay >= 1) {
                sum = (sum + dp[day - delay]) % MOD;
            }
            if (day - forget >= 1) {
                sum = (sum - dp[day - forget] + MOD) % MOD;
            }
            dp[day] = (int) sum;
        }

        long ans = 0;
        for (int i = n - forget + 1; i <= n; i++) {
            if (i >= 1) ans = (ans + dp[i]) % MOD;
        }

        return (int) ans;
    }

    //There is an error somewhere
    //complexity Time O(n*n) and space O(n)
    public static int peopleAwareOfSecret(final int n, final int delay, final int forget) {
        final int MOD = (int)1e9 + 7;
        final int[] container = new int[forget];
        container[0] = 1;
        int res = 0;
        for(int i = 1; i < n; i++) {
            int tmp = container[0];
            container[0] = 0;
            for(int idx = 1; idx < forget; idx++) {
                final int t = container[idx];
                container[idx] = tmp;
                tmp = t;
                if(idx >= delay) {
                    container[0] += container[idx];
                }
            }
        }
        for(int i = 0; i < forget; i++) {
            res = (res + container[i]) % MOD;
        }
        return res;
    }
}

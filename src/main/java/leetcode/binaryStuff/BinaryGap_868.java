package leetcode.binaryStuff;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 22.02.2026
 **/
public class BinaryGap_868 {

    public static void main(String[] args) {

    }

    //Time O(logn) and Space O(1)
    public int binaryGapOpt2(int N) {
        int last = -1, ans = 0;
        for (int i = 0; i < 32; ++i)
            if (((N >> i) & 1) > 0) {
                if (last >= 0)
                    ans = Math.max(ans, i - last);
                last = i;
            }

        return ans;
    }

    //Space O(n) and Time O(logn)
    public int binartGapOpt(int n) {
        int res = 0;
        int count = 0;
        while (n > 0) {
            if(n % 2 == 1) {
                res = Math.max(res, count);
                count = 1;
            } else if(n % 2 == 0 && count != 0) {
                count++;
            }
            n /= 2;
        }
        return res;
    }

    public int binaryGap(final int n) {
        final String bits = Integer.toBinaryString(n);
        int left = 0;
        int right = 1;
        int res = 0;
        while(right < bits.length()) {
            if(bits.charAt(right) == '1') {
                res = Math.max(res, right - left);
                left =right;
            }
            right++;
        }
        return res;
    }
}

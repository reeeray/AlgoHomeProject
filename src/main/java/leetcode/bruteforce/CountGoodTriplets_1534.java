package leetcode.bruteforce;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 14.04.2025
 **/
public class CountGoodTriplets_1534 {

    public static void main(String[] args) {

    }

    //Time O(n^3) and Space O(1)
    public static int countGoodTriplets(final int[] arr, final int a, final int b, final int c) {
        int res = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(Math.abs(arr[i] - arr[j]) > a) {
                    continue;
                }
                for(int k = j + 1; k < arr.length; k++) {
                    if(Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    //Time O(n^2 + nS) and Space O(S) where S - is the upper limit of array values
    public int countGoodTripletsOpt(int[] arr, int a, int b, int c) {
        int ans = 0, n = arr.length;
        int[] sum = new int[1001];
        for (int j = 0; j < n; ++j) {
            for (int k = j + 1; k < n; ++k) {
                if (Math.abs(arr[j] - arr[k]) <= b) {
                    int lj = arr[j] - a, rj = arr[j] + a;
                    int lk = arr[k] - c, rk = arr[k] + c;
                    int l = Math.max(0, Math.max(lj, lk)), r = Math.min(
                            1000,
                            Math.min(rj, rk)
                    );
                    if (l <= r) {
                        if (l == 0) {
                            ans += sum[r];
                        } else {
                            ans += sum[r] - sum[l - 1];
                        }
                    }
                }
            }
            for (int k = arr[j]; k <= 1000; ++k) {
                ++sum[k];
            }
        }
        return ans;
    }
}
